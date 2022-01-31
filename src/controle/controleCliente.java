package controle;

import modelo.Cliente;
import modelo.Pessoa;

public class controleCliente {
    private controleCadastro validar;
    public Cliente cadastroCliente(String agencia, String conta, String senha, String tipodeconta, Pessoa pessoa, int diaCriacao, int mesCriacao, int anoCricao){
        if (this.validar.SENHA(senha)){
            return new Cliente(agencia,conta,senha,tipodeconta,pessoa,diaCriacao,mesCriacao,anoCricao);
        }
        return null;
    }
}
