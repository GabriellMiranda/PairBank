package controle;

import modelo.Pessoa;

public class controlePessoa {
    private controleCadastro validar = new controleCadastro();
    public Pessoa cadastroPessoa(String nome, String cpf, int diaNascimento, int mesNascimento, int anoNascimento){
        if(this.validar.CPF(cpf)){
            return new Pessoa(nome,cpf,diaNascimento,mesNascimento,anoNascimento);
        }
        return null;
    }
}
