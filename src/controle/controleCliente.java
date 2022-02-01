package controle;

import modelo.Cliente;
import modelo.Pessoa;

import java.util.ArrayList;

public class controleCliente {
    private ArrayList<Cliente> listaClientes;
    private controleCadastro validar = new controleCadastro();

    public controleCliente(ArrayList<Cliente> clientes){
        this.listaClientes = clientes;
    }
    public ArrayList<Cliente> cadastroCliente(String agencia, String conta, String senha, String tipodeconta, Pessoa pessoa, int diaCriacao, int mesCriacao, int anoCricao){
        if (this.validar.SENHA(senha)){
            this.listaClientes.add(new Cliente(agencia,conta,senha,tipodeconta,pessoa,diaCriacao,mesCriacao,anoCricao));
            return this.listaClientes;
        }
        return null;
    }
    public Cliente login(String CPF,String senha){
        for(Cliente c : this.listaClientes){
            if(c.getCPFpessoa().equals(CPF) && c.getSenha().equals(senha)){
                return c;
            }
        }
        return null;
    }
}
