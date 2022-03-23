package visao;

import controle.*;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class VisaoCliente {

    private Scanner scan;
    private Cliente cliente;
    private ControleCliente controleCli;
    private ControleAgencia controleAg;
    private ControleCadastro controleC;
    private ControleGerente controleG;
    private ControleContaCorrente contaCorrente;
    private static final Logger LOGGER = Logger.getLogger("visaoCliente");

    public VisaoCliente(){
        scan = new Scanner(System.in);
        controleCli = new ControleCliente();
        controleAg = new ControleAgencia();
        controleC = new ControleCadastro();
        controleG = new ControleGerente();
        contaCorrente = new ControleContaCorrente();
    }

    public boolean cadastrarCliente()  {
        String[] tiposDeConta = new String[]{"corrente","poupança"};
        VisaoPessoa pessoaview = new VisaoPessoa();
        System.out.println("Escolha uma senha:");
        String senha = scan.nextLine();
        if(controleC.SENHA(senha.split(""))) {
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
                String numeroAgencia = controleAg.getAgencia();
                return controleCli.cadastroCliente(0, numeroAgencia, controleCli.getNewNumConta(numeroAgencia), senha, tiposDeConta[opcao-1], nova.getNome(), nova.getCpf(),
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
        System.out.println("5 - Saldo em conta");
        System.out.println("6 - Extrato");
        System.out.println("7 - infomações e dúvidas");
        System.out.println("8 - Dados do Usuario");
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
        VisaoContaCorrente controleCorrente = new VisaoContaCorrente();
        VisaoContaPoupanca controlePoupanca = new VisaoContaPoupanca();
        while(true) {
            opcao = interfaceUsuario();
            if(opcao == 0){
                break;
            }
            else if(opcao == 1){ //Fazendo o saque na conta corrente ou poupança
                if(Objects.equals(cliente.getTipodeConta(), "corrente")){
                    controleCorrente.sacar(cliente.contaCorrente, cliente.getCpf());
                }else if(Objects.equals(cliente.getTipodeConta(), "poupanca")){
                    controlePoupanca.sacar(cliente.getCpf(), cliente.contaPoupanca);
                }
            }else if(opcao == 2){//Fazendo o deposito na conta corrente
                if(Objects.equals(cliente.getTipodeConta(), "corrente")) {
                    controleCorrente.depositar(cliente.getCpf(), cliente.contaCorrente);
                }else if(Objects.equals(cliente.getTipodeConta(), "poupanca")){
                     controlePoupanca.depositar(cliente.getCpf(), cliente.contaPoupanca);
                }
            }else if(opcao == 3){// fazer pix para outro usuário
                this.fazerPix(cliente);
            }else if(opcao == 4){ // fazer emprestimo
                if(Objects.equals(cliente.getTipodeConta(), "corrente")){
                    double emprestimoObtido = controleCli.simularEmprestimo(cliente);
                    System.out.println("Caro cliente, o seu emprestimo foi aprovado no valor de "+emprestimoObtido);
                    System.out.println("Deseja receber o emprestimo em sua conta ? (s/n)");
                    String opt = scan.next();
                    if(opt.equals("s")){
                        contaCorrente.Deposito(emprestimoObtido,cliente.getCpf(),cliente.contaCorrente);
                    }
                    else if(opt.equals("n")){
                        System.out.println("É uma pena que não queira esta regalia, espero que dê tudo certo!");
                    }
                    else{
                        System.err.println("Opção inválida!");
                    }
                }else{
                    System.err.println("Somente usuários que possuem conta corrente podem fazer emprestimos!!");
                }
            }else if(opcao == 5) {// dados do usuário e seu saldo
                if(Objects.equals(cliente.getTipodeConta(), "corrente")) {
                    System.out.println("Salo em conta:"+cliente.contaCorrente.getValor());
                }else if(Objects.equals(cliente.getTipodeConta(), "poupanca")){
                    System.out.println("Saldo em conta:"+cliente.contaPoupanca.getValor());
                }
            }else if(opcao == 6) {// extrato bancario
                ControleExtrato controleExtrato = new ControleExtrato();
                controleExtrato.verificarExtrato(cliente.getCpf());
            }else if(opcao == 7){
                String[] info = controleG.obterInfoGerente(this.cliente.getAgencia()).split("-");
                System.out.println("Para resolver qualquer problema, conusulte seu gerente "+info[0] +" no telefone: "+info[1]);
            }else if(opcao == 8){
                System.out.println(cliente);
            }
        }
    }
    public void fazerPix(Cliente cliente) {
        double valor = 0;
        String cpf = new String();
        String tipoConta = new String();
        try {
            System.out.println("Digite o numero do CPF:");
            cpf = scan.next();
            tipoConta = controleCli.verificandoExistenciaCliente(cpf);
            if (tipoConta == null) {
                System.err.println("O CPF digitado não existe!!");
                return;
            }
        } catch (Exception ee) {
            System.err.println(ee.getMessage());
        }
        try {
            System.out.println("Digite o valor que você deseja transferir");
            valor = scan.nextInt();
        } catch (InputMismatchException ime) {
            System.err.println("transferência invalida!!, digite apenas números");
            scan.nextLine();
            return;
        }

        boolean x = false;
        if (Objects.equals(tipoConta, "corrente")) {
            ControleContaCorrente controleC = new ControleContaCorrente();
            x = controleC.subtraiValor(valor, cliente.getCpf(), cliente.contaCorrente);
            if (x) {
                controleC.efetuarPix(valor, cpf);
                System.out.println("pix efetuado com sucesso!!");
            } else {
                System.out.println("Você não tem saldo disponível!!");
            }
        } else if (Objects.equals(tipoConta, "poupanca")) {
            ControleContaPoupanca controleP = new ControleContaPoupanca();
            x = controleP.subtraiValor(valor, cliente.getCpf(),cliente.contaPoupanca);
            if (x) {
                 controleP.efetuarPix(valor, cpf, tipoConta);
                System.out.println("pix efetuado com sucesso!!");
            } else {
                System.out.println("Você não tem saldo disponível!!");
            }
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
