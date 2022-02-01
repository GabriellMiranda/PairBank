package controle;

import modelo.ContaCorrente;

public class controleContaCorrente {
    public ContaCorrente newContaCorrente(double valor){
        return new ContaCorrente(valor);
    }

    public void Deposito(double valor,ContaCorrente conta){
        conta.setValorCorrente(conta.getValorCorrente() + valor);
    }
    public void Saque(double valor,ContaCorrente conta){
        conta.setValorCorrente(conta.getValorCorrente() - valor);
    }

}
