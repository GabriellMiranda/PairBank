package controle;

import Dao.GerenteDao;
import modelo.Gerente;

import java.util.Objects;

public class ControleGerente {
    private ControleCadastro validar;
    private GerenteDao gerenteDao;


    public ControleGerente(){
        gerenteDao = new GerenteDao();
    }


    public String obterInfoGerente(String numeroAgencia){
        return gerenteDao.obterNomeGerente(numeroAgencia) + "-" + gerenteDao.obterNumGerente(numeroAgencia);
    }
    public Gerente cadastroGerente(String nome, String cpf, String rg, int diaNascimento, int mesNascimento, int anoNascimento, String senha, String numeroGerente){
        if(this.validar.CPF(cpf) && this.validar.SENHA(senha.split(""))){
            return new Gerente(nome,cpf,rg,diaNascimento,mesNascimento,anoNascimento,senha, numeroGerente);
        }
        return null;
    }

    public Gerente loginGerente(String cpf, String senha){
        return gerenteDao.logiGerenteBd(cpf, senha);
    }

    //listado todos os clientes
    public void listarClientes(String agencia){
        gerenteDao.listarClientesBd(agencia);
    }

    //um cliente liga para um gerente ele atende e fala o saldo atual dela
    public double verificarSaldoCliente(String cpf){
        double saldo = 0;
        ControleCliente controleCliente = new ControleCliente();
        String tipoconta = controleCliente.verificandoExistenciaCliente(cpf);
        if(Objects.equals(tipoconta, "corrente")){
            return gerenteDao.verificarSaldoClienteCorrente(cpf);
        }else{
            return gerenteDao.verificarSaldoClientePoupanca(cpf);
        }

    }


}
