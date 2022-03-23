import Dao.GerenteDao;
import modelo.Gerente;
import modelo.TabelaClientes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaClientesLista extends JFrame{
    private GerenteDao gerenteDao;
    private JPanel painelClientes;
    private JButton voltarButton;
    private JTextArea textoClientes;
    private TabelaClientes clientes;

    public TelaClientesLista(Gerente gerente){
        gerenteDao = new GerenteDao();
        setContentPane(painelClientes);
        clientes = new TabelaClientes();
        setResizable(false);
        setTitle("Banco Pair Bank");
        setSize(700, 460);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        textoClientes.setEditable(false);
        gerenteDao.listarClientesBdGerente(gerente.getNumeroAgencia(),clientes);
        textoClientes.append(clientes.toString());
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaGerente(gerente);
            }
        });
    }
}
