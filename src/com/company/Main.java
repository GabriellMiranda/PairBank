package com.company;


import modelo.LeituraDados;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LeituraDados dados = new LeituraDados("src\\Banco_dados_provisorio\\Clientes.txt");
        dados.read();
        System.out.print(dados);
    }
}
