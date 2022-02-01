package visao;

import controle.controlePessoa;
import modelo.Cliente;

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
        System.out.println("Digite o Nome:");
        String nome = scan.next();
        System.out.println("Digite a data de nascimento:");
        System.out.println("Dia:");
        int diaNascimento = scan.nextInt();
        System.out.println("Mês:");
        int mesNascimento = scan.nextInt();
        System.out.println("Ano:");
        int anoNascimento = scan.nextInt();
        System.out.println("Digite o CPF:");
        String CPF = scan.next();
        System.out.println("Digite o seu RG:");
        String rg = scan.next();
//        System.out.println("Digite o Salario:");
//        double salario = scan.nextInt();
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
