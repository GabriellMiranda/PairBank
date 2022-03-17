import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import controle.ControleCliente;
import modelo.Cliente;

public class TelaLogin extends JFrame{
    private JTextField txtCPF;
    private JPasswordField senhaTXT;
    private JButton novoCadastroButton;
    private JCheckBox exibirSenhaCheckBox;
    private JButton entrarButton;
    private JPanel painelLogin;
    private JLabel mensagemErro;
    private char previewCharSenhaExibir;
    private ControleCliente controle;
    private Cliente cliente;

    public TelaLogin(){
        previewCharSenhaExibir = senhaTXT.getEchoChar();
        controle = new ControleCliente();
        setContentPane(painelLogin);
        setTitle("Pair Bank");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente = controle.login(txtCPF.getText(), Arrays.toString(senhaTXT.getPassword()));
                if(cliente == null){
                    mensagemErro.setText("Senha ou CPF incorretos");
                }
                else{
                    System.out.println("Entrar na tela do cliente para realizar as operações no banco");
                }
            }
        });
        exibirSenhaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(exibirSenhaCheckBox.isSelected())
                    senhaTXT.setEchoChar('\u0000');
                else senhaTXT.setEchoChar(previewCharSenhaExibir);
            }
        });
        novoCadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TelaCadastro cadastro = new TelaCadastro();
            }
        });
    }

    public static void main(String[] args){
        TelaLogin frontEnd = new TelaLogin();
    }
}