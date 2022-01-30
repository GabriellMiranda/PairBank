package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agencia {
    Scanner scan = new Scanner(System.in);
    List<Cliente> list = new ArrayList<Cliente>();
    private String nome;
    private String numero;
    private String nomeGerente;
    public Agencia(){
        System.out.println("Digite o nome da Agencia:");
        this.nome = scan.nextLine();
        System.out.println("Digite o número da Agencia:");
        this.numero = scan.nextLine();
        System.out.println("Digite o Gerente da Agência:");
        this.nomeGerente = scan.nextLine();
    }

    public String getNome() {
        return nome;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente LoginUsuario(String CPF, String senha){
        for(int i = 0; i < this.list.size(); i++){
            Cliente c = (Cliente) list.get(i);
            if(c.getSenha().equals(senha) && c.pessoa.getCpf().equals(CPF)){
                return c;
            }
        }
        return null;
    }


    public void AdicionarCliente(Cliente cliente){
       this.list.add(cliente);
    }
    public void ClientesdaAgencia(){
        for(int i = 0; i < list.size();i++){
            Cliente c = (Cliente) list.get(i);
            System.out.println("-----------------------------------------------------------------\n");
            c.ImprimeCliente();
            System.out.println("-----------------------------------------------------------------\n");
        }
    }


}
