package controle;

import modelo.Gerente;

public class ControleGerente {
    private ControleCadastro validar;
    public Gerente cadastroGerente(String nome, String cpf, String rg, int diaNascimento, int mesNascimento, int anoNascimento, String senha){
        if(this.validar.CPF(cpf) && this.validar.SENHA(senha)){
            return new Gerente(nome,cpf,rg,diaNascimento,mesNascimento,anoNascimento,senha);
        }
        return null;
    }
    public void listarClientes(){

    }
    public void verificarSaldoCliente(){

    }
    public void cancelarContaCliente(){

    }
    public void acessarCliente(){

    }


}
