package modelo;

public class Administrador {
    private String usuario;
    private String senha;
    private String CPF;

    public Administrador(String usuario,String senha,String CPF){ // devem haver apenas duas contas ADM (vefiricar quanto implementar BD)
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setCPF(CPF);
    }

    public String getSenha() {
        return senha;
    }

    public String getCPF() {
        return CPF;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private void setCPF(String CPF){
        this.CPF = CPF;
    }

    private void setSenha(String senha){
        this.senha = senha;
    }
}
