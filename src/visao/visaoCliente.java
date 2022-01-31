package visao;

import modelo.Cliente;
import java.sql.SQLOutput;
import java.util.Scanner;

public class visaoCliente {

    private Scanner scan;
    private Cliente cliente;

    public visaoCliente(){
        scan = new Scanner(System.in);
        //Aqui vai ser chamada a classe controle cliente
    }

    public void cadastrarCliente(){
        System.out.println("Digite a Agência:");
        String agencia = scan.next();
        System.out.println("Digite a Conta:");
        String conta = scan.next();
        System.out.println("Digite senha:");
        String senha = scan.next();
        System.out.println("Digite o tipo de conta:");
        //chama controle para fazer cadastro

    }

    public void loginCliente(){
        System.out.println("Digite a Agência:");
        String agencia = scan.next();
        System.out.println("Digite a Conta:");
        String conta = scan.next();
        System.out.println("Digite senha:");
        String senha = scan.next();
        //chama controle para fazer login
    }

    public int interfaceUsuario(){
        System.out.println("========================");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - pix");
        System.out.println("4 - Fazer emprestimo");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Sair");
        System.out.println("========================");
        int opcao = scan.nextInt();
        return opcao;
    }


}
