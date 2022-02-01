package modelo;

public class ContaCorrente {
    private double ValorCorrente;

    public ContaCorrente(double valor){this.ValorCorrente = valor;}

    public double getValorCorrente(){
        return this.ValorCorrente;
    }

   /* public void setValorCorrente(double valor){
        this.ValorCorrente = valor;
    }*/
    public void sacar(double valor){
        this.ValorCorrente -= valor;
    }

    public void depositar(double valor){
        this.ValorCorrente += valor;
    }
    public String toString(){
        return "Saldo Conta corrente:"+this.ValorCorrente;
    }
}
