package com.company;


import Dao.ClienteDao;
import conexao.Conexao;
import modelo.Cliente;
import visao.visaoTela;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("PairBank");
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        visaoTela tela = new visaoTela();
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.loginBD("04582568203","Amora123");
        System.out.println(cliente.toString());
        tela.telaInicial();
    }
}