import controle.ControleCadastro;
import controle.ControleContaCorrente;
import controle.ControleContaPoupanca;
import modelo.Cliente;
import visao.popUPmensagem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaTransferencia extends JFrame{
    private JPanel painelTrasnferencia;
    private JTextField valor;
    private JButton voltarButton;
    private JButton transferirButton;
    private JTextField agencia;
    private JTextField conta;
    private JTextField cpf;
    private ControleContaCorrente contaCorrente;
    private ControleContaPoupanca contaPoupanca;
    private ControleCadastro controleEntradas;
    private popUPmensagem mensagem;


    public TelaTransferencia(Cliente cliente){
        setContentPane(painelTrasnferencia);
        contaCorrente = new ControleContaCorrente();
        contaPoupanca = new ControleContaPoupanca();
        controleEntradas = new ControleCadastro();
        mensagem  = new popUPmensagem();
        setTitle("Banco Pair Bank");
        setSize(650, 250);
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
        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cliente.getTipodeConta().equals("corrente")){
                    if(controleEntradas.oValorEhDouble(valor.getText())) {
                        if (contaCorrente.transferencia(Double.parseDouble(valor.getText()), cliente.getCpf(), cpf.getText(), cliente.contaCorrente, agencia.getText(), conta.getText())) {
                            mensagem.alerta("Tarnsferência efetuada com sucesso!");
                        } else {
                            mensagem.alerta("Os dados inseridos estão incorretos, favor tentar novamente!");
                        }
                    }
                    else{
                        mensagem.alerta("O valor inserido não é válido!");
                    }
                }
                else{
                    if(controleEntradas.oValorEhDouble(valor.getText())) {
                        if (contaPoupanca.transferencia(Double.parseDouble(valor.getText()), cliente.getCpf(), cpf.getText(), cliente.contaPoupanca, agencia.getText(), conta.getText())) {
                            mensagem.alerta("Tarnsferência efetuada com sucesso!");
                        } else {
                            mensagem.alerta("Os dados inseridos estão incorretos, favor tentar novamente!");
                        }
                    }
                    else mensagem.alerta("O valor inserido não é válido!");
                }
            }
        });
    }
}
