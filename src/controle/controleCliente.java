package controle;

import modelo.Cliente;
import modelo.Pessoa;

import java.util.ArrayList;
import java.util.Random;

import java.util.logging.Logger;

public class controleCliente {
    private static final Logger LOGGER = Logger.getLogger("controleCliente");
    private ArrayList<Cliente> listaClientes;
    private controleCadastro validar = new controleCadastro();

    public controleCliente(ArrayList<Cliente> clientes){
        this.listaClientes = clientes;
    }
    public ArrayList<Cliente> cadastroCliente(String agencia, String conta, String senha, String tipodeconta,String nome, String cpf, int diaNascimento,int mesNascimento,int anoNascimento, int diaCriacao,
                                              int mesCriacao,int anoCriacao){
        if(clienteExist(new Cliente(agencia,conta,senha,tipodeconta,nome,cpf,diaNascimento,mesNascimento,anoNascimento,diaCriacao, mesCriacao,anoCriacao))){
            LOGGER.info("CLiente já existente no banco de dados");
            return this.listaClientes;
        }
        this.listaClientes.add(new Cliente(agencia,conta,senha,tipodeconta,nome,cpf,diaNascimento,mesNascimento,anoNascimento,diaCriacao, mesCriacao,anoCriacao));
        return this.listaClientes;
    }
    public String getNewNumConta(){
        Random randomico = new Random();
        int numConta = randomico.nextInt(1000,9999);
        if(listaClientes.size() == 8999){
            LOGGER.warning("Não é mais possível criar uma nova conta");
            return null;
        }
        if(contaInBd(Integer.toString(numConta))){
            return getNewNumConta();
        }
        return Integer.toString(numConta);
    }

    public boolean clienteExist(Cliente cliente){
        for(Cliente c:listaClientes){
            if(c.getCpf().equals(cliente.getCpf())){
                return true;
            }
        }
        return false;
    }

    public boolean contaInBd(String numConta){
        for(Cliente c : listaClientes){
            if(c.getConta().equals(numConta)){
                return true;
            }
        }
        return false;
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
