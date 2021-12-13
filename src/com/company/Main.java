package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int qtd;
        Scanner scan = new Scanner(System.in);
        Pessoa pessoa1 = new Pessoa("Gabriel",22,"12565863503","2101452","12/12/1999");
        Pessoa pessoa2 = new Pessoa("Erike",21,"55454863503","244501452","02/12/2000");
        Pessoa pessoa3 = new Pessoa("juliana",14,"05462014255","0125458","02/05/2005");

        Cliente cliente1 = new Cliente("1458","2020","2425", "Corrente",pessoa1,"08/02/2021",51);
        Cliente cliente2 = new Cliente("1458","2020","0215", "Corrente",pessoa2,"08/02/2021",51);
        Cliente cliente3 = new Cliente("1458","2020","2021", "Corrente",pessoa3,"08/02/2021",51);

        Agencia Ag = new Agencia();
        Ag.AdicionarCliente(cliente1);
        Ag.AdicionarCliente(cliente2);
        Ag.AdicionarCliente(cliente3);
        Ag.ClientesdaAgencia();



       /*

        while (true) {
            int indice = 0;
            String Agencia1, senha1;
            System.out.println("Digite sua Agencia:");
            Agencia1 = scan.next();
            System.out.println("Digite sua Senha:");
            senha1 = scan.next();
            for(int i = 0; i < clientes.length; i++){
                if(clientes[i].getSenha().equals(senha1) && clientes[i].getAgencia().equals(Agencia1)) {
                    indice = i;
                }
            }
            while (true) {
                System.out.println("1 - Depositar na conta corrente:");
                System.out.println("2 - Depositar na conta poupança:");
                System.out.println("3 - Sacar da conta poupança:");
                System.out.println("4 - Sacar da conta corrente:");
                System.out.println("5 - Imprimir informações:");
                System.out.println("6 - Sair");
                int opcao;
                opcao = scan.nextInt();
                if (opcao == 1) {
                    clientes[indice].contaCorrente.DepositarCorrente(1000);
                } else if (opcao == 2) {

                } else if (opcao == 3) {

                } else if (opcao == 4) {

                } else if (opcao == 5) {
                        clientes[indice].imprimeClinte();
                } else if(opcao == 6){
                    break;
                }else {
                    System.out.println("Opção invalida!!");
                }
            }
        }*/
    }
}
