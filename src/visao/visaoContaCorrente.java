package visao;
import controle.controleContaCorrente;
import modelo.ContaCorrente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class visaoContaCorrente {
    Scanner scan = new Scanner(System.in);
    controleContaCorrente controle = new controleContaCorrente();

    public void sacar(ContaCorrente contaCorrente) {
        double valor = 0;
        controleContaCorrente controle = new controleContaCorrente();
        try {
            System.out.println("Digite o valor que voce deseja sacar:");
            valor = scan.nextDouble();
        }catch (InputMismatchException ime){
            System.err.println("Verifique se você digitou o valor correto! obs: não pode haver letras no saque.");
            scan.nextLine();
            return;
        }
        if (controle.Saque(valor, contaCorrente)) {
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println("Não foi possivel efetuar este saque");
        }
    }
    public void depositar(ContaCorrente contaCorrente){
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
        if(controle.Deposito(valor, contaCorrente)){
            System.out.println("Depósito efetuado com sucesso!");
        }
        else{
            System.out.println("Não é possivel efetuar um depósito de um valor negativo!");
        }
    }

}
