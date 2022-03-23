package visao;

import controle.ControleContaPoupanca;
import modelo.ContaCorrente;
import modelo.ContaPoupanca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VisaoContaPoupanca {
    Scanner scan = new Scanner(System.in);
    ControleContaPoupanca controle = new ControleContaPoupanca();

    public void sacar(String cpf, ContaPoupanca contaPoupanca) {
        double valor = 0;
        ControleContaPoupanca controle = new ControleContaPoupanca();
        try {
            System.out.println("Digite o valor que voce deseja sacar:");
            valor = scan.nextDouble();
        }catch (InputMismatchException ime){
            System.err.println("Verifique se você digitou o valor correto! obs: não pode haver letras no saque.");
            scan.nextLine();
            return;
        }
        if (controle.Saque(cpf, valor, contaPoupanca)) {
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println("Não foi possivel efetuar este saque");
        }
    }
    public void depositar(String cpf, ContaPoupanca conta) {
        double valor = 0;
        try {
            System.out.println("Digite o valor que voce deseja depositar");
            valor = scan.nextDouble();
        }
        catch (InputMismatchException ime){
            System.err.println("Verifique se você digitou o valor correto! obs: não pode haver letras no deposito.");
            scan.nextLine();// descarta a entrada errada do usuário
            return;
        }
        controle.Deposito(valor, cpf, conta);
    }
}
