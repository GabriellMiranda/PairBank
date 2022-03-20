import modelo.Cliente;

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


    public TelaTransferencia(Cliente cliente){
        setContentPane(painelTrasnferencia);
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
    }
}
