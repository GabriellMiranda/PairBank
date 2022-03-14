package visao;

import Dao.GerenteDao;
import controle.ControleGerente;
import modelo.Cliente;
import modelo.Gerente;

import java.util.Scanner;

public class VisaoGerente {

    private Scanner scan;
    private ControleGerente controleGerente;

    public VisaoGerente(){
        scan = new Scanner(System.in);
        controleGerente = new ControleGerente();
    }
    //Verificar se o cpf deste gerente é válido
    public void cadastrarGerente(){
        System.out.println("Digite o nome do Gerente:");
        String usuario = scan.next();
        System.out.println("Digite a senha:");
        String senha = scan.next();
        System.out.println("Digite o CPF:");
        String CPF = scan.next();
    }

    //login do gerente
    public Gerente loginGerente(){
        try {
            System.out.println("Digite o CPF:");
            String CPF = scan.next();
            System.out.println("Digite a senha:");
            String senha = scan.next();
            return controleGerente.loginGerente(CPF, senha);
        }catch (Exception e){
            System.err.println("Valor digitado incorreto");
            return null;
        }
    }

    //menu para acesso as funções do gerente
    public int menuGerente(){
        System.out.println("========================");
        System.out.println("0 - Sair");
        System.out.println("1 - Listar Clientes");
        System.out.println("2 - Verificar saldo de um cliente");
        System.out.println("3 - Cancelar conta cliente");
        System.out.println("4 - Acessar Cliente");
        System.out.println("5 - Listar Agencias");
        System.out.println("6 - Dados do Gerente");
        System.out.println("7 - Criar uma nova agencia");
        System.out.println("========================");
        try {
            System.out.println("Opção: ");
            return scan.nextInt();
        }catch (Exception ee){
            System.out.println("Digite apenas um valor inteiro" + ee.getMessage());
            scan.nextLine();
            return 0;
        }
    }
    public void menuLoginGerente() {
        int opcao;
        double valor;
        Gerente gerente1 = loginGerente();
        if(gerente1 == null){
            return;
        }else{
            System.out.println("Login efetuado com sucesso!!!");
        }
        while(true) {
            opcao = menuGerente();
            if(opcao == 0){
                break;
            }
            else if(opcao == 1){ //
                controleGerente.listarClientes(gerente1.getNumeroAgencia());
            }else if(opcao == 2){//
                System.out.println("Digite o CPF do cliente:");
                String cpf = scan.next();
                controleGerente.verificarSaldoCliente(cpf, gerente1.getNumeroAgencia());
            }else if(opcao == 3){
                System.out.println("falta implementar");
            }else if(opcao == 4){
                System.out.println("falta implementar");
            }else if(opcao == 5) {
                System.out.println("falta implementar");
            }else if(opcao == 6){
                System.out.println(gerente1);
            }else if(opcao == 7){
                System.out.println("falta implementar");
            }
        }
    }
}
