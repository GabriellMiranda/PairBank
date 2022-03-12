package controle;

import Dao.GerenteDao;
import modelo.Gerente;

public class ControleGerente {
    private ControleCadastro validar;
    private GerenteDao gerenteDao;

    public ControleGerente(){
        gerenteDao = new GerenteDao();
    }

    public Gerente cadastroGerente(String nome, String cpf, String rg, int diaNascimento, int mesNascimento, int anoNascimento, String senha){
        if(this.validar.CPF(cpf) && this.validar.SENHA(senha)){
            return new Gerente(nome,cpf,rg,diaNascimento,mesNascimento,anoNascimento,senha);
        }
        return null;
    }

    public Gerente loginGerente(String cpf, String senha){
        return gerenteDao.logiGerenteBd(cpf, senha);
    }


    //listado todos os clientes
    public void listarClientes(){

    }
    //um cliente liga para um gerente ele atende e fala o saldo atual dela
    public void verificarSaldoCliente(){

    }

    // um gerente cancela a conta de um cliente e apaga ela do banco de dados
    public void cancelarContaCliente(){

    }
    //acessando conta de cliente para fazer modificações
    public void acessarCliente(){

    }


}
