package modelo;

import java.awt.*;

public class ContaPoupanca {
    private double valorPoupanca;

    public ContaPoupanca(double valor){
        this.valorPoupanca = valor;
    }
    public double getValorPoupanca(){
        return this.valorPoupanca;
    }

    public void setValorPoupanca(double valor){
        this.valorPoupanca = valor;
    }

    public String toString(){
        return "Valor poupanca:"+Double.toString(this.valorPoupanca);
    }

}
