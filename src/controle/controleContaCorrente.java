package controle;

import modelo.ContaCorrente;

public class controleContaCorrente {
    public ContaCorrente newContaCorrente(double valor){
        return new ContaCorrente(valor);
    }
    public boolean Deposito(double valor,ContaCorrente conta){
        if(valor < 0){
            return false;
        }
        conta.setValorCorrente(conta.getValorCorrente() + valor);
        return true;
    }
    public boolean Saque(double valor,ContaCorrente conta){
        if(conta.getValorCorrente() == 0 || conta.getValorCorrente() < valor || valor <= 0){
            return false;
        }
        conta.setValorCorrente(conta.getValorCorrente() - valor);
        return true;
    }
}
