package controle;

import modelo.Administrador;

public class controleAdministrador {
    private controleCadastro validar;
    public Administrador cadastroADM(String usuario, String senha, String CPF){
        if(this.validar.CPF(CPF) && this.validar.SENHA(senha)){
            return new Administrador(usuario,senha,CPF);
        }
        return null;
    }
}
