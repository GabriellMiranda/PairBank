package Dao;


import conexao.Conexao;
import Dao.ExtratoDao;
import java.sql.*;

public class ContaPoupancaDao {
    private ExtratoDao extratoDao = new ExtratoDao();
    private ExtratoClienteDao extratoClienteDao = new ExtratoClienteDao();
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public ContaPoupancaDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }
    public void inserirContaPoupancaEmBD(double valor, String CPF) {
        String sql = "INSERT INTO contapoupanca(valorPoupanca, CPFP)" +
                "VALUES(?,?);";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, CPF);
            stmt.execute();
            if(conn != null){
                conn.close();
                stmt.close();
            }
        } catch ( SQLException e) {
            System.err.println("Sua conta poupança não foi criada!!"+e.getMessage());
        }
    }
    //essa função atualiza o variável da conta corrente.
    public double valorPoupanca(String cpf){
        double valor = 0;
        try{
            String sql = "SELECT * FROM contaPoupanca where CPFC = ?";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                valor = p.getDouble("valorPoupanca");
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
            return valor;
        }catch (Exception ee) {
            System.err.println("Variável de conta poupança não atualizada!!" + ee.getMessage());
            return valor;
        }
    }
    public void depositarBdPoupanca(String cpf, double valor){
        try{
            String sql = "UPDATE contaPoupanca" +
                    " SET valorPoupanca = valorPoupanca + ? where CPFP = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, cpf);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            if(conn != null){
                conn.close();
                stmt.close();
            }
            int idAux = extratoDao.inserirExtrato("Deposito", valor);
            extratoClienteDao.inserirExtrato(idAux, cpf);
        }catch (SQLException ee){
            System.err.println("Não foi possível efetuar o deposito!!"+ee.getMessage());
        }
    }
    public void depositarBdpix(String cpfCliente, String cpfDestinatario, double valor){
        try{
            String sql = "UPDATE contaPoupanca" +
                    " SET valorPoupanca = valorPoupanca + ? where CPFP = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, cpfDestinatario);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            int idAux = extratoDao.inserirExtrato("Pix", valor);
            extratoClienteDao.inserirExtrato(idAux, cpfCliente);
            idAux = extratoDao.inserirExtrato("Deposito", valor);
            extratoClienteDao.inserirExtrato(idAux, cpfDestinatario);
            if(conn != null){
                conn.close();
            }
        }catch (SQLException ee){
            System.err.println("Não foi possível efetuar o deposito!!"+ee.getMessage());
        }
    }
    public void subtraiValor(double valor, String cpf){
        try{
            String sql = "UPDATE contapoupanca" +
                    " SET valorPoupanca = valorPoupanca - ? where CPFP = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, cpf);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            if(conn != null){
                conn.close();
                stmt.close();
            }
            int idAux = extratoDao.inserirExtrato("Saque", valor);
            extratoClienteDao.inserirExtrato(idAux, cpf);
        }catch (SQLException ee){
            System.err.println("Error conta sem saldo!!"+ee.getMessage());
        }
    }

    public boolean transferenciaBD(double valor,String agencia,String conta, String cpfDestinatario,String cpfCliente ){
        try{
            ClienteDao clienteDao = new ClienteDao();
            if(!(clienteDao.verificaAgencia(cpfDestinatario, agencia) && clienteDao.verificaConta(cpfDestinatario, conta))){
                return false;
            }
            String sql = "UPDATE contaPoupanca" +
                    " SET valorPoupanca = valorPoupanca + ? where CPFP = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setString(2, cpfDestinatario);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            if(conn != null){
                conn.close();
                stmt.close();
            }
            int idAux = extratoDao.inserirExtrato("Transferência", valor);
            extratoClienteDao.inserirExtrato(idAux, cpfCliente);
            idAux = extratoDao.inserirExtrato("Deposito", valor);
            extratoClienteDao.inserirExtrato(idAux, cpfDestinatario);
            return true;
        }catch (SQLException ee){
            return false;
        }
    }
}
