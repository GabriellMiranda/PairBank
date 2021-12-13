package com.company;

public class Pessoa {
    private String nome, dataNascimento, cpf, rg;
    private int idade;
    private double salario;

    public Pessoa(String nome,int idade, String cpf, String rg, String dataNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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
    public int getIdade(){
        return this.idade;
    }
    public void ImpressaoPessoa(){
        System.out.println("Nome:"+getNome());
        System.out.println("Idade:"+getIdade());
        System.out.println("CPF:"+getCpf());
        System.out.println("RG:"+getRg());
        System.out.println("Data de Nascimento:"+getDataNascimento());
    }
}
