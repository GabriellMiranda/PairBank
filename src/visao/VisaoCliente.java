package visao;

import controle.*;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class VisaoCliente {

    private Scanner scan;
    private Cliente cliente;
    private ControleCliente controleCli;
    private ControleAgencia controleAg;
    private ControleCadastro controleC;
    private ControleGerente controleG;
    private static final Logger LOGGER = Logger.getLogger("visaoCliente");

    public VisaoCliente(){
        scan = new Scanner(System.in);
        controleCli = new ControleCliente();
        controleAg = new ControleAgencia();
        controleC = new ControleCadastro();
        controleG = new ControleGerente();
    }

    public boolean cadastrarCliente()  {
        String[] tiposDeConta = new String[]{"corrente","poupança"};
        VisaoPessoa pessoaview = new VisaoPessoa();
        System.out.println("Escolha uma senha:");
        String senha = scan.nextLine();
        if(controleC.SENHA(senha)) {
            System.out.println("Escolha o tipo de conta |||  OP[1]: Corrente | OP[2]: Poupança:"); // exceção
            System.out.print("OP: ");
            int opcao = scanInt();
            if(opcao == 0){
                return cadastrarCliente();
            }
            else if (opcao != 1 && opcao != 2) {
                System.out.println("Opção de conta não existente! Escolha 1 para corrente e 2 para poupança!");
                return false;
            }
            else {
                Pessoa nova = pessoaview.cadastrarPessoa();
                if(nova == null){
                    return false;
                }
                Date dataHoraAtual = new Date();
                String dia = new SimpleDateFormat("dd").format(dataHoraAtual);
                String mes = new SimpleDateFormat("MM").format(dataHoraAtual);
                String ano = new SimpleDateFormat("yyyy").format(dataHoraAtual);
                return controleCli.cadastroCliente(controleAg.getAgencia(), controleCli.getNewNumConta(), senha, tiposDeConta[opcao-1], nova.getNome(), nova.getCpf(),
                        nova.getDiaNascimento(), nova.getMesNascimento(), nova.getAnoNascimento(),
                        Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(ano));
            }
        }
        return false;
    }
    // fazendo o login de um cliente
    public Cliente loginCliente()  {
        System.out.println("Digite seu CPF:");
        String CPF = scan.next();
        System.out.println("Digite senha:");
        String senha = scan.next();
        this.cliente = controleCli.login(CPF, senha); //
        if (this.cliente == null) {
            LOGGER.info("Senha ou CPF incorretos!!");
            return null;
        }
        LOGGER.info("Login efetuado com sucesso!");
        return this.cliente;
    }
    //interface usuário falta implementa o saldo
    public int interfaceUsuario(){
        System.out.println("========================");
        System.out.println("0 - Sair");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - pix");
        System.out.println("4 - Simular emprestimo");
        System.out.println("5 - Dados do usuario e saldo");
        System.out.println("6 - Extrato");
        System.out.println("7 - infomações e dúvidas");
        System.out.println("========================");
        System.out.print("Opcao: ");
        return scanInt();

    }
   // menu cliente login
    public void menuLoginCliente() {
        String numero = " ";
        int opcao;
        double valor;
        Cliente cliente = loginCliente();
        if(cliente == null){
            return;
        }
        VisaoContaCorrente controle = new VisaoContaCorrente();
        while(true) {
            opcao = interfaceUsuario();
            if(opcao == 0){
                break;
            }
            else if(opcao == 1){ //Fazendo o saque na conta corrente
                controle.sacar(cliente.contaCorrente);
            }else if(opcao == 2){//Fazendo o deposito na conta corrente
                controle.depositar(cliente.getCpf(), cliente.contaCorrente);
            }else if(opcao == 3){// fazer pix para outro usuário
                this.fazerPix(cliente);
            }else if(opcao == 4){ // fazer emprestimo
                System.out.println("falta implementar");
            }else if(opcao == 5) {// dados do usuário e seu saldo
                System.out.println(cliente);
            }else if(opcao == 6) {// extrato bancario
                //vou criar uma lista com os dados e toda vez que o usuário digitar essa opção atualizo essa lista no bd
                System.out.println("falta implementar");
            }else if(opcao == 7){
              String[] info = controleG.obterInfoGerente(this.cliente.getAgencia()).split("-");
                System.out.println("Para resolver qualquer problema, conusulte seu gerente "+info[0] +" no telefone: "+info[1]);
            }
        }
    }
    public void fazerPix(Cliente cliente){
        double valor = 0;
        String cpf = new String();
        try {
            System.out.println("Digite o numero do CPF:");
             cpf = scan.next();
            if(!controleCli.verificandoExistenciaCliente(cpf)){
                System.err.println("O CPF digitado não existe!!");
                return;
            }

        }catch (Exception ee){
            System.err.println(ee.getMessage());
        }
        try {
            System.out.println("Digite o valor que você deseja transferir");
            valor = scan.nextInt();
        }
        catch (InputMismatchException ime){
            System.err.println("transferência invalida!!, digite apenas números");
            scan.nextLine();
            return;
        }
        ControleContaCorrente controle = new ControleContaCorrente();
        boolean x = controle.subtraiValor(valor, cliente.getCpf(),cliente.contaCorrente);
        if(x == true){
            controle.efetuarPix(valor, cpf);
            System.out.println("pix efetuado com sucesso!!");
            return;
        }else{
            System.out.println("Você não tem saldo disponível!!");
        }
    }
    public int scanInt(){
        try {
            return scan.nextInt();
        }
        catch (InputMismatchException ime){
            System.out.println("A opção deve ser um inteiro!!!");
            scan.nextLine();
            return 0;
        }
    }


}
