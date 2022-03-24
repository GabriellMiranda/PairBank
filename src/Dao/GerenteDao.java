package Dao;

import conexao.Conexao;
import modelo.Cliente;
import modelo.Data;
import modelo.Gerente;

import java.sql.*;
import modelo.TabelaClientes;
public class GerenteDao {
    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public GerenteDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }
   //inserir gerente
    public boolean inserirGerente(Gerente gerente){
        String sql = "INSERT INTO gerente(cpf, nome, dataNascimento,senha,numeroAgencia,numeroTelefone)" +
                "VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1,gerente.getCPF());
            stmt.setString(2, gerente.getNome());
            stmt.setString(3, gerente.getDataNascimento());
            stmt.setString(4, gerente.getSenha());
            stmt.setString(5, gerente.getNumeroAgencia());
            stmt.setString(6, gerente.getNumeroGerente());
            stmt.execute();
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


    public Gerente logiGerenteBd(String cpf, String senha1){
        Gerente gerente = null;
        Data data = new Data(0,0,0);
        try {
            String sql = "select * from gerente where CPF = ? AND senha = ? ;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha1);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                System.out.println("ou");
                gerente = new Gerente(p.getString("CPF"),
                p.getString("numeroAgencia"),
                p.getString("nome"),
                data.getDiaFromString(p.getString("dataNascimento")), data.getMesFromString(p.getString("dataNascimento")), data.getAnoFromString(p.getString("dataNascimento")),
                p.getString("senha"),
                p.getString("numeroTelefone"));
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro!! CPF ou SENHA Invalidos");
        }
        return gerente;
    }

    //Listando clientes do banco de dados
    public void listarClientesBd(String numeroAgencia){
        try{
            String sql = "select * from cliente WHERE agencia = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, numeroAgencia);
            ResultSet p = stmt.executeQuery();
            System.out.println("====== Dados dos clientes da Agencia =====");
            while(p.next()){
                System.out.println("==================================");
                System.out.println(
                       "Agencia: " + p.getString("agencia") + "\n" +
                       "Conta: " + p.getString("conta") + "\n" +
                       "Tipo de conta:" + p.getString("tipoConta") + "\n" +
                        "Nome:" +p.getString("nome") + "\n" +
                       "CPF: " + p.getString("CPF") + "\n" +
                       "Criação da conta: " +p.getString("dataCriacaoConta") + "\n" +
                       "Data de Nascimento: " +p.getString("dataNascimento")+ "\n" +
                       "Salario: " +p.getString("salario")
                );
                System.out.println("==================================");
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (SQLException ee){
            System.err.println(ee.getMessage());

        }
    }
    //Verificar o saldo de um determinado cliente no banco de dados
    public double verificarSaldoClienteCorrente(String cpf){
        try {
            String sql = "select valorCorrente from contaCorrente where CPFC = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            if(conn != null){
                conn.close();
            }
            if(p.next()){
                return p.getDouble("valorCorrente");
            }
            return -1;
        }catch (Exception e) {
            System.err.println("Erro!! CPF Invalido");
        }
        return -1;

    }

    public double verificarSaldoClientePoupanca(String cpf){
        try {
            String sql = "select valorPoupanca from contaPoupanca where CPFP = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            if(conn != null){
                conn.close();
            }
            if(p.next()){
                return p.getDouble("valorPoupanca");
            }
            return -1;
        }catch (Exception e) {
            System.err.println("Erro!! CPF Invalido");
        }
        return -1;

    }

    public String obterNumGerente(String numeroAgencia){
        String numeroGerente = null;
        try {
            String sql = "select numeroTelefone from gerente where gerente.numeroAgencia = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, numeroAgencia);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                numeroGerente =  p.getString("numeroTelefone");
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro ao tentar obter o numero de telefone do gerente");
        }
        return numeroGerente;
    }

    public String obterNomeGerente(String numeroAgencia){
        String nomeGerente = null;
        try {
            String sql = "select nome from gerente where gerente.numeroAgencia = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, numeroAgencia);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                nomeGerente =  p.getString("nome");
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro ao tentar obter o nome do gerente");
        }
        return nomeGerente;
    }

    public void listarClientesBdGerente(String numeroAgencia, TabelaClientes tabelaClientes) {

        try {
            String sql = "select * from cliente WHERE agencia = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, numeroAgencia);
            ResultSet p = stmt.executeQuery();
            while (p.next()) {
                tabelaClientes.addCliente(p.getString("nome"),p.getString("CPF"));
            }
            if (conn != null) {
                conn.close();
                stmt.close();
            }
        } catch (SQLException ee) {
            System.err.println(ee.getMessage());

        }
    }

}
