package controle;

import Dao.ControleContaCorrenteDao;
import modelo.ContaCorrente;

import java.sql.SQLException;

public class ControleContaCorrente {
    private ControleContaCorrenteDao correnteDao;
    public ControleContaCorrente(){
        correnteDao = new ControleContaCorrenteDao();
    }
    public ContaCorrente newContaCorrente(double valor){
        return new ContaCorrente(valor);
    }
    public boolean Deposito(double valor, String cpf, ContaCorrente conta) {
        if(valor < 0){
            return false;
        }
        conta.setValor(conta.getValor() + valor);
//        correnteDao.depositarBd(cpf, valor); // depositando no banco de dados
        return true;
    }
    public boolean Saque(double valor,ContaCorrente conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        return true;
    }
    public boolean subtraiValor(double valor, String cpf, ContaCorrente conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        correnteDao.subtraiValor(valor, cpf);
        return true;
    }

    public void efetuarPix(double valor, String cpf){
        correnteDao.adcionaValor(valor, cpf);
    }
}
