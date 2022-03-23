import controle.ControleGerente;
import modelo.Gerente;
import visao.popUPmensagem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSaldoCliente extends JFrame{
    private ControleGerente controleGerente;
    private JTextField CPFcliente;
    private JButton verSaldoButton;
    private JButton voltarButton;
    private JLabel valorSaldo;
    private JPanel painelSaldoCliente;
    private popUPmensagem mensagem;
    public TelaSaldoCliente(Gerente gerente){
        controleGerente = new ControleGerente();
        setContentPane(painelSaldoCliente);
        mensagem = new popUPmensagem();
        setResizable(false);
        setTitle("Banco Pair Bank");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaGerente(gerente);
            }
        });
        verSaldoButton.addActionListener(new ActionListener() {// mostrar o saldo do cliente cujo cpf foi consultado
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = CPFcliente.getText();
                CPFcliente.setText("");
                double valor = controleGerente.verificarSaldoCliente(cpf);
                if(valor != -1){
                    valorSaldo.setText(Double.toString(valor));
                }else{
                    mensagem.alerta("Esta conta não existe!!");
                }

            }
        });
    }
}
