package visao;

import controle.ControleAgencia;
import controle.ControleCadastro;
import controle.ControleCliente;
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
    private static final Logger LOGGER = Logger.getLogger("visaoCliente");

    public VisaoCliente(){
        scan = new Scanner(System.in);
        controleCli = new ControleCliente();
        controleAg = new ControleAgencia();
        controleC = new ControleCadastro();
    }

    public boolean cadastrarCliente() throws SQLException {
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

    public Cliente loginCliente() throws SQLException {
        System.out.println("Digite seu CPF:");
        String CPF = scan.next();
        System.out.println("Digite senha:");
        String senha = scan.next();
        this.cliente = controleCli.login(CPF, senha);
        if (this.cliente == null) {
            LOGGER.info("Senha ou CPF incorretos!!");
            return this.loginCliente();
        }
        LOGGER.info("Login efetuado com sucesso!");
        return this.cliente;
    }

    public int interfaceUsuario(){
        System.out.println("========================");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - pix");
        System.out.println("4 - Fazer emprestimo");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Dados do usuario");
        //verificar saldo
        System.out.println("7 - Sair");
        System.out.println("========================");
        System.out.print("Opcao: ");
        return scanInt();

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
    public Cliente retonarCliente(String cpf){
        return controleCli.retornaCliente(cpf);
    }

}
