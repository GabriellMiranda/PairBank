package controle;

import Dao.ContaCorrenteDao;
import Dao.ContaPoupancaDao;
import modelo.Cliente;
import modelo.ContaCorrente;
import modelo.ContaPoupanca;
import controle.ControleCliente;
import java.util.Objects;

public class ControleContaPoupanca {
    private ContaPoupancaDao poupancaDao;
    public ControleContaPoupanca(){
        poupancaDao = new ContaPoupancaDao();
    }


    public boolean Deposito(double valor, String cpf, ContaPoupanca conta){
        if(valor<0){
            return false;
        }
        conta.setValor(conta.getValor() + valor);
        poupancaDao.depositarBdPoupanca(cpf, valor);
        return true;
    }
    public boolean Saque(String cpf, double valor, ContaPoupanca conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        poupancaDao.subtraiValor(valor, cpf);
        return true;
    }
    public boolean subtraiValor(double valor, String cpf, ContaPoupanca conta){
        if(conta.getValor() == 0 || conta.getValor() < valor || valor <= 0){
            return false;
        }
        conta.setValor(conta.getValor() - valor);
        poupancaDao.subtraiValor(valor, cpf);
        return true;
    }

    public boolean transferencia(double valor,String cpfCliente,String cpfDestino,ContaPoupanca conta,String agenciaDestino,String contaDestino){
        ControleCliente controle = new ControleCliente();
        if(conta.getValor() < valor){
            return false;
        }
        else {
            String tipoconta = controle.verificandoExistenciaCliente(cpfDestino);
            if(tipoconta == null){
                return false;
            }
            else{
                conta.setValor(conta.getValor() - valor);
                poupancaDao.subtraiValor(valor, cpfCliente);
                if(tipoconta.equals("corrente")){
                    ContaCorrenteDao contaCorrenteDao = new ContaCorrenteDao();
                    return contaCorrenteDao.transferenciaBD(valor, agenciaDestino, contaDestino, cpfDestino, cpfCliente);
                }else{
                  return poupancaDao.transferenciaBD(valor, agenciaDestino, contaDestino, cpfDestino, cpfCliente);
                }
            }
        }
    }

    public void efetuarPix(double valor, String cpf, String conta){
        poupancaDao.depositarBdPoupanca(cpf, valor);
    }
    public void efetuarPix(double valor, String cpf){
        poupancaDao.depositarBdPoupanca(cpf, valor);
    }


    public boolean pix(Cliente cliente,double valor,String cpfDestino){
        ControleCliente controleCliente = new ControleCliente();
        if(valor > cliente.contaPoupanca.getValor()){
            return false;
        }
        else {
            String tipoconta = controleCliente.verificandoExistenciaCliente(cpfDestino);
            if (tipoconta == null) {
                return false;
            }
            else{
                subtraiValor(valor, cliente.getCpf(), cliente.contaPoupanca);
                if(tipoconta.equals("poupanca")){
                    poupancaDao.depositarBdpix(cliente.getCpf(),cpfDestino,valor);
                }else{
                    ContaCorrenteDao contaCorrenteDao = new ContaCorrenteDao();
                    contaCorrenteDao.depositarBdpix (cliente.getCpf(), cpfDestino, valor);
                }
                return true;
            }
        }
    }

}
