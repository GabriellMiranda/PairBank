package com.company;


import modelo.BancoDeDados;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BancoDeDados dados = new BancoDeDados("src\\Banco_dados_provisorio\\Clientes.txt");
        dados.read();
        System.out.print(dados);
    }
}
