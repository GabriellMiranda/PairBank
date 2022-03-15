package visao;

import controle.ControleCadastro;
import controle.ControlePessoa;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Pessoa;

import java.util.logging.Logger;

public class VisaoPessoa {
    private Scanner scan;
    private Pessoa pessoa;
    private ControlePessoa controle;
    private ControleCadastro controleC;
    private static final Logger LOGGER = Logger.getLogger("visaoPessoa");

    public VisaoPessoa(){
        scan = new Scanner(System.in);
        controle = new ControlePessoa();
        controleC = new ControleCadastro();
    }

    public Pessoa cadastrarPessoa(){
        int mesNascimento = 0, anoNascimento = 0, diaNascimento = 0;
        System.out.println("Digite o Nome:");
        String nome = scan.nextLine();
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
        if(controleC.CPF(CPF)) {
            this.pessoa = controle.cadastroPessoa(nome, CPF, diaNascimento, mesNascimento, anoNascimento);
            if (this.pessoa != null) {
                return this.pessoa;
            } else {
                System.out.println("Não foi possivel efetuar o cadastro, favor tentar novamente!");
                return this.cadastrarPessoa();
            }
        }
        LOGGER.info("CPF inválido!");
        return null;
    }
}
