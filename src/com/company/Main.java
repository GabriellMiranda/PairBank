package com.company;


import visao.VisaoTela;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("PairBank");
    public static void main(String[] args) throws FileNotFoundException, SQLException {
       VisaoTela tela = new VisaoTela();
       tela.telaInicial();
    }
}

//invista mais tempo terminando a classe gerente faça isso para terminar as funcionalidades dele
//coloque o numero do gerente na classe dele
//opcao acessar numero do meu gerente