package visao;

import modelo.Cliente;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Agencia;
import controle.controleTela;
import controle.controleContaPoupanca;
import controle.controleContaCorrente;

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
        while(true){
            mostrarMenu();
            opcao1 = scan.nextInt();
            if(opcao1 == 1) {
                cadastrarCliente();
            }
            else if(opcao1 == 2) {
                this.leituraArquivo();
            }
            else if(opcao1 == 3){
                this.fazeLogin();
            }
            else if(opcao1 == 4){
                break;
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
        System.out.print("Opcao: ");
    }

    public void cadastrarCliente(){
        visaoCliente viewCliente = new visaoCliente(this.listClientes);
        ArrayList<Cliente> aux = viewCliente.cadastrarCliente();
        if(aux != null){
            this.listClientes = aux;
            System.out.println("Cadastro efetuado com sucesso!");
        }
        else{
            System.out.println("Houve um erro ao efetuar o cadastro, favor tentar novamente!");
        }
    }
    public void leituraArquivo() throws FileNotFoundException {
        controleTela control = new controleTela();
        this.listClientes = (ArrayList<Cliente>) control.readClientes();
        this.listAgencias = (ArrayList<Agencia>) control.readAgencias();
        System.out.println("Dados carregados com sucesso!");
    }
    public void fazeLogin(){
        int opcao;
        double valor;
        visaoCliente viewCliente = new visaoCliente(this.listClientes);
        Cliente cliente = viewCliente.loginCliente();
        controleContaCorrente controle = new controleContaCorrente();
        while(true) {
            opcao = viewCliente.interfaceUsuario();
            if(opcao == 1){
                System.out.println("Digite o valor que voce deseja sacar:");
                valor = scan.nextDouble();
                if(controle.Saque(valor,cliente.contaCorrente)){
                    System.out.println("Saque efetuado com sucesso!");
                }
                else{
                    System.out.println("Não foi possivel efetuar este saque");
                }
            }else if(opcao == 2){
                System.out.println("Digite o valor que voce deseja depositar");
                valor = scan.nextDouble();
                if(controle.Deposito(valor,cliente.contaCorrente)){
                    System.out.println("Depósito efetuado com sucesso!");
                }
                else{
                    System.out.println("Não é possivel efetuar um depósito de um valor negativo!");
                }
            }else if(opcao == 3){
                System.out.println("falta implementar");
            }else if(opcao == 4){
                System.out.println("falta implementar");
            }else if(opcao == 5) {
                System.out.println("falta implementar");
            }else if(opcao == 6){
                System.out.println(cliente);
            }else if(opcao == 7){
                break;
            }

        }
    }


}
