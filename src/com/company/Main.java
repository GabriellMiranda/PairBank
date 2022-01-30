package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Menu menu = new Menu();
    menu.Start();


        Administrador adm = new Administrador();
//        adm.cadastroADM();
        Patricia arvore = new Patricia();
        arvore.insere("Amintas");
        arvore.insere("Carol");
//        arvore.insere(adm);
        arvore.insere(9);
        arvore.insere(11);
        arvore.insere(3);
        arvore.insere(19);
        arvore.insere(5);
        arvore.insere(2);
        // A = (int) arvore.busca(3);
//        System.out.print(A);
           arvore.imprime(arvore.root);
    }
}
