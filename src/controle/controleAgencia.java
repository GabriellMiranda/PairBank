package controle;

import modelo.Agencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class controleAgencia {
    private agenciaDao agenciadao;
    public controleAgencia(){
        agenciadao = new agenciaDao();
    }
    public boolean newAgencia(String nomeAgencia,String NumeroAgencia,String nomeGerente) throws SQLException {
      return agenciadao.inserirAgencia(new Agencia(nomeAgencia,NumeroAgencia,nomeGerente));
    }
    public String getAgencia(){
        int tam = this.listaAgencias.size();
        Random randomico = new Random();
        return listaAgencias.get(randomico.nextInt(tam + 1)).getNumero();
    }
    private boolean notExistAgencia(String NumeroAgencia){
        for(Agencia a : this.listaAgencias){
            if(a.getNumero().equals(NumeroAgencia)){
                return false;
            }
        }
        return true;
    }
}
