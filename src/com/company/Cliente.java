package com.company;

import javax.swing.*;

public class Cliente {
    public Pessoa pessoa;
    private String senha;
    private String Agencia, conta;
    private String dataCriacaodaConta;
    private String tipodeConta;
    public ContaCorrente contaCorrente = new ContaCorrente();

    public Cliente(String agencia, String conta, String senha, String tipodeconta, Pessoa pessoa1, String dataCriacaodaConta,double valor){
        this.pessoa = pessoa1;
        this.Agencia = agencia;
        this.dataCriacaodaConta = dataCriacaodaConta;
        this.tipodeConta = tipodeconta;
        this.conta = conta;
        this.senha = senha;
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
        return tipodeConta;
    }
    public String getSenha(){
        return senha;
    }
    public void getPessoa(){
        this.pessoa.ImpressaoPessoa();
    }

    public void setAgencia(String agencia) {
        this.Agencia = agencia;
    }
    public void setConta(String conta){
        this.conta = conta;
    }
    public void ImprimeCliente(){
         pessoa.ImpressaoPessoa();
         System.out.println("Senha:"+senha);
         System.out.println("Agencia:"+ Agencia);
         System.out.println("Conta:"+conta);
         System.out.println("Data Criacção da conta:"+dataCriacaodaConta);
         System.out.println("Tipo de conta:"+tipodeConta);
         contaCorrente.Imprimevalor();
    }

}
