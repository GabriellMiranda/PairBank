package Dao;

import conexao.Conexao;

import java.sql.*;

public class controleContaCorrenteDao {
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public controleContaCorrenteDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }
    public void inserirContaCorrenteEmBD(double valor, String CPF) {
        String sql = "INSERT INTO contaCorrente(valorCorrente, CPFC)" +
                "VALUES(?,?);";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, CPF);
            stmt.execute();
        } catch (SQLException e) {
            System.err.println("Sua conta corrente não foi criada!!"+e.getMessage());
        }
    }

    public double valorCorrente(String cpf){
        double valor = 0;
        try{
            String sql = "SELECT * FROM contaCorrente where CPFC = ?";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                valor = p.getDouble("valorCorrente");
            }
            return valor;
        }catch (Exception ee){
            System.err.println("Variávei de conta corrente não atualizada!!"+ee.getMessage());
            return valor;
        }
    }

    public void depositarBd(String cpf, double valor){
        try{
            String sql = "UPDATE contaCorrente" +
                        " SET valorCorrente = valorCorrente + ? where CPFC = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, cpf);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            System.out.println("Deposito efetuado com sucesso!!");
        }catch (SQLException ee){
            System.err.println("Não foi possível efetuar o deposito!!"+ee.getMessage());
        }
    }

}
