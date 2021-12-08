package com.company;

public class Cliente {
    private Pessoa pessoa;
    private String senha, usuario;
    private String Agencia, conta;
    private String dataCriacaodaConta;
    private String tipodeConta;

    public Cliente(String agencia, String conta, String senha, String usuario, String tipodeconta, Pessoa pessoa1, String dataCriacaodaConta){
        this.pessoa = pessoa1;
        this.Agencia = agencia;
        this.dataCriacaodaConta = dataCriacaodaConta;
        this.tipodeConta = tipodeconta;
        this.conta = conta;
        this.usuario = usuario;
        this.senha = senha;
        // this.pessoa = new Pessoa();
    }

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
    public String getUsuario(){
        return usuario;
    }
    public void setAgencia(String agencia) {
        this.Agencia = agencia;
    }
    public void setConta(String conta){
        this.conta = conta;
    }


}
