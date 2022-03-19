import modelo.Cliente;
import visao.popUPmensagem;
import visao.popUPmensagem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaConfiguracoes extends JFrame{
    private JPanel painelConfig;
    private JButton alterarSenhaButton;
    private JButton alterarNomeButton;
    private JButton alterarDataDeNascimentoButton;
    private JButton voltarButton;
    private JLabel valorDataNascimento;
    private JLabel valorNome;
    private JPasswordField novaSenha;
    private JTextField NovoNome;
    private JTextField novoDiaNascimento;
    private JTextField NovoMesNascimento;
    private JTextField NovoAnoNascimento;
    private popUPmensagem mensagem;

    public TelaConfiguracoes(Cliente cliente) {
        mensagem = new popUPmensagem();
        setContentPane(painelConfig);
        setTitle("Banco Pair Bank");
        setSize(900, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        valorNome.setText(cliente.getNome());
        valorDataNascimento.setText(cliente.getDataNascimentoModelBrasil());
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
        alterarSenhaButton.addActionListener(new ActionListener() {// alterar a senha o usuário
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        alterarNomeButton.addActionListener(new ActionListener() {// alterar o nome de usuário
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        alterarDataDeNascimentoButton.addActionListener(new ActionListener() {// alterar a data de nascimento
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
