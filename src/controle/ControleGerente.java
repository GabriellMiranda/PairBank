package controle;

import Dao.GerenteDao;
import modelo.Gerente;

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
        if(this.validar.CPF(cpf) && this.validar.SENHA(senha)){
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
    public void verificarSaldoCliente(String cpf, String agencia){
        gerenteDao.verificarSaldoCliente(cpf, agencia);
    }

    // um gerente cancela a conta de um cliente e apaga ela do banco de dados
    public void cancelarContaCliente(){
        gerenteDao.cancelarContaCliente();
    }
    //acessando conta de cliente para fazer modificações
    public void acessarCliente(){
        gerenteDao.acessarCliente();
    }


}
