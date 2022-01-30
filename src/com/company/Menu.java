package com.company;

import java.util.Scanner;

public class Menu {
    public void Start() {
        Scanner scan = new Scanner(System.in);
        boolean op1 = true;
        boolean op2 = true;
        double valor;
        int opcao2;
        int opcao;
        String CPF;
        String senha;
        Pessoa pessoa1 = new Pessoa("Gabriel", 22, "12565863503", "2101452", "12/12/1999");
        Pessoa pessoa2 = new Pessoa("Erike", 21, "55454863503", "244501452", "02/12/2000");
        Pessoa pessoa3 = new Pessoa("juliana", 14, "05462014255", "0125458", "02/05/2005");

        Cliente cliente1 = new Cliente("1458", "2020", "2425", "Corrente", pessoa1, "08/02/2021", 51);
        Cliente cliente2 = new Cliente("1458", "2020", "0215", "Corrente", pessoa2, "08/02/2021", 51);
        Cliente cliente3 = new Cliente("1458", "2020", "2021", "Corrente", pessoa3, "08/02/2021", 51);

        Agencia Ag = new Agencia();

        Ag.AdicionarCliente(cliente1);
        Ag.AdicionarCliente(cliente2);
        Ag.AdicionarCliente(cliente3);
        System.out.println("--------------Menu-------------");

        while (op1 == true) {
            System.out.println("1 - Cadastrar Cliente:");
            System.out.println("2 - Fazer Login:");
            System.out.println("3 - Imprimir todos os clientes:");
            System.out.println("4 - Sair");
            System.out.println("Opção:");
            opcao = scan.nextInt();

            if (opcao == 1) {

            } else if (opcao == 2) {
                System.out.print("Digite seu CPF:");
                CPF = scan.next();
                System.out.print("Digite sua senha:");
                senha = scan.next();
                Cliente auxCliente = Ag.LoginUsuario(CPF, senha);
                if (auxCliente == null) {
                    System.out.print("Usuário não encontrado!!");
                } else {
                    while (op2 == true) {
                        System.out.println("1 - Sacar:");
                        System.out.println("2 - Depositar:");
                        System.out.println("3 - Mudar senha:");
                        System.out.println("4 - Imprimir dados");
                        System.out.println("5 - Sair");
                        System.out.println("Opção:");
                        opcao2 = scan.nextInt();
                        if (opcao2 == 1) {
                            System.out.print("Digite o valor que você deseja sacar:");
                            valor = scan.nextDouble();
                            if (valor > auxCliente.contaCorrente.getVeloCorrente()) {
                                System.out.println("Saldo Insuficiente!");
                            } else {
                                auxCliente.contaCorrente.SacarCorrente(valor);
                            }
                            auxCliente.contaCorrente.SacarCorrente(valor);

                        } else if (opcao2 == 2) {
                            System.out.println("Digite o valor que será depositado:");
                            valor = scan.nextDouble();
                            auxCliente.contaCorrente.DepositarCorrente(valor);
                            System.out.println("Deposito efetuado com sucesso!!");
                        } else if (opcao2 == 3) {
                            System.out.println("Digite sua nova senha:");
                            senha = scan.next();
                            auxCliente.setSenha(senha);
                        } else if (opcao2 == 4) {
                            auxCliente.ImprimeCliente();
                        } else if (opcao2 == 5) {
                            op2 = false;
                        } else {
                            System.out.println("Opção Incorreta!!");
                        }
                    }
                }
            } else if (opcao == 3) {
                Ag.ClientesdaAgencia();
            } else if (opcao == 4) {
                op1 = false;
            }else{
                System.out.println("Opção Incorreto!!");
            }
        }
    }
 }

