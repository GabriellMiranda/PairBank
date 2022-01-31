package modelo;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BancoDeDados {
    private String Nome_arquivo;
    private Agencia AgenciaFicticia;

    public BancoDeDados(String nome_arquivo){
        this.Nome_arquivo = nome_arquivo;
    }

    public void read() throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(this.Nome_arquivo)).useDelimiter("\\n");
        String[] variaveis;
        this.AgenciaFicticia = new Agencia("Teste","2010","Gabriel");
        while (scan.hasNext()){
            variaveis = scan.next().split(" ");
            Pessoa novaPessoa = new Pessoa(variaveis[0],variaveis[4],variaveis[5],Integer.parseInt(variaveis[1]),Integer.parseInt(variaveis[2]),Integer.parseInt(variaveis[3]));
            Cliente novoCliente = new Cliente(variaveis[8],variaveis[9],variaveis[7],variaveis[13],novaPessoa,Integer.parseInt(variaveis[10]),Integer.parseInt(variaveis[11]),Integer.parseInt(variaveis[12]));
            AgenciaFicticia.AdicionarCliente(novoCliente);
        }
    }

    public String toString(){
        return this.AgenciaFicticia.toString();
    }
}
