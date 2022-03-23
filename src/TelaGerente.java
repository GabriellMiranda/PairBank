import modelo.Gerente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGerente extends JFrame{
    private JPanel painelGerente;
    private JButton sairButton;
    private JButton listarClientesButton;
    private JButton verificarSaldoClienteButton;
    private JButton listarAgenciasButton;
    private JLabel nomeGerente;
    private JLabel numeroAgencia;

    public TelaGerente(Gerente gerente){
        setContentPane(painelGerente);
        setTitle("Gerenciamento Pair Bank");
        setSize(520, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        nomeGerente.setText(gerente.getNome());
        numeroAgencia.setText(gerente.getNumeroAgencia());
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaLogin();
            }
        });
        listarAgenciasButton.addActionListener(new ActionListener() {// ir para a tela de listar agencias
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaAgencias(gerente);
            }
        });
        verificarSaldoClienteButton.addActionListener(new ActionListener() {// ir para a tela de verificar saldo cliente
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaSaldoCliente(gerente);
            }
        });
        listarClientesButton.addActionListener(new ActionListener() {// ir para a tela de listar clientes
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaClientesLista(gerente);
            }
        });
    }

    public static void main(String[] args){
        Gerente gerente = new Gerente("13816201679","001","Pedro",
                18,12,2000,"97394144Amintas","97394144");
        new TelaGerente(gerente);
    }
}
