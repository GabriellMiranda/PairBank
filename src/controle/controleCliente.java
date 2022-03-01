package controle;

import Dao.ClienteDao;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import java.util.logging.Logger;

public class controleCliente {
    private static final Logger LOGGER = Logger.getLogger("controleCliente");
    private controleCadastro validar = new controleCadastro();
    private ClienteDao clienteDao;

    public controleCliente(){
        clienteDao = new ClienteDao();
    }


    public boolean cadastroCliente(String agencia, String conta, String senha, String tipodeconta,String nome, String cpf, int diaNascimento,int mesNascimento,int anoNascimento, int diaCriacao,
                                              int mesCriacao,int anoCriacao) throws SQLException {

//        if(clienteDao.clienteExiste(cpf)){
//            LOGGER.info("CLiente já existente no banco de dados");
//            return false;
//        }
//        //clienteDao.inserirCliente(new Cliente(agencia,conta,senha,tipodeconta,nome,cpf,diaNascimento,mesNascimento,anoNascimento,diaCriacao, mesCriacao,anoCriacao));
      return false;
    }
    public String getNewNumConta(){
        Random randomico = new Random();
        int numConta = randomico.nextInt(1000,9999);
        if(clienteDao.qtdClientes() == 8999){
            LOGGER.warning("Não é mais possível criar uma nova conta");
            return null;
        }
        if(clienteDao.contaEmBd(Integer.toString(numConta))){
            return getNewNumConta();
        }
        return Integer.toString(numConta);
    }


    public Cliente login(String CPF,String senha) throws SQLException {
        return clienteDao.loginBD(CPF, senha);
    }

    public Cliente retornaCliente(String cpf){
        return clienteDao.retornaCliente(cpf);
    }

}
