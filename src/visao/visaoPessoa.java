package visao;

import controle.controlePessoa;
import modelo.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Pessoa;

public class visaoPessoa {
    private Scanner scan;
    private Pessoa pessoa;
    private controlePessoa controle;

    public visaoPessoa(){
        scan = new Scanner(System.in);
        controle = new controlePessoa();
    }

    public Pessoa cadastrarPessoa(){
        int mesNascimento = 0, anoNascimento = 0, diaNascimento = 0;
        System.out.println("Digite o Nome:");
        String nome = scan.next();
        try {
            System.out.println("Digite a data de nascimento:");
            System.out.println("Dia:");
            diaNascimento = scan.nextInt();
            System.out.println("Mês:");
            mesNascimento = scan.nextInt();
            System.out.println("Ano:");
            anoNascimento = scan.nextInt();
        }
        catch (InputMismatchException ime){
            System.err.println("dia, mes e ano devem ser um valor inteiro cada um..");
            scan.nextLine();
            return null;
        }
        System.out.println("Digite o CPF:");
        String CPF = scan.next();
        System.out.println("Digite o seu RG:");
        String rg = scan.next();
//      System.out.println("Digite o Salario:");
//      double salario = scan.nextInt();
        this.pessoa = controle.cadastroPessoa(nome,CPF,rg,diaNascimento,mesNascimento,anoNascimento);
        if(this.pessoa != null){
            return this.pessoa;
        }
        else{
            System.out.println("Não foi possivel efetuar o cadastro, favor tentar novamente!");
            return this.cadastrarPessoa();
        }
    }
}
