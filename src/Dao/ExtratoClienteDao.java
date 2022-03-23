package Dao;

import conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ExtratoClienteDao {
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public ExtratoClienteDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }
    public void inserirExtrato(int id, String cpf) {
        String sql = "INSERT INTO extrato_cliente(id, cpf)" +
                     "VALUES(?,?)";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, cpf);
            stmt.execute();
            if (conn != null) {
                conn.close();
                stmt.close();
            }
        } catch (Exception e) {
            System.err.println("Inserção Falhou" + e.getMessage());
        }
    }
}
