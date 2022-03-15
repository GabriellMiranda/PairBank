package modelo;

public class ContaCorrente extends Conta{
    private double ValorCorrente;

    public ContaCorrente(double valor){this.ValorCorrente = valor;}
    @Override
    public double getValor(){
        return this.ValorCorrente;
    }
    @Override
    public void setValor(double valor){
        this.ValorCorrente = valor;
    }

    public String toString(){
        return "Saldo Conta corrente:"+this.ValorCorrente;
    }
}
