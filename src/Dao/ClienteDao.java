package Dao;

import conexao.Conexao;
import modelo.Cliente;

import java.sql.*;
import java.util.Objects;

public class ClienteDao {
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public ClienteDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }
 //Inserindo um cliente no banco de dados
    public void inserirCliente(Cliente cliente) throws SQLException {
        controleContaCorrenteDao correnteDao = new controleContaCorrenteDao();
        String sql = "INSERT INTO cliente(cpf, nome, salario, datanascimento, agencia, conta, senha, datacriacaoconta, tipoconta)" +
                "VALUES(?,?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1,cliente.getCpf());
            stmt.setString(2,cliente.getNome());
            stmt.setDouble(3,cliente.getSalario());
            stmt.setString(4,cliente.getDataNascimento());
            stmt.setString(5,cliente.getAgencia());
            stmt.setString(6,cliente.getConta());
            stmt.setString(7,cliente.getSenha());
            stmt.setString(8,cliente.getDataCriacaodaConta());
            stmt.setString(9,cliente.getTipodeConta());
            stmt.execute();
            correnteDao.inserirContaCorrenteEmBD(0, cliente.getCpf());
        }catch (Exception e){
            System.err.println("Inserção Falhou"+e.getMessage());
        }

    }
 //retornado um cliente do banco de dados
    public Cliente loginBD(String cpf, String senha1) throws SQLException {

        Cliente cliente = null;
        try {
            String sql = "select * from cliente where CPF = ? AND senha = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha1);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                cliente = new Cliente(p.getString("agencia"),
                p.getString("conta"),
                p.getString("senha"),
                p.getString("tipoConta"),
                p.getString("nome"),
                p.getString("CPF"),
                1,1,1999,
                1,1,2020);
            }
        }catch (Exception e) {
            System.err.println("Erro!! CPF ou SENHA Invalidos");
        }
        return cliente;
    }
   //verificando se o cliente existe no banco de dados
    public boolean clienteExiste(String cpf){
        try{
            String sql = "select cpf from cliente where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            if(p.next()){
                //System.out.println("EXiste?"+p.getString("cpf"));
                return Objects.equals(p.getString("cpf"), cpf);
            }
            return false;
        }catch (SQLException ee){
            System.err.println(ee.getMessage());
            return false;
        }
    }

 //Retornado um cliente no banco de dados
    public Cliente retornaCliente(String cpf){
        Cliente cliente = null;
        try{
            String sql = "select * from cliente where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            if(p.next()){
                cliente = new Cliente(p.getString("agencia"),
                p.getString("conta"),
                p.getString("senha"),
                p.getString("tipoConta"),
                p.getString("nome"),
                p.getString("CPF"),
                1,1,1999, //depois vamos ajeitar
                1,1,2020);
            }
            return cliente;
        }catch (SQLException ee){
            System.err.println(ee.getMessage());
            return null;
        }
    }



}
