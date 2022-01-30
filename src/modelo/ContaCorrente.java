package modelo;

public class ContaCorrente {
    private double ValorCorrente = 0;

    public void DepositarCorrente(double valorCorrente){
        this.ValorCorrente += valorCorrente;
    }
    public void SacarCorrente(double valor){
        this.ValorCorrente -= valor;
    }
    public String toString(){
        return "Saldo Conta corrente:"+this.ValorCorrente;
    }
}
