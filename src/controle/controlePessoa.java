package controle;

import modelo.Pessoa;

public class controlePessoa {
    private controleCadastro validar = new controleCadastro();
    public Pessoa cadastroPessoa(String nome, String cpf, int diaNascimento, int mesNascimento, int anoNascimento){
        return new Pessoa(nome,cpf,diaNascimento,mesNascimento,anoNascimento);
    }
}
