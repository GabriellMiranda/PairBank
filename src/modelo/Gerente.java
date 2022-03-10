package modelo;

public class Gerente extends Pessoa{
    private String senha;
    private String idCliente; //chave estrangeira

    public Gerente(String nome, String cpf, String rg, int diaNascimento, int mesNascimento, int anoNascimento, String senha){ // devem haver apenas duas contas ADM (vefiricar quanto implementar BD)
        super(nome,cpf,diaNascimento,mesNascimento,anoNascimento);
        this.setSenha(senha);
    }

    public String getSenha() {
        return senha;
    }

    public String getCPF() {
        return super.getCpf();
    }

    private void setSenha(String senha){
        this.senha = senha;
    }
}
