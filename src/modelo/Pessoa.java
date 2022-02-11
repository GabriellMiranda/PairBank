package modelo;

import java.util.Calendar;

public class Pessoa {
    private String nome, cpf, rg;
    private Data dataNascimento;
    private double salario;

    public Pessoa(String nome, String cpf, String rg, int diaNascimento,int mesNascimento,int anoNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = new Data(diaNascimento,mesNascimento,anoNascimento);
    }

    public String getNome(){
        return this.nome;
    }
    public String getDataNascimento(){
        return this.dataNascimento.toString();
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getRg(){
        return this.rg;
    }
    public int getDiaNascimento(){return this.dataNascimento.getDia();}
    public int getMesNascimento(){return this.dataNascimento.getMes();}
    public int getAnoNascimento(){return this.dataNascimento.getAno();}
    public int getIdade(){
        Calendar cal =  Calendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR);
        int mesAtual = cal.get(Calendar.MONTH);
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        if((mesAtual == this.dataNascimento.getMes() && diaAtual >= this.dataNascimento.getDia()) || mesAtual>this.dataNascimento.getMes()){
            return anoAtual - this.dataNascimento.getAno();
        }
        else {
            return anoAtual - this.dataNascimento.getAno() - 1;
        }
    }
    public String toString(){
        return "\nNome:"+getNome()+"\n"+
        "Idade:"+getIdade()+"\n"+
        "CPF:"+getCpf()+"\n"+
        "RG:"+getRg()+"\n"+
        "Data de Nascimento:"+getDataNascimento()+"\n";
    }
}
