package visao;

import modelo.Cliente;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import controle.ControleContaCorrente;
import java.util.logging.Logger;

public class VisaoTela {
    private static final Logger LOGGER = Logger.getLogger("visaoTela");
    private Scanner scan;

    public VisaoTela(){
        scan = new Scanner(System.in);
    }

    public void telaInicial() {
        int opcao1 = 0;
        while(true){
            mostrarMenu();
            try {
                opcao1 = scan.nextInt();
                if(opcao1 == 1) {
                    this.cadastrarCliente();
                }
                else if(opcao1 == 2){
                    this.fazeLogin();
                }
                else if(opcao1 == 3){
                    System.out.println("Falta implementar");
                }else if(opcao1 == 4){
                    break;
                }
                else{
                    System.out.println("Opção invalidade!!\nDigite novamente:");
                }
            }
            catch (InputMismatchException | SQLException ime){
                System.err.println("Por favor digite um valor inteiro como opção!!");
                scan.nextLine();
            }

        }
    }
    public void mostrarMenu(){
        System.out.println("=================================");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Login Cliente");
        System.out.println("3 - Login Gerente");
        System.out.println("4 - Sair");
        System.out.println("=================================");
        System.out.print("Opcao: ");
    }

    public void cadastrarCliente() throws SQLException {
        VisaoCliente viewCliente = new VisaoCliente();
        if(viewCliente.cadastrarCliente()){
            System.out.println("Castro efetuado com sucesso!");
        }
    }

    public void fazeLogin() throws SQLException {
        int opcao;
        double valor;
        VisaoCliente viewCliente = new VisaoCliente();
        Cliente cliente = viewCliente.loginCliente();
        VisaoContaCorrente controle = new VisaoContaCorrente();
        while(true) {
            opcao = viewCliente.interfaceUsuario();
            if(opcao == 1){ //Fazendo o saque na conta corrente
                controle.sacar(cliente.contaCorrente);
            }else if(opcao == 2){//Fazendo o deposito na conta corrente
                controle.depositar(cliente.getCpf(), cliente.contaCorrente);
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
    public void fazerPix(VisaoCliente viewCliente, Cliente cliente){
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
        ControleContaCorrente controle = new ControleContaCorrente();
        boolean x = controle.pix(valor, cliente.contaCorrente);
        if(x == true){
            cliente1.contaCorrente.setValor(valor);
            System.out.println("pix efetuado com sucesso!!");
            return;
        }else{
            System.out.println("Você não tem saldo disponível!!");
        }
    }


}
