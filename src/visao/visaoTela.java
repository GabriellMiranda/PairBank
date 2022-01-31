package visao;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Agencia;
import modelo.LeituraDados;

public class visaoTela {

    private Scanner scan;
    LeituraDados lerDados;
    List<Agencia> listAgencias = new ArrayList<Agencia>();
    List<Cliente> listClientes = new ArrayList<Cliente>();

    public visaoTela(){
        scan = new Scanner(System.in);
    }


    public void telaInicial(){

        int opcao1;
        mostrarMenu();
     /*   while(true){
            opcao1 = scan.nextInt();
            if(opcao1 == 1){
                //Cadastrar cliente
            }if else(opcao1 == 2){
                //leitura de dados
            }if else(opcao1 == 3){
                // fazer login
            }if else(opcao1 == 4){
                break;
            }else{
                System.out.println("Opção invalidade!!\nDigite novamente:");
            }
        }*/
    }
    public void mostrarMenu(){
        System.out.println("=================================");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Leitura de arquivos");
        System.out.println("3 - Fazer login");
        System.out.println("4 - Sair");
        System.out.println("=================================");
    }
}
