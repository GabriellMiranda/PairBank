import controle.ControleCadastro;
import controle.ControleContaCorrente;
import controle.ControleContaPoupanca;
import modelo.Cliente;
import visao.popUPmensagem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPix extends JFrame{
    private JTextField chavePix;
    private JTextField valor;
    private JButton voltarButton;
    private JButton transferirButton;
    private JPanel painelPix;
    private popUPmensagem mensagem;
    private ControleContaCorrente contaCorrente;
    private ControleContaPoupanca contaPoupanca;
    private ControleCadastro controleEntradas;

    public TelaPix(Cliente cliente){
        contaCorrente = new ControleContaCorrente();
        contaPoupanca = new ControleContaPoupanca();
        controleEntradas = new ControleCadastro();
        mensagem = new popUPmensagem();
        setContentPane(painelPix);
        setTitle("Banco Pair Bank");
        setSize(650, 200);
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
        transferirButton.addActionListener(new ActionListener() {//realizar a transferência
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cliente.getTipodeConta().equals("corrente")){
                    if(controleEntradas.oValorEhDouble(valor.getText())){
                        if(contaCorrente.pix(cliente,Double.parseDouble(valor.getText()),chavePix.getText())){
                            mensagem.alerta("Pix efetuado com sucesso!");
                        }
                        else mensagem.alerta("Houve um erro ao efetuar o pix!");
                    }
                    else mensagem.alerta("O valor inserido não é válido!");
                }
                else{
                    if(controleEntradas.oValorEhDouble(valor.getText())){
                        if(contaPoupanca.pix(cliente,Double.parseDouble(valor.getText()),chavePix.getText())){
                            mensagem.alerta("Pix efetuado com sucesso!");
                        }
                        else mensagem.alerta("Houve um erro ao efetuar o pix!");
                    }
                    else mensagem.alerta("O valor inserido não é válido!");
                }
            }
        });
    }

}
