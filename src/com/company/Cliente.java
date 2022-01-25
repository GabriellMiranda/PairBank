package com.company;

import javax.swing.*;

public class Cliente {
    public Pessoa pessoa;
    private String senha;
    private String Agencia, conta;
    private String dataCriacaodaConta;
    public ContaCorrente contaCorrente;
    private tipoConta TipoDeConta;


    public void defineTipoConta(String nomeTipo){
        if(nomeTipo.equals("corrente")){
            this.TipoDeConta = tipoConta.CORRENTE;
        }
        else{
            this.TipoDeConta = tipoConta.POUPANCA;
        }
    }

    private enum tipoConta {
        CORRENTE("corrente"),POUPANCA("poupança");

        private String descricao;

        tipoConta(String descricao) {
            this.descricao = descricao;
        }

        public String toString(){
            return this.descricao;
        }
    }

    public Cliente(String agencia, String conta, String senha, String tipodeconta, Pessoa pessoa1, String dataCriacaodaConta){
        this.pessoa = pessoa1;
        this.Agencia = agencia;
        this.dataCriacaodaConta = dataCriacaodaConta;
        this.defineTipoConta(tipodeconta);
        this.conta = conta;
        this.senha = senha;
        this.contaCorrente = new ContaCorrente();
    }

    /*public void isTipoConta(String tipodeconta, double valor){
        if ("Corrente".equals(tipodeconta)){
            contaCorrente = new ContaCorrente();
            contaPoupanca = new ContaPoupanca(valor);
        }else if("Poupança".equals(tipodeconta)){
            contaPoupanca = new ContaPoupanca(valor);
        }
    }
*/
    public String getAgencia(){
        return Agencia;
    }
    public String getConta() {
        return conta;
    }
    public String getDataCriacaodaConta(){
        return dataCriacaodaConta;
    }
    public String getTipodeConta(){
        return this.TipoDeConta.toString();
    }
    public String getSenha(){
        return senha;
    }
    public Pessoa getPessoa(){
        return this.pessoa;
    }

    public void setAgencia(String agencia) {
        this.Agencia = agencia;
    }
    public void setConta(String conta){
        this.conta = conta;
    }

    public String toString(){
         return pessoa +"\n"+ "Senha:"+senha +"\n" + "Agencia:"+ Agencia +"\n"+ "Conta:"+conta +"\n"+
         "Data Criacção da conta:"+dataCriacaodaConta +"\n"+
         "Tipo de conta:"+ this.TipoDeConta +"\n"+
         contaCorrente;
    }

}
