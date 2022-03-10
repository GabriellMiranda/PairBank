package controle;

import modelo.Agencia;

import java.sql.SQLException;

public class ControleAgencia {
    private AgenciaDao agenciadao;
    public ControleAgencia(){
        agenciadao = new AgenciaDao();
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
