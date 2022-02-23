package visao;

import modelo.Cliente;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        int opcao1 = 0;
        while(true){
            mostrarMenu();
            try {
                opcao1 = scan.nextInt();
            }
            catch (InputMismatchException ime){
                System.err.println("Por favor digite um valor inteiro como opção!!");
                scan.nextLine();
            }
            if(opcao1 == 1) {
                this.cadastrarCliente();
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
        else if(aux == null){
            System.out.println("Houve um erro ao efetuar o cadastro, favor tentar novamente!");
            return;
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
        visaoContaCorrente controle = new visaoContaCorrente();
        while(true) {
            opcao = viewCliente.interfaceUsuario();
            if(opcao == 1){ //Fazendo o saque na conta corrente
                controle.sacar(cliente.contaCorrente);
            }else if(opcao == 2){//Fazendo o deposito na conta corrente
                controle.depositar(cliente.contaCorrente);
            }else if(opcao == 3){
                this.fazerPix(viewCliente, cliente);
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
    public void fazerPix(visaoCliente viewCliente, Cliente cliente){
        double valor = 0;
        System.out.println("Digite o numero do CPF:");
        String cpf = scan.next();
        Cliente cliente1 = viewCliente.retonarCliente(cpf);
        if(cliente1 == null){
            System.out.println("CPF Invalido!!");
            return;
        }
        try {
            System.out.println("Digite o valor que você deseja transferir");
            valor = scan.nextInt();
        }
        catch (InputMismatchException ime){
            System.err.println("transferência invalida!!, digite apenas números");
            scan.nextLine();
            return;
        }
        controleContaCorrente controle = new controleContaCorrente();
        boolean x = controle.pix(valor, cliente.contaCorrente);
        if(x == true){
            cliente1.contaCorrente.setValorCorrente(valor);
            System.out.println("pix efetuado com sucesso!!");
            return;
        }else{
            System.out.println("Você não tem saldo disponível!!");
        }
    }


}
