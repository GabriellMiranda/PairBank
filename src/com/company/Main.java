package com.company;


//import Conexao.ConexaoDAO;
import visao.visaoTela;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        visaoTela tela = new visaoTela();
       /* ConexaoDAO con = new ConexaoDAO();
        ConexaoDAO con1 = new ConexaoDAO();
        con1 = (ConexaoDAO) con.getConnection();*/
        tela.telaInicial();
    }
}