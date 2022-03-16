package com.company;


import Dao.ClienteDao;
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



//opcao acessar numero do meu gerente para os clientes
//termine a classe controle gerente

