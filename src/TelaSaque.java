import controle.ControleCadastro;
import controle.ControleContaCorrente;
import controle.ControleContaPoupanca;
import modelo.Cliente;
import visao.popUPmensagem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSaque extends JFrame{
    private JPanel painelSaque;
    private JTextField valorAserSacado;
    private JButton sacarButton;
    private JButton voltarButton;
    private popUPmensagem mensagem;
    private ControleCadastro controle;
    private ControleContaCorrente contaCorrente;
    private ControleContaPoupanca contaPoupanca;

    public TelaSaque(Cliente cliente){
        mensagem = new popUPmensagem();
        controle = new ControleCadastro();
        contaCorrente = new ControleContaCorrente();
        contaPoupanca = new ControleContaPoupanca();
        setContentPane(painelSaque);
        setTitle("Banco Pair Bank");
        setSize(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
        sacarButton.addActionListener(new ActionListener() {// aqui será realizado o saque da conta do usuário
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controle.oValorEhDouble(valorAserSacado.getText())){
                    if(cliente.getTipodeConta().equals("corrente"))
                        if(contaCorrente.Saque(Double.parseDouble(valorAserSacado.getText()),cliente.getCpf(),cliente.contaCorrente)) {
                            mensagem.alerta("O valor de " + valorAserSacado.getText() + " foi sacado da sua conta com sucesso");
                        }
                        else mensagem.alerta("O valor inserido não é possivel de ser sacado");
                    else
                        if(contaPoupanca.Saque(cliente.getCpf(),Double.parseDouble(valorAserSacado.getText()),cliente.contaPoupanca)){
                            mensagem.alerta("O valor de "+ valorAserSacado.getText() + " foi sacado da sua conta com sucessos");
                        }
                        else mensagem.alerta("O valor inserido não é possivel de ser sacado");
                }
                else mensagem.alerta("O valor a ser sacado deve ser um número");
            }
        });
    }
}
