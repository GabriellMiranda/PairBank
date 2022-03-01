package Dao;

import conexao.Conexao;
import modelo.Agencia;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class agenciaDao {
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public agenciaDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }

    public boolean inserirAgencia(Agencia agencia) throws SQLException {
        String sql = "INSERT INTO agencia(nome, numero, nomeGerente)" +
                     "VALUES(?,?,?)";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1,agencia.getNome());
            stmt.setString(2, agencia.getNumero());
            stmt.setString(3,agencia.getNomeGerente());
            stmt.execute();
            return true;
        }catch (Exception e){
            System.err.println("Inserção Falhou"+e.getMessage());
            return false;
        }

    }
}
