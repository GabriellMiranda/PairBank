package visao;

import modelo.Cliente;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Agencia;
import controle.controleTela;

public class visaoTela {

    private Scanner scan;
    ArrayList<Agencia> listAgencias = new ArrayList<Agencia>();
    ArrayList<Cliente> listClientes = new ArrayList<Cliente>();

    public visaoTela(){
        scan = new Scanner(System.in);
    }


    public void telaInicial() throws FileNotFoundException {
        controleTela control = new controleTela();
        listAgencias = (ArrayList<Agencia>) control.readAgencias();
        listClientes = (ArrayList<Cliente>) control.readClientes();

        int opcao1;
        mostrarMenu();
        while(true){
            opcao1 = scan.nextInt();
            if(opcao1 == 1) {
                cadastrarCliente();
            }
            else if(opcao1 == 3) {
                this.fazeLogin();
            }
            else if(opcao1 == 2){
                this.leituraArquivo();
            }
            else{
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
        visaoCliente viewCliente = new visaoCliente(this.listClientes);
        ArrayList<Cliente> aux = viewCliente.cadastrarCliente();
        if(aux != null){
            this.listClientes = aux;
            System.out.println("Cadastro efetuado com sucesso!");
            mostrarMenu();
        }
        else{
            System.out.println("Houve um erro ao efetuar o cadastro, favor tentar novamente!");
            mostrarMenu();
        }
    }
    public void leituraArquivo() throws FileNotFoundException {
        controleTela control = new controleTela();
        this.listClientes = (ArrayList<Cliente>) control.readClientes();
        this.listAgencias = (ArrayList<Agencia>) control.readAgencias();
        System.out.println("Dados carregados com sucesso!");
        mostrarMenu();
    }
    public void fazeLogin(){
        visaoCliente viewCliente = new visaoCliente(this.listClientes);
        Cliente cliente = viewCliente.loginCliente();
        int opcao = viewCliente.interfaceUsuario();
        //fazer o resto da interface Gabriel
    }


}
