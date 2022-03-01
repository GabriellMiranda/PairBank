package Dao;

import conexao.Conexao;
import modelo.Cliente;

import java.sql.*;

public class ClienteDao {
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public ClienteDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }

    public void inserirCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente(pf, nome, salario, datanascimento, agencia, conta, senha, datacriacaoconta, tipoconta)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement("");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public Cliente loginBD(String cpf, String senha1) throws SQLException {

        Cliente cliente = null;
        try {
            statement = conn.createStatement();
            ResultSet p = statement.executeQuery("select * from cliente WHERE CPF = cpf");
            System.out.println(p);
            while (p.next()){
                System.out.println(p.getString("nome"));
                cliente = new Cliente(p.getString("agencia"),
                p.getString("conta"),
                p.getString("senha"),
                p.getString("tipoConta"),
                p.getString("nome"),
                p.getString("CPF"),
                1,1,1999,
                1,1,2020);
            }
        }catch (Exception e){
            System.err.println("Erro!! CPF ou SENHA Invalidos");

        }
       return cliente;
    }


}
