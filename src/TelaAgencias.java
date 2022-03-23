import modelo.Gerente;
import modelo.TabelaAgencias;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAgencias extends JFrame{
    private JPanel painelAgencias;
    private JButton voltarButton;
    private JTextArea textoAgencias;
    private TabelaAgencias tabela;

    public TelaAgencias(Gerente gerente){
        tabela = new TabelaAgencias();
        setContentPane(painelAgencias);
        setResizable(false);
        setTitle("Banco Pair Bank");
        setSize(700, 460);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        tabela.addAgencia("Betim - (MG)","001","Caio Andrada");
        tabela.addAgencia("Florestal - (MG)","002","Erika Carvalho");
        tabela.addAgencia("Juatuba - (MG)","003","Tyfany Wesley");
        textoAgencias.setEditable(false);
        textoAgencias.append(tabela.toString());
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaGerente(gerente);
            }
        });
    }

}
