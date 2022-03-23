package Dao;

import conexao.Conexao;
import modelo.*;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtratoDao {

    private Conexao conexao;
    private Connection conn;
    private Statement statement;

    //Criando o construtor da classe, fazendo a conexão com o banco de dados
    public ExtratoDao(){
        conexao = new Conexao();
        conn = conexao.getConnection();
    }
    public int inserirExtrato(String descricao, double valor) {
        Calendar cal = Calendar.getInstance();
        Date dataHoraAtual = new Date();
        String dia = new SimpleDateFormat("dd").format(dataHoraAtual);
        String mes = new SimpleDateFormat("MM").format(dataHoraAtual);
        String ano = new SimpleDateFormat("yyyy").format(dataHoraAtual);
        Data data = new Data(Integer.parseInt(dia), Integer.parseInt(mes),Integer.parseInt(ano));
        String sql = "INSERT INTO extrato(id, descricao, data, valor)" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            int id = this.pegaUltimoId();
            stmt.setInt(1, id);
            stmt.setString(2, descricao);
            stmt.setString(3, data.toString());
            stmt.setDouble(4, valor);
            stmt.execute();
            if (conn != null) {
                conn.close();
                stmt.close();
            }
            return id;
        } catch (Exception e) {
            System.err.println("Inserção Falhou" + e.getMessage());
            return 0;
        }
    }

    public int pegaUltimoId(){
        int numero = 0;
        Data data = new Data(0,0,0);
        try {
            String sql = "select MAX(id) as id from extrato";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            ResultSet p = stmt.executeQuery();
            if(p.next()){
                numero = p.getInt("id");
            }
            return numero + 1;
        }catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }

    }
    public void imprimirExtratos(String cpf){
        TabelaExtrato tabelaExtrato = new TabelaExtrato();
        Data data = new Data(1,1,1);
        Extrato extrato = null;
        try {
            String sql = "SELECT *\n" +
                    "FROM extrato_cliente JOIN extrato e on e.id = extrato_cliente.id \n" +
                    "WHERE cpf = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                extrato = new Extrato(p.getString("descricao"),
                data.getDiaFromString(p.getString("data")),
                data.getMesFromString(p.getString("data")),
                data.getAnoFromString(p.getString("data")),
                p.getDouble("valor"));
                tabelaExtrato.addExtrato(p.getString("descricao"),data.getDataModelBrasil(),p.getString("valor"));
                System.out.println(extrato);
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            System.err.println("Erro ao imprimir os Extratos");
        }

    }
    public TabelaExtrato obterExtrato(String cpf){
        TabelaExtrato tabelaExtrato = new TabelaExtrato();
        Data data = new Data(1,1,1);
        try {
            String sql = "SELECT *\n" +
                    "FROM extrato_cliente JOIN extrato e on e.id = extrato_cliente.id \n" +
                    "WHERE cpf = ?;";
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet p = stmt.executeQuery();
            while (p.next()){
                        data.setDia(data.getDiaFromString(p.getString("data")));
                        data.setMes(data.getMesFromString(p.getString("data")));
                        data.setAno(data.getAnoFromString(p.getString("data")));
                tabelaExtrato.addExtrato(p.getString("descricao"),data.getDataModelBrasil(),p.getString("valor"));
            }
            if(conn != null){
                conn.close();
                stmt.close();
            }
        }catch (Exception e) {
            return null;
        }
        return tabelaExtrato;
    }

}
