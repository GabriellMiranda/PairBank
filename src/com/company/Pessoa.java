package com.company;

import java.util.Calendar;

public class Pessoa {
    private String nome, dataNascimento, cpf, rg;
    private double salario;

    public Pessoa(String nome, String cpf, String rg, String dataNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }
    public String getNome(){
        return this.nome;
    }
    public String getDataNascimento(){
        return this.dataNascimento;
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getRg(){
        return this.rg;
    }
    public int getIdade(){//arrumar
        Calendar cal =  Calendar.getInstance();
        int dia,mes,ano;
        String[] data = this.dataNascimento.split("/");
        dia = Integer.parseInt(data[0]);
        mes = Integer.parseInt(data[1]);
        ano = Integer.parseInt(data[2]);
        int anoAtual = cal.get(Calendar.YEAR);
        int mesAtual = cal.get(Calendar.MONTH);
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        if((mesAtual == mes && diaAtual >= dia) || mesAtual>mes){
            return anoAtual - ano;
        }
        else {
            return anoAtual - ano - 1;
        }
    }
    public String toString(){
        return "Nome:"+getNome()+"\n"+
        "Idade:"+getIdade()+"\n"+
        "CPF:"+getCpf()+"\n"+
        "RG:"+getRg()+"\n"+
        "Data de Nascimento:"+getDataNascimento()+"\n";
    }
}
