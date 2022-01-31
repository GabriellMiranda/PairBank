package controle;

import modelo.Cliente;
import modelo.Pessoa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class controleTela {


    public void read() throws FileNotFoundException {

        Scanner scan = new Scanner(new FileReader("src\\Banco_dados_provisorio\\Agencias.txt")).useDelimiter("\\n");
        String[] linha;
        while (scan.hasNext()){
            linha = scan.next().split(" ");
            System.out.println(linha[0]);
        }
    }


}
