package Dao;

import conexao.Conexao;
import modelo.Cliente;
import modelo.Data;
import modelo.Gerente;

import java.sql.*;

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

        }catch (SQLException ee){
            System.err.println(ee.getMessage());

        }
    }
    //Verificar o saldo de um determinado cliente no banco de dados
    public void verificarSaldoCliente(String cpf, String agencia){
        try {
            String sql = "select * from cliente as c JOIN contaCorrente as co ON c.CPF = co.CPFC where c.CPF = ? AND c.agencia = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, agencia);
            ResultSet p = stmt.executeQuery();
            if (p.next()){
                System.out.println(
                       "CPF:" + p.getString("CPF")  + "\n" +
                        "Numero Agencia:" + p.getString("numeroAgencia")  + "\n" +
                        "Nome:" + p.getString("nome")  + "\n" +
                        "Valor na Conta Corrente:" + p.getDouble("valorCorrente")
                        );
                System.out.println("Consulta realizada com sucesso!!");
            }

        }catch (Exception e) {
            System.err.println("Erro!! CPF Invalido");
        }

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
        }catch (Exception e) {
            System.err.println("Erro ao tentar obter o nome do gerente");
        }
        return nomeGerente;
    }

    // Cancelando a conta de um cliente
    public void cancelarContaCliente(){

    }
    //Acessando a conta de um cliente para verificar dados, verificar alguma informação
    // se o cliente tiver colocado algum informação incorreta no cadatro o gerente tem permisão de editar.
    public void acessarCliente(){

    }

}
