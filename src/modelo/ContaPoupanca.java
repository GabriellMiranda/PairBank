package modelo;

import java.awt.*;

public class ContaPoupanca {
    private double valorPoupanca = 0;

    public ContaPoupanca(double valor){
        if( valor > 50){
            this.valorPoupanca = valor;
        }else {
            System.out.println("Não possível criar a conta!!");
        }
    }
    public void DepositarPoupanca(double valor){
        this.valorPoupanca += valor;
    }
    public void SacarPoupanca(double valor){
        this.valorPoupanca -= valor;
    }
    public void ExtratoPoupanca(){
        System.out.println("Valor poupanca:"+valorPoupanca);
    }

}
