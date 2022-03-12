package Dao;

import conexao.Conexao;
import modelo.Cliente;
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

    public Gerente logiGerenteBd(String cpf, String senha1){
        Gerente gerente = null;
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
                        1, 1, 1999,
                        p.getString("senha"));
            }
        }catch (Exception e) {
            System.err.println("Erro!! CPF ou SENHA Invalidos");
        }
        return gerente;
    }

    //Listando clientes do banco de dados
    public void listarClientesBd(){
        try{
            String sql = "select * from cliente where CPF = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            ResultSet p = stmt.executeQuery();
            System.out.println("====== Dados dos clientes =====");
            if(p.next()){
                System.out.println("==================================");
                System.out.println(
                        p.getString("agencia") + "\n" +
                        p.getString("conta") + "\n" +
                        p.getString("senha") + "\n" +
                        p.getString("tipoConta") + "\n" +
                        p.getString("nome") + "\n" +
                        p.getString("CPF") + "\n" +
                        p.getString("dataCriacaoConta") + "\n" +
                        p.getString("salario")
                );
                System.out.println("==================================");
            }

        }catch (SQLException ee){
            System.err.println(ee.getMessage());

        }
    }
    //Verificar o saldo de um determinado cliente no banco de dados
    public void verificarSaldoCliente(){

    }
    // Cancelando a conta de um cliente
    public void cancelarContaCliente(){

    }
    //Acessando a conta de um cliente para verificar dados, verificar alguma informação
    // se o cliente tiver colocado algum informação incorreta no cadatro o gerente tem permisão de editar.
    public void acessarCliente(){

    }

}
