package modelo;


import modelo.Agencia;
import modelo.Cliente;
import modelo.Pessoa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeituraDados {
    private String Nome_arquivo;
    private Agencia AgenciaFicticia;

    public LeituraDados(String nome_arquivo){
        this.Nome_arquivo = nome_arquivo;
    }

    public void read() throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(this.Nome_arquivo)).useDelimiter("\\n");
        String[] variaveis;
        this.AgenciaFicticia = new Agencia("Teste","2010","Gabriel");
        while (scan.hasNext()){
            variaveis = scan.next().split(" ");
            Pessoa novaPessoa = new Pessoa(variaveis[0],variaveis[2],variaveis[3],variaveis[1]);
            Cliente novoCliente = new Cliente(variaveis[6],variaveis[7],variaveis[5],variaveis[9],novaPessoa,variaveis[8]);
            AgenciaFicticia.AdicionarCliente(novoCliente);
        }
    }

    public String toString(){
        return this.AgenciaFicticia.toString();
    }
}
