package visao;

import modelo.Cliente;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Agencia;
import modelo.LeituraDados;
import controle.controleTela;
import visao.visaoPessoa;
import visao.visaoCliente;

public class visaoTela {

    private Scanner scan;
    LeituraDados lerDados;
    List<Agencia> listAgencias = new ArrayList<Agencia>();
    List<Cliente> listClientes = new ArrayList<Cliente>();

    public visaoTela(){
        scan = new Scanner(System.in);
    }


    public void telaInicial() throws FileNotFoundException {
        controleTela control = new controleTela();
        listAgencias = control.readAgencias();
        listClientes = control.readClientes();
        /*System.out.println("Todas as Agencias:");
        for (Agencia listAgencia : listAgencias) {
            System.out.println(listAgencia.toString());
        }
        System.out.println("---------------------------------------");
        for(Cliente listCliente: listClientes){
            System.out.println(listCliente.toString());
        }
        System.out.println("---------------------------------------");*/

        int opcao1;
        mostrarMenu();
        while(true){
            opcao1 = scan.nextInt();
            if(opcao1 == 1){
                cadastrarCliente();
           /* }if else(opcao1 == 2){
                //leitura de dados
            }if else(opcao1 == 3){
                // fazer login
            }if else(opcao1 == 4){
                break;*/
            }else{
                System.out.println("Opção invalidade!!\nDigite novamente:");
            }
        }
    }
    public void mostrarMenu(){
        System.out.println("=================================");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Leitura de arquivos");
        System.out.println("3 - Fazer login");
        System.out.println("4 - Sair");
        System.out.println("=================================");
        System.out.print("Opcao:");
    }

    public void cadastrarCliente(){
        visaoCliente viewCliente = new visaoCliente();
        viewCliente.cadastrarCliente();
    }
    public void leituraArquivo(){
        String nomeArquivo;
        nomeArquivo = scan.next();
    }
    public void fazeLogin(){

    }


}
