package modelo;

public class ContaPoupanca extends Conta {
    private double valorPoupanca;

    public ContaPoupanca(double valor){
        this.valorPoupanca = valor;
    }
    @Override
    public double getValor(){
        return this.valorPoupanca;
    }
    @Override
    public void setValor(double valor){
        this.valorPoupanca = valor;
    }

    public String toString(){
        return "Valor poupanca:"+Double.toString(this.valorPoupanca);
    }

}
