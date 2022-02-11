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

    public boolean Deposito(double valor,ContaPoupanca conta){
        if(valor<0){
            return false;
        }
        conta.setValorPoupanca(conta.getValorPoupanca() + valor);
        return true;
    }
    public boolean Saque(double valor,ContaPoupanca conta){
        if(conta.getValorPoupanca() == 0 || conta.getValorPoupanca() < valor || valor <= 0){
            return false;
        }
        conta.setValorPoupanca(conta.getValorPoupanca() - valor);
        return true;
    }
}
