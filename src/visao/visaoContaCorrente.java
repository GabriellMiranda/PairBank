package visao;
import controle.controleContaCorrente;
import modelo.ContaCorrente;

import java.util.Scanner;

public class visaoContaCorrente {
    Scanner scan = new Scanner(System.in);
    controleContaCorrente controle = new controleContaCorrente();

    public void sacar(ContaCorrente contaCorrente) {

        controleContaCorrente controle = new controleContaCorrente();
        System.out.println("Digite o valor que voce deseja sacar:");
        double valor = scan.nextDouble();
        if (controle.Saque(valor, contaCorrente)) {
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println("Não foi possivel efetuar este saque");
        }
    }
    public void depositar(ContaCorrente contaCorrente){
        System.out.println("Digite o valor que voce deseja depositar");
        double valor = scan.nextDouble();
        if(controle.Deposito(valor, contaCorrente)){
            System.out.println("Depósito efetuado com sucesso!");
        }
        else{
            System.out.println("Não é possivel efetuar um depósito de um valor negativo!");
        }
    }

    /*public void pix(ContaCorrente conta){
        System.out.println("Digite o numero do CPF:");
        String cpf = scan.next();
        System.out.println("Digite o valor que você deseja transferir");
        double valor = scan.nextInt();
    }*/

}
