package com.company;


import modelo.BancoDeDados;
import visao.visaoTela;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        visaoTela tela = new visaoTela();
        tela.telaInicial();
    }
}
