package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agencia {
    Scanner scan = new Scanner(System.in);
    List<Cliente> list = new ArrayList<Cliente>();
    private String nome;
    private String numero;
    private String nomeGerente;

    public Agencia(String nomeAgencia,String NumeroAgencia,String nomeGerente){
        this.nome = nomeAgencia;
        this.numero = NumeroAgencia;
        this.nomeGerente = nomeGerente;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public String getNumero() {
        return numero;
    }

    public String toString(){
        String out = "";
        for(Cliente c : this.list){
            out += "-----------------------------------------------------------------\n";
            out += c + "\n";
            out += "-----------------------------------------------------------------\n";
        }
        return out;
    }


}
