package controle;

import modelo.Pessoa;

public class ControlePessoa {
    private ControleCadastro validar = new ControleCadastro();
    public Pessoa cadastroPessoa(String nome, String cpf, int diaNascimento, int mesNascimento, int anoNascimento){
        return new Pessoa(nome,cpf,diaNascimento,mesNascimento,anoNascimento);
    }
}
