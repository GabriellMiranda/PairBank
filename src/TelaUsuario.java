import modelo.Cliente;
import visao.popUPmensagem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaUsuario extends JFrame{
    private JButton sairButton;
    private JButton sacarButton;
    private JButton depositarButton;
    private JButton verSaldoButton;
    private JButton dadosDaContaButton;
    private JButton pixButton;
    private JButton transferênciaButton;
    private JButton emprestimoButton;
    private JButton informaçõesEDuvidasButton;
    private JButton extratoButton;
    private JButton configuraçõesDaContaButton;
    private JPanel painelUsuario;
    private JLabel valorSaldo;
    private Cliente cliente;
    private popUPmensagem mensagem;

    public TelaUsuario(Cliente cliente){
        this.cliente = cliente;
        mensagem = new popUPmensagem();
        setContentPane(painelUsuario);
        setTitle("PairBank");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        sairButton.addActionListener(new ActionListener() {//sair da conta
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaLogin();
            }
        });
        verSaldoButton.addActionListener(new ActionListener() {// ver o saldo
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cliente.getTipodeConta().equals("corrente")){
                    valorSaldo.setText(Double.toString(cliente.contaCorrente.getValor()));
                }else{
                    valorSaldo.setText(Double.toString(cliente.contaPoupanca.getValor()));
                }

            }
        });
        configuraçõesDaContaButton.addActionListener(new ActionListener() {// indo para a tela de configurações
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaConfiguracoes(cliente);
            }
        });
        depositarButton.addActionListener(new ActionListener() { //indo para depositar valor
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaDeposito(cliente);
            }
        });
        dadosDaContaButton.addActionListener(new ActionListener() {// ir para visualisar os dados da conta
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaDadosDaConta(cliente);
            }
        });
        sacarButton.addActionListener(new ActionListener() {// ir para a tela de saque
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaSaque(cliente);
            }
        });
        emprestimoButton.addActionListener(new ActionListener() {// ir para a tela de pegar o empréstimo
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaEmprestimo(cliente);
            }
        });
        informaçõesEDuvidasButton.addActionListener(new ActionListener() {//indo para a tela de informações
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaInformacoesDuvidas(cliente);
            }
        });
        extratoButton.addActionListener(new ActionListener() {// indo para a tela de extrato
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaExtrato(cliente);
            }
        });
        pixButton.addActionListener(new ActionListener() {// ir para a tela de realizar pix
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaPix(cliente);
            }
        });
        transferênciaButton.addActionListener(new ActionListener() {// ir para a tela de realizar transferencia
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaTransferencia(cliente);
            }
        });
    }

    public static void main(String[] args){
        Cliente cliente = new Cliente("0001","0982","9973041222",
                "corrente","Pedro","13816201679",18,12,200,
                18,3,2022);
        cliente.setSalario(1999.54);
        cliente.contaCorrente.setValor(1000);
        new TelaUsuario(cliente);
    }
}
