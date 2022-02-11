package controle;

import modelo.ContaCorrente;
import modelo.ContaPoupanca;

public class controleContaPoupanca {
    public ContaPoupanca newContaPoupanca(double valor){
        if(valor > 50) {
            return new ContaPoupanca(valor);
        }
        return null;
    }

    public void Deposito(double valor,ContaPoupanca conta){
        conta.setValorPoupanca(conta.getValorPoupanca() + valor);
    }
    public void Saque(double valor,ContaPoupanca conta){
        conta.setValorPoupanca(conta.getValorPoupanca() - valor);
    }
}
