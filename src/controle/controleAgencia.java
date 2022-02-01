package controle;

import modelo.Agencia;

import java.util.ArrayList;

public class controleAgencia {
    private ArrayList<Agencia> listaAgencias;

    public controleAgencia(ArrayList<Agencia> agencias){this.listaAgencias = agencias;}

    public ArrayList<Agencia> newAgencia(String nomeAgencia,String NumeroAgencia,String nomeGerente){
        if(this.notExistAgencia(NumeroAgencia)){
            this.listaAgencias.add(new Agencia(nomeAgencia,NumeroAgencia,nomeGerente));
            return this.listaAgencias;
        }
        return null;
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
