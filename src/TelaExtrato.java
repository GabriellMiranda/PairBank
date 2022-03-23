import controle.ControleExtrato;
import modelo.Cliente;
import modelo.TabelaExtrato;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaExtrato extends JFrame {
    private JButton voltarButton;
    private JPanel painelExtrato;
    private JTextArea textoExtrato;
    private ControleExtrato controleExtrato;
    public TelaExtrato(Cliente cliente){
        controleExtrato = new ControleExtrato();
        setContentPane(painelExtrato);
        setTitle("PairBank");
        setSize(650, 460);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        TabelaExtrato tabela = controleExtrato.obterExtrato(cliente.getCpf());
        textoExtrato.append(tabela.toString());
        textoExtrato.setEditable(false);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
    }
}
