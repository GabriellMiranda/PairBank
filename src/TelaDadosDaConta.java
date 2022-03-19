import modelo.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDadosDaConta extends JFrame{
    private JLabel numeroDaConta;
    private JLabel numeroAgencia;
    private JLabel NomeDoUsuario;
    private JLabel Senha;
    private JButton voltarButton;
    private JPanel painelDados;
    private JLabel cpf;
    private JLabel tipoDeConta;

    public TelaDadosDaConta(Cliente cliente){
        setContentPane(painelDados);
        setTitle("Pair Bank Cadastro");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        // aqui devem ser feitas as atribuições dos valores do usuario
        NomeDoUsuario.setText(cliente.getNome());
        Senha.setText(cliente.getSenha());
        numeroDaConta.setText(cliente.getConta());
        numeroAgencia.setText(cliente.getAgencia());
        cpf.setText(cliente.getCpf());
        tipoDeConta.setText(cliente.getTipodeConta());
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
    }

}
