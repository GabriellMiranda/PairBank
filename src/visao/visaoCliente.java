package visao;

import controle.controleCliente;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class visaoCliente {

    private Scanner scan;
    private Cliente cliente;
    private controleCliente controle;

    public visaoCliente(ArrayList <Cliente> listaClientes){
        scan = new Scanner(System.in);
        controle = new controleCliente(listaClientes);
    }

    public ArrayList <Cliente> cadastrarCliente(){
        visaoPessoa pessoaview = new visaoPessoa();
        System.out.println("Digite a Agência:");
        String agencia = scan.next();
        System.out.println("Digite a Conta:");
        String conta = scan.next();
        System.out.println("Digite senha:");
        String senha = scan.next();
        System.out.println("Digite o tipo de conta:");
        String tipoConta = scan.next();
        Pessoa nova = pessoaview.cadastrarPessoa();
        Date dataHoraAtual = new Date();
        String dia = new SimpleDateFormat("dd").format(dataHoraAtual);
        String mes = new SimpleDateFormat("MM").format(dataHoraAtual);
        String ano = new SimpleDateFormat("yyyy").format(dataHoraAtual);
        return controle.cadastroCliente(agencia,conta,senha,tipoConta,nova.getNome(),nova.getCpf(),nova.getRg(),
                nova.getDiaNascimento(),nova.getMesNascimento(),nova.getAnoNascimento(),
                Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(ano));
    }

    public Cliente loginCliente(){
        System.out.println("Digite seu CPF:");
        String CPF = scan.next();
        System.out.println("Digite senha:");
        String senha = scan.next();
        this.cliente = controle.login(CPF,senha);
        if(this.cliente == null){
            System.out.println("Senha ou CPF incorretos!!");
            return this.loginCliente();
        }
        System.out.println("Login efetuado com sucesso!");
        return this.cliente;
    }

    public int interfaceUsuario(){
        System.out.println("========================");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - pix");
        System.out.println("4 - Fazer emprestimo");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Dados do usuario");
        System.out.println("7 - Sair");
        System.out.println("========================");
        System.out.print("Opcao: ");
        try {
            return scan.nextInt();
        }
        catch (InputMismatchException ime){
            System.err.println("A opção deve ser um inteiro!!!");
            scan.nextLine();
            return 0;
        }

    }
    public Cliente retonarCliente(String cpf){
        return controle.retornaCliente(cpf);
    }

}
