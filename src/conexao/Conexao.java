package conexao;

import java.sql.*;

public class Conexao {
    Statement statement;
    Connection connection;
    public Connection getConnection() {
        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/PairBank","root","97394144Amintas");
            return connection;
        } catch (Exception e) {
            System.err.println("Falha ao conectar ao banco de dados!!"+e.getMessage());
            return null;
        }
    }

}
