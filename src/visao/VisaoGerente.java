package visao;

import modelo.Gerente;

import java.util.Scanner;

public class VisaoGerente {

    private Scanner scan;
    private Gerente gerente;
    public VisaoGerente(){
        scan = new Scanner(System.in);
        //Aqui vai ser chamada a classe controle cliente
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
    //menu para acesso as funções do gerente
    public void menuGerente(){
        System.out.println("========================");
        System.out.println("1 - Listar Clientes");
        System.out.println("2 - Verificar saldo de um cliente");
        System.out.println("3 - Cancelar conta cliente");
        System.out.println("4 - Acessar Cliente");
        System.out.println("5 - Listar Agencias");
        System.out.println("6 - Dados do Gerenete");
        System.out.println("7 - Criar uma nova agencia");
        System.out.println("8 - Sair");
        System.out.println("========================");
    }
}
