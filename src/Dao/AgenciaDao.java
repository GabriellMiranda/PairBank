package Dao;

import conexao.Conexao;
import modelo.Agencia;

import java.sql.*;
import java.util.Random;

public class AgenciaDao {
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public AgenciaDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }
    //inserindo agencia no banco de dados, quando inserir uma agencia devo inserir um gerente
    public boolean inserirAgencia(Agencia agencia) throws SQLException {
        String sql = "INSERT INTO agencia(nome, numero, nomeGerente)" +
                     "VALUES(?,?,?)";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1,agencia.getNome());
            stmt.setString(2, agencia.getNumero());
            stmt.setString(3,agencia.getNomeGerente());
            stmt.execute();
            //inserir gerente()
            if(conn != null){
                conn.close();
                stmt.close();
            }
            return true;
        }catch (Exception e){
            System.err.println("Inserção Falhou"+e.getMessage());
            return false;
        }
    }

    public String obterAgencia(){
        String numeroAgencia = null;
        try {
            Random aleatorio = new Random();
            String sql = "select numero from agencia;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            ResultSet p = stmt.executeQuery();
            int pos = 0;
            int num = 1 + aleatorio.nextInt(4 );
            while (p.next()){
                if(pos == num){
                    numeroAgencia =  p.getString("numero");
                    System.out.println("numeroAgencia:"+numeroAgencia);
                    return numeroAgencia;
                }
                pos++;
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro ao tentar obter uma agencia");
        }
       return null;
    }
    public String obterMAXagencia(){
        String numero = null;
        try {
            Random aleatorio = new Random();
            String sql = "select MAX(numero) as maior from agencia;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            ResultSet p = stmt.executeQuery();
            if(p.next()){
                numero = p.getString("maior");
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro ao tentar obter uma agencia");
        }
        return numero;
    }
}
