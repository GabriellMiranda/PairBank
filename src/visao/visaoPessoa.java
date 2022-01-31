package visao;

import modelo.Cliente;

import java.util.Scanner;
import modelo.Pessoa;

public class visaoPessoa {
    private Scanner scan;
    private Pessoa pessoa;
    public visaoPessoa(){
        scan = new Scanner(System.in);
        //Aqui vai ser chamada a classe controle cliente
    }

    public void cadastrarPessoa(){
        System.out.println("Digite o Nome:");
        String nome = scan.next();
        System.out.println("Digite a data de nascimento:");
        String dateNascimento = scan.next();
        System.out.println("Digite o CPF:");
        String CPF = scan.next();
        System.out.println("Digite o seu RG:");
        String rg = scan.next();
        System.out.println("Digite o Salario:");
        double salario = scan.nextInt();
    }
}
