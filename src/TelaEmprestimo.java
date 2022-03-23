import controle.ControleContaCorrente;
import controle.ControleContaPoupanca;
import modelo.Cliente;
import visao.popUPmensagem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEmprestimo extends JFrame{
    private JButton voltarButton;
    private JButton solicitarEmpréstimoButton;
    private JLabel ValorSalario;
    private JLabel valorEmpréstimo;
    private JPanel painelEmprestimo;
    private popUPmensagem mensagem;
    private ControleContaCorrente contaCorrente;
    private ControleContaPoupanca contaPoupanca;

    public TelaEmprestimo(Cliente cliente){
        mensagem = new popUPmensagem();
        setContentPane(painelEmprestimo);
        contaCorrente = new ControleContaCorrente();
        contaPoupanca = new ControleContaPoupanca();
        setTitle("Banco Pair Bank");
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        ValorSalario.setText(Double.toString(cliente.getSalario()));
        valorEmpréstimo.setText(Double.toString(cliente.getSalario() + cliente.getSalario()*0.15));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
        solicitarEmpréstimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// aqui vai ser depositado na conta do usuário o valor do empréstimo
                if(cliente.getTipodeConta().equals("corrente")) {
                    contaCorrente.Deposito(cliente.getSalario() + cliente.getSalario() * 0.15,cliente.getCpf(),cliente.contaCorrente);
                }
                else{
                    contaPoupanca.Deposito(cliente.getSalario() + cliente.getSalario() * 0.15,cliente.getCpf(),cliente.contaPoupanca);
                }
                mensagem.alerta("Foi depositado em sua conta o valor do empréstimo!");
            }
        });
    }
}
