import modelo.Cliente;
import visao.popUPmensagem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDeposito extends JFrame{
    private JTextField valorAserDepositado;
    private JButton sacarButton;
    private JButton voltarButton;
    private JPanel painelDeposito;
    private popUPmensagem mensagem;

    public TelaDeposito(Cliente cliente){
        mensagem = new popUPmensagem();
        setContentPane(painelDeposito);
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
        sacarButton.addActionListener(new ActionListener() {// aqui sera depositado na conta do usuário um valor ficticio
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
