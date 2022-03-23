import controle.ControleCadastro;
import controle.ControleCliente;
import controle.ControleGerente;
import modelo.Cliente;
import modelo.Gerente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame{
    private JTextField txtCPF;
    private JPasswordField senhaTXT;
    private JButton novoCadastroButton;
    private JCheckBox exibirSenhaCheckBox;
    private JButton entrarButton;
    private JPanel painelLogin;
    private JLabel mensagemErro;
    private JCheckBox souGerente;
    private char previewCharSenhaExibir;
    private ControleCliente controle;
    private Cliente cliente;
    private ControleGerente controleGerente;
    private ControleCadastro conroleEntradas;


    public TelaLogin(){
        previewCharSenhaExibir = senhaTXT.getEchoChar();
        controle = new ControleCliente();
        controleGerente = new ControleGerente();
        conroleEntradas = new ControleCadastro();
        setContentPane(painelLogin);
        setTitle("Pair Bank");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] senhaAux = conroleEntradas.makeCharToStringVetor(senhaTXT.getPassword());
                String senha = conroleEntradas.makeStringVetorInString(senhaAux);
                if(!souGerente.isSelected()) {
                    cliente = controle.login(txtCPF.getText(),senha);
                    if (cliente == null) {
                        mensagemErro.setText("Senha ou CPF incorretos");
                    } else {
                        setVisible(false);
                        new TelaUsuario(cliente);
                    }
                }
                else{
                    Gerente gerente = controleGerente.loginGerente(txtCPF.getText(),senha);
                    if(gerente == null){
                        mensagemErro.setText("Senha ou CPF incorretos");
                    }
                    else{
                        setVisible(false);
                        new TelaGerente(gerente);
                    }
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