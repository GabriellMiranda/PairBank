package controle;

import modelo.ContaCorrente;
import visao.visaoCliente;

public class controleContaCorrente {
    public ContaCorrente newContaCorrente(double valor){
        return new ContaCorrente(valor);
    }
    public boolean Deposito(double valor,ContaCorrente conta){
        if(valor < 0){
            return false;
        }
        conta.setValor(conta.getValor() + valor);
        return true;
    }
    public boolean Saque(double valor,ContaCorrente conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        return true;
    }
    public boolean pix(double valor, ContaCorrente conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        return true;
    }
}
