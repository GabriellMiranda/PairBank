package Dao;

import conexao.Conexao;
import modelo.Agencia;
import modelo.Cliente;
import modelo.Data;
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
    public void inserirCliente(Cliente cliente){
        ContaCorrenteDao correnteDao = new ContaCorrenteDao();
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
            if(conn != null){
                conn.close();
                stmt.close();
            }
            if(cliente.getTipodeConta().equals("corrente")) {
                correnteDao.inserirContaCorrenteEmBD(0, cliente.getCpf());
            }else{
                ContaPoupancaDao contaPoupancaDao = new ContaPoupancaDao();
                contaPoupancaDao.inserirContaPoupancaEmBD(0,cliente.getCpf());
            }
        }catch (Exception e){
            System.err.println("Inserção Falhou"+e.getMessage());
        }


    }
 //retornado um cliente do banco de dados
    public Cliente loginBDCorrente(String cpf, String senha1) {
        Cliente cliente = null;
        Data data = new Data(0,0,0);
        try {
            String sql = "select * from cliente JOIN contacorrente ON CPFC = CPF where CPF = ? AND senha = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha1);
            ResultSet p = stmt.executeQuery();
            if (p.next()){
                cliente = new Cliente(p.getString("agencia"),
                p.getString("conta"),
                p.getString("senha"),
                p.getString("tipoConta"),
                p.getString("nome"),
                p.getString("CPF"),
                data.getDiaFromString(p.getString("dataNascimento")),data.getMesFromString(p.getString("dataNascimento")), data.getAnoFromString(p.getString("dataNascimento")),
                data.getDiaFromString(p.getString("dataCriacaoConta")), data.getMesFromString(p.getString("dataCriacaoConta")), data.getAnoFromString(p.getString("dataCriacaoConta")));
                cliente.contaCorrente.setValor(p.getDouble("valorCorrente"));
                cliente.setSalario(p.getDouble("salario"));
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro!! CPF ou SENHA Invalidos");
        }
        return cliente;
    }

    public Cliente loginBDPoupanca(String cpf, String senha1) {
        Cliente cliente = null;
        Data data = new Data(0,0,0);
        try {
            String sql = "select * from cliente JOIN contapoupanca ON CPFP = CPF where CPF = ? AND senha = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha1);
            ResultSet p = stmt.executeQuery();
            if (p.next()){
                cliente = new Cliente(p.getString("agencia"),
                        p.getString("conta"),
                        p.getString("senha"),
                        p.getString("tipoConta"),
                        p.getString("nome"),
                        p.getString("CPF"),
                        data.getDiaFromString(p.getString("dataNascimento")),data.getMesFromString(p.getString("dataNascimento")), data.getAnoFromString(p.getString("dataNascimento")),
                        data.getDiaFromString(p.getString("dataCriacaoConta")), data.getMesFromString(p.getString("dataCriacaoConta")), data.getAnoFromString(p.getString("dataCriacaoConta")));
                cliente.contaPoupanca.setValor(p.getDouble("valorPoupanca"));
                cliente.setSalario(p.getDouble("salario"));
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro!! CPF ou SENHA Invalidos");
        }
        return cliente;
    }

   //verificando se o cliente existe no banco de dados
    public String clienteExiste(String cpf){
        try{
            String sql = "select tipoConta, CPF from cliente where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            if(p.next()){
                if(conn != null){
                    conn.close();
                }
                if(Objects.equals(p.getString("CPF"), cpf)){
                    return p.getString("tipoConta");
                }
            }
            return null;
        }catch (SQLException ee){
            System.err.println(ee.getMessage());
            return null;
        }
    }

 //Retornado um cliente no banco de dados
    public Cliente retornaCliente(String cpf){
        Cliente cliente = null;
        Data data = new Data(0,0,0);
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
                data.getDiaFromString(p.getString("dataNascimento")),data.getMesFromString(p.getString("dataNascimento")), data.getAnoFromString(p.getString("dataNascimento")),
                data.getDiaFromString(p.getString("dataCriacaoConta")), data.getMesFromString(p.getString("dataCriacaoConta")), data.getAnoFromString(p.getString("dataCriacaoConta")));
            }
            return cliente;
        }catch (SQLException ee){
            System.err.println(ee.getMessage());
            return null;
        }
    }
    public String getNewNumConta(String numeroAgencia){
        try {
            String sql = "select max(conta) as numero from cliente where cliente.agencia = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, numeroAgencia);
            ResultSet p = stmt.executeQuery();
            if (p.next()) {
                String numero = p.getString("numero");
                System.out.println("Conta:"+numero);
                int numeroOUT = Integer.parseInt(numero)+1;
                if(numeroOUT < 10){
                    return "00" + Integer.toString(numeroOUT);
                }
                else if(numeroOUT < 100){
                    return "0" + Integer.toString(numeroOUT);
                }
                else{
                    return Integer.toString(numeroOUT);
                }
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (SQLException ee){
            System.err.println(ee.getMessage());
            return null;
        }
        return null;
    }

    public void atualizarSenha(String cpf, String senha){
        try{
            String sql = "UPDATE cliente" +
                    " SET senha =  ? where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, senha);
            stmt.setString(2, cpf);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (SQLException ee){
            System.err.println("Não foi possível alterar a senha!!"+ee.getMessage());
        }
    }
    public void atualizarDataNascimento(String cpf, String datanascimento){
        try{
            String sql = "UPDATE cliente" +
                    " SET dataNascimento =  ? where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, datanascimento);
            stmt.setString(2, cpf);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (SQLException ee){
            System.err.println(ee.getMessage());
        }
    }
    public void atualizarNome(String cpf, String nome){
        try{
            String sql = "UPDATE cliente" +
                    " SET nome =  ? where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeLargeUpdate(); // com essa função eu consigo pegar o valor que já estava no banco de dados e somar um valor nele
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (SQLException ee){
            System.err.println(ee.getMessage());
        }
    }
    public boolean verificaAgencia(String cpf, String agencia){
        try{
            String sql = "select agencia from cliente where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            if(p.next()){
                if(conn != null){
                    conn.close();
                }
                return p.getString("agencia").equals(agencia);

            }
            return false;
        }catch (SQLException ee) {
            System.err.println(ee.getMessage());
            return false;
        }
    }
    public boolean verificaConta(String cpf, String conta){
        try{
            String sql = "select conta from cliente where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            if(p.next()){
                if(conn != null){
                    conn.close();
                }
                return p.getString("conta").equals(conta);

            }
            return false;
        }catch (SQLException ee) {
            System.err.println(ee.getMessage());
            return false;
        }
    }
    public boolean verificaExistenciaAgenciaConta(String cpf, String conta, String agencia){
        try{
            String sql = "select conta, CPF, agencia from cliente where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet p = stmt.executeQuery();
            if(p.next()){
                if(conn != null){
                    conn.close();
                }
                System.out.println("agencia:"+ agencia);
                System.out.println("conta:" + conta);

                System.out.println(p.getString("CPF"));
                System.out.println(p.getString("conta"));
                System.out.println(p.getString("agencia"));
                String agenciaAux = p.getString("agencia"), contaAux = p.getString("conta");
                System.out.println( contaAux.equals(conta) && agenciaAux.equals(agencia));
                return  contaAux.equals(conta) && agenciaAux.equals(agencia);

            }
            return false;
        }catch (SQLException ee) {
            System.err.println(ee.getMessage());
            return false;
        }
    }

}
