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
    private VisaoCliente visaoCliente;
    private VisaoGerente visaoGerente;
    public VisaoTela(){
        scan = new Scanner(System.in);
        visaoCliente = new VisaoCliente();
        visaoGerente = new VisaoGerente();
    }

    public void telaInicial() {
        int opcao1 = 0;
        while(true){
            mostrarMenu();
            try {
                opcao1 = scan.nextInt();
                if(opcao1 == 1) {
                    visaoCliente.cadastrarCliente();
                }
                else if(opcao1 == 2){
                    visaoCliente.menuLoginCliente();
                }
                else if(opcao1 == 3){
                    visaoGerente.menuLoginGerente();
                }else if(opcao1 == 4){
                    break;
                }
                else{
                    System.out.println("Opção invalidade!!\nDigite novamente:");
                }
            }
            catch (InputMismatchException ime){
                System.err.println("Por favor digite um valor inteiro como opção!!" + ime.getMessage());
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




}
