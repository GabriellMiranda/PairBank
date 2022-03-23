package controle;

import Dao.ContaCorrenteDao;
import Dao.ContaPoupancaDao;
import modelo.Cliente;
import modelo.ContaCorrente;
import controle.ControleCliente;

public class ControleContaCorrente {
    private ContaCorrenteDao correnteDao;
    public ControleContaCorrente(){
        correnteDao = new ContaCorrenteDao();
    }
    public ContaCorrente newContaCorrente(double valor){
        return new ContaCorrente(valor);
    }
    public boolean Deposito(double valor, String cpf, ContaCorrente conta) {
        if(valor < 0){
            return false;
        }
        correnteDao.depositarBd(cpf, valor); // depositando no banco de dados
        conta.setValor(correnteDao.valorCorrente(cpf)); // atualizando a variável conta com o valor que acaba de ser depositdo no banco de dados
        return true;
    }
    public boolean Saque(double valor,String cpf, ContaCorrente conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        correnteDao.subtraiValor(valor, cpf);
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

    public boolean transferencia(double valor,String cpfCliente,String cpfDestino,ContaCorrente conta,String agenciaDestino,String contaDestino){
        ControleCliente controle = new ControleCliente();
        if(conta.getValor() < valor){
            return false;
        }
        else {
            String tipoconta = controle.verificandoExistenciaCliente(cpfDestino);
            if(tipoconta == null){
                return false;
            }
            else {
                conta.setValor(conta.getValor() - valor);
                correnteDao.subtraiValor(valor, cpfCliente);
                if(tipoconta.equals("corrente")){
                    return correnteDao.transferenciaBD(valor, agenciaDestino, contaDestino, cpfDestino, cpfCliente);
                }else{
                    ContaPoupancaDao contaPoupancaDao = new ContaPoupancaDao();
                     return contaPoupancaDao.transferenciaBD(valor, agenciaDestino, contaDestino, cpfDestino, cpfCliente);
                }
            }
        }
    }
//    public
    public void efetuarPix(double valor, String cpf){
        correnteDao.adcionaValor(valor, cpf);
    }

    public boolean pix(Cliente cliente,double valor,String cpfDestino){
        ControleCliente controleCliente = new ControleCliente();
        if(valor > cliente.contaCorrente.getValor()){
            return false;
        }
        else {
            String tipoconta = controleCliente.verificandoExistenciaCliente(cpfDestino);
            if (tipoconta == null) {
                return false;
            }
            else{
                subtraiValor(valor, cliente.getCpf(),cliente.contaCorrente);
                if(tipoconta.equals("corrente")){
                    correnteDao.depositarBdpix(cliente.getCpf(), cpfDestino, valor);
                }else{
                    ContaPoupancaDao contaPoupancaDao = new ContaPoupancaDao();
                    contaPoupancaDao.depositarBdpix(cliente.getCpf(),cpfDestino, valor);
                }
                return true;
            }
        }
    }
}
