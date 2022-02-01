package controle;

import modelo.Pessoa;

public class controlePessoa {
    private controleCadastro validar = new controleCadastro();
    public Pessoa cadastroPessoa(String nome, String cpf, String rg, int diaNascimento, int mesNascimento, int anoNascimento){
        if(this.validar.CPF(cpf)){
            return new Pessoa(nome,cpf,rg,diaNascimento,mesNascimento,anoNascimento);
        }
        return null;
    }
}
