import controle.ControleCadastro;
import controle.ControleCliente;
import modelo.Cliente;
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
    private ControleCadastro controle;
    private ControleCliente controleCliente;

    public TelaConfiguracoes(Cliente cliente) {
        mensagem = new popUPmensagem();
        controle = new ControleCadastro();
        controleCliente = new ControleCliente();
        setContentPane(painelConfig);
        setTitle("Pair Bank");
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
                String[] senha = controle.makeCharToStringVetor(novaSenha.getPassword());
                if(controle.SENHA(senha)){
                    cliente.setSenha(controle.makeStringVetorInString(senha));
                    controleCliente.alterarSenha(cliente,controle.makeStringVetorInString(senha));
                    mensagem.alerta("Senha alterada com sucesso!");
                }
            }
        });
        alterarNomeButton.addActionListener(new ActionListener() {// alterar o nome de usuário
            @Override
            public void actionPerformed(ActionEvent e) {
                if(NovoNome.getText().equals("")){
                    mensagem.alerta("O campo de nome deve ser preenchido para ser alterado");
                }
                else {
                    cliente.setNome(NovoNome.getText());
                    NovoNome.setText("");
                    valorNome.setText(cliente.getNome());
                    controleCliente.alterarNome(cliente,cliente.getNome());
                    mensagem.alerta("O nome de usuário foi alterado com sucesso!");
                }
            }
        });
        alterarDataDeNascimentoButton.addActionListener(new ActionListener() {// alterar a data de nascimento
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controle.oValorEhInteiro(novoDiaNascimento.getText())){
                    if(controle.oValorEhInteiro(NovoMesNascimento.getText())){
                        if(controle.oValorEhInteiro(NovoAnoNascimento.getText())){
                            int dia = Integer.parseInt(novoDiaNascimento.getText());
                            int mes = Integer.parseInt(NovoMesNascimento.getText());
                            int ano = Integer.parseInt(NovoAnoNascimento.getText());
                            if(controle.dataEhValida(dia,mes,ano)){
                                novoDiaNascimento.setText("");
                                NovoAnoNascimento.setText("");
                                NovoMesNascimento.setText("");
                                cliente.setDataNascimento(dia,mes,ano);
                                valorDataNascimento.setText(cliente.getDataNascimentoModelBrasil());
                                controleCliente.alterarData(cliente,cliente.getDataNascimento());
                                mensagem.alerta("Data de nascimento alterada com sucesso!");
                            }
                            else mensagem.alerta("A data inserida não é válida!");
                        }
                        else mensagem.alerta("O ano inserido não é válido!");
                    }
                    else mensagem.alerta("O mês inserido não é válido!");
                }
                else mensagem.alerta("O dia inserido não é válido!");
            }
        });
    }
}
