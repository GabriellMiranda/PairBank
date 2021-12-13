package com.company;

public class ContaCorrente {
    private double ValorCorrente = 0;

    public void DepositarCorrente(double valorCorrente){
        this.ValorCorrente += valorCorrente;
    }
    public void SacarCorrente(double valor){
        this.ValorCorrente -= valor;
    }
    public void Imprimevalor(){
        System.out.println("Saldo Conta corrente:"+this.ValorCorrente);
    }
}
