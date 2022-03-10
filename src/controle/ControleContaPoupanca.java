package controle;

import modelo.ContaPoupanca;

public class ControleContaPoupanca {
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
        conta.setValor(conta.getValor() + valor);
        return true;
    }
    public boolean Saque(double valor,ContaPoupanca conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        return true;
    }
}
