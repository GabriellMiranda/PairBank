package modelo;


/// Atenção termine de criar o resto dos atributos que estão sendo tirado do bando de dados
public class Gerente extends Pessoa{
    private String senha;
    private String numeroAgencia;
    private String numeroGerente;

    public Gerente(String cpf, String numeroAgencia,String nome, int diaNascimento, int mesNascimento, int anoNascimento, String senha, String numeroGerente){ // devem haver apenas duas contas ADM (vefiricar quanto implementar BD)
        super(nome,cpf,diaNascimento,mesNascimento,anoNascimento);
        this.senha = senha;
        this.numeroAgencia = numeroAgencia;
        this.numeroGerente = numeroGerente;
    }
    public String getNumeroAgencia(){
        return numeroAgencia;
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
