package controle;

import modelo.Administrador;

public class controleAdministrador {
    private controleCadastro validar;
    public Administrador cadastroADM(String nome, String cpf, String rg, int diaNascimento,int mesNascimento,int anoNascimento, String senha){
        if(this.validar.CPF(cpf) && this.validar.SENHA(senha)){
            return new Administrador(nome,cpf,rg,diaNascimento,mesNascimento,anoNascimento,senha);
        }
        return null;
    }
    public void listarClientes(){

    }
    public void liberarContaCliente(){

    }
    public void verificarSaldoCliente(){

    }
    public void cancelarContaCliente(){

    }
    public void acessarCliente(){

    }


}
