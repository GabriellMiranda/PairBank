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
    public ArrayList<Cliente> cadastroCliente(String agencia, String conta, String senha, String tipodeconta,String nome, String cpf,
                                              String rg, int diaNascimento,int mesNascimento,int anoNascimento, int diaCriacao,
                                              int mesCriacao,int anoCriacao){
        if (this.validar.SENHA(senha)){
            this.listaClientes.add(new Cliente(agencia,conta,senha,tipodeconta,nome,cpf,rg,diaNascimento,mesNascimento,anoNascimento,diaCriacao,
            mesCriacao,anoCriacao));
            return this.listaClientes;
        }
        return null;
    }
    public Cliente login(String CPF,String senha){
        for(Cliente c : this.listaClientes){
            if(c.getCpf().equals(CPF) && c.getSenha().equals(senha)){
                return c;
            }
        }
        return null;
    }
    public Cliente retornaCliente(String cpf){
        for (Cliente c: this.listaClientes){
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

}
