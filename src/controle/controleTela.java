package controle;

import modelo.Agencia;
import modelo.Cliente;
import modelo.Pessoa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class controleTela {

    public List<Agencia> readAgencias() throws FileNotFoundException {
        ArrayList<Agencia> listAgencia = new ArrayList<Agencia>();
        Agencia agencia;
        Scanner scan = new Scanner(new FileReader("src\\Banco_dados_provisorio\\Agencias.txt")).useDelimiter("\\n");
        String[] linha;
        while (scan.hasNext()){
            linha = scan.next().split(" ");
            agencia = new Agencia(linha[0],linha[1], linha[2]+linha[3]);
            listAgencia.add(agencia);
        }
        return listAgencia;
    }

    public List<Cliente> readClientes() throws FileNotFoundException {
        ArrayList<Cliente> listClientes = new ArrayList<Cliente>();
        Scanner scan = new Scanner(new FileReader("src\\\\Banco_dados_provisorio\\\\Clientes.txt")).useDelimiter("\\n");
        String[] variaveis;
        while (scan.hasNext()){
            variaveis = scan.next().split(" ");
            Pessoa novaPessoa = new Pessoa(variaveis[0],variaveis[2],variaveis[3],variaveis[1]);
            Cliente novoCliente = new Cliente(variaveis[6],variaveis[7],variaveis[5],variaveis[9],novaPessoa,variaveis[8], variaveis[9]);
            listClientes.add(novoCliente);
        }
        return listClientes;
    }



}
