import controle.ControleGerente;
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
    private ControleGerente controle;

    public TelaInformacoesDuvidas(Cliente cliente){
        controle = new ControleGerente();
        String[] nome_numero = controle.obterInfoGerente(cliente.getAgencia()).split("-");
        setContentPane(painelInfo);
        setTitle("Banco Pair Bank");
        setSize(620, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        numeroAgencia.setText(cliente.getAgencia());
        nomeGerente.setText(nome_numero[0]);
        numeroGerente.setText(nome_numero[1]);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
    }
}
