package controle;

import Dao.controleContaCorrenteDao;
import modelo.ContaCorrente;

import java.sql.SQLException;

public class controleContaCorrente {
    private controleContaCorrenteDao correnteDao;
    public controleContaCorrente(){
        correnteDao = new controleContaCorrenteDao();
    }
    public ContaCorrente newContaCorrente(double valor){
        return new ContaCorrente(valor);
    }
    public void Deposito(double valor, String cpf, ContaCorrente conta) throws SQLException {
        if(valor < 0){
            System.err.println("Não se pode depositar valores negativos!!");
            return;
        }
        correnteDao.depositarBd(cpf, valor); // depositando no banco de dados
        conta.setValor(correnteDao.valorCorrente(cpf)); // atualizando a variável conta com o valor que acaba de ser depositdo no banco de dados
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
