package visao;

import modelo.Administrador;
import modelo.Pessoa;

import java.util.Scanner;

public class visaoAdministrador {

    private Scanner scan;
    private Administrador administrador;
    public visaoAdministrador(){
        scan = new Scanner(System.in);
        //Aqui vai ser chamada a classe controle cliente
    }

    public void cadastrarAdministrador(){
        System.out.println("Digite o Usuario:");
        String usuario = scan.next();
        System.out.println("Digite a senha:");
        String senha = scan.next();
        System.out.println("Digite o CPF:");
        String CPF = scan.next();

    }

}
