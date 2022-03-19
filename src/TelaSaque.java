import modelo.Cliente;
import visao.popUPmensagem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSaque extends JFrame{
    private JPanel painelSaque;
    private JTextField valorAserDepositado;
    private JButton sacarButton;
    private JButton voltarButton;
    private popUPmensagem mensagem;

    public TelaSaque(Cliente cliente){
        mensagem = new popUPmensagem();
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
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
