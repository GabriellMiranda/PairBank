import modelo.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import visao.popUPmensagem;
import java.awt.event.ActionListener;

public class TelaPix extends JFrame{
    private JTextField chavePix;
    private JTextField valor;
    private JButton voltarButton;
    private JButton transferirButton;
    private JPanel painelPix;
    private popUPmensagem mensagem;

    public TelaPix(Cliente cliente){
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

            }
        });
    }

}
