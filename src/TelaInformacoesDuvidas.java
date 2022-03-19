import modelo.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInformacoesDuvidas extends JFrame{
    private JButton voltarButton;
    private JLabel nomeGerente;
    private JLabel numeroGerente;
    private JLabel numeroAgencia;
    private JPanel painelInfo;

    public TelaInformacoesDuvidas(Cliente cliente){
        setContentPane(painelInfo);
        setTitle("Banco Pair Bank");
        setSize(620, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        numeroAgencia.setText(cliente.getAgencia());
        nomeGerente.setText("Teste");
        numeroGerente.setText("Teste");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
    }
}
