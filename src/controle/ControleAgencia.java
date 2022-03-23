package controle;

import Dao.AgenciaDao;
import modelo.Agencia;

import java.sql.SQLException;
import java.util.Random;

public class ControleAgencia {
    private AgenciaDao agenciadao;
    public ControleAgencia(){
        agenciadao = new AgenciaDao();
    }
    public boolean newAgencia(String nomeAgencia,String NumeroAgencia,String nomeGerente) throws SQLException {
      return agenciadao.inserirAgencia(new Agencia(nomeAgencia,NumeroAgencia,nomeGerente));
    }

    public String getAgencia() {
        Random Randomico = new Random();
        int numero = Randomico.nextInt(1,4);
        return "00"+ Integer.toString(numero);
    }
}
