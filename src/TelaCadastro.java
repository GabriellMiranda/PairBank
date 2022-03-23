import controle.ControleAgencia;
import controle.ControleCadastro;
import controle.ControleCliente;
import visao.popUPmensagem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class TelaCadastro extends JFrame{
    private JTextField textNome;
    private JTextField textCPF;
    private JTextField textSalario;
    private JTextField textDiaNasc;
    private JTextField textMesNasc;
    private JTextField textAnoNasc;
    private JPasswordField password1;
    private JPasswordField password2;
    private JRadioButton contaCorrente;
    private JRadioButton contaPoupança;
    private JButton criarButton;
    private JButton voltarButton;
    private JPanel painelCadastro;
    private JCheckBox exibirSenhas;
    private char previewCharSenha;
    private ControleCadastro controleEntradas;
    private ControleCliente controleCadastro;
    private ControleAgencia controleAG;
    private popUPmensagem mensagem;

    public TelaCadastro(){
        mensagem = new popUPmensagem();
        controleEntradas = new ControleCadastro();
        controleCadastro = new ControleCliente();
        controleAG = new ControleAgencia();
        previewCharSenha = password1.getEchoChar();
        setContentPane(painelCadastro);
        setTitle("Pair Bank Cadastro");
        setSize(600,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaLogin();
            }
        });
        exibirSenhas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(exibirSenhas.isSelected()){
                    password1.setEchoChar('\u0000');
                    password2.setEchoChar('\u0000');
                }
                else{
                    password1.setEchoChar(previewCharSenha);
                    password2.setEchoChar(previewCharSenha);
                }
            }
        });
        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textNome.getText().equals("")){
                    mensagem.alerta("O campo nome deve ser preenchido");
                }
                else{
                    if(controleEntradas.CPF(textCPF.getText())){
                        if(controleEntradas.oValorEhInteiro(textDiaNasc.getText())){
                            int diaNasc = Integer.parseInt(textDiaNasc.getText());
                            if(controleEntradas.oValorEhInteiro(textMesNasc.getText())){
                                int mesNasc = Integer.parseInt(textMesNasc.getText());
                                if(controleEntradas.oValorEhInteiro(textAnoNasc.getText())){
                                    int anoNasc = Integer.parseInt(textAnoNasc.getText());
                                    String[] senha1 = controleEntradas.makeCharToStringVetor(password1.getPassword());
                                    String[] senha2 = controleEntradas.makeCharToStringVetor(password2.getPassword());
                                    if(Arrays.equals(senha1, senha2)){
                                        if(controleEntradas.SENHA(senha1)){
                                            if(!contaPoupança.isSelected() && !contaCorrente.isSelected()){
                                                mensagem.alerta("O campo do tipo de conta deve ser selecionado");
                                            }
                                            else{
                                                if(controleEntradas.dataEhValida(diaNasc,mesNasc,anoNasc)) {
                                                    Date dataHoraAtual = new Date();
                                                    String dia = new SimpleDateFormat("dd").format(dataHoraAtual);
                                                    String mes = new SimpleDateFormat("MM").format(dataHoraAtual);
                                                    String ano = new SimpleDateFormat("yyyy").format(dataHoraAtual);
                                                    String numeroAgencia = controleAG.getAgencia();
                                                    double salario;
                                                    if(textSalario.getText().equals("")){
                                                        if(contaCorrente.isSelected())
                                                            controleCadastro.cadastroCliente(0,numeroAgencia,
                                                                    controleCadastro.getNewNumConta(numeroAgencia),
                                                                    controleEntradas.makeStringVetorInString(senha1),"corrente",
                                                                    textNome.getText(),textCPF.getText(),diaNasc,mesNasc,anoNasc,
                                                                    Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(ano));
                                                        else
                                                            controleCadastro.cadastroCliente(0,numeroAgencia,
                                                                    controleCadastro.getNewNumConta(numeroAgencia),
                                                                    controleEntradas.makeStringVetorInString(senha1),"poupanca",
                                                                    textNome.getText(),textCPF.getText(),diaNasc,mesNasc,anoNasc,
                                                                    Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(ano));

                                                        mensagem.alerta("Cadastro efetuado com sucesso!");
                                                        setVisible(false);
                                                        new TelaLogin();//voltando para a tela de login
                                                    }
                                                    else{
                                                        if(controleEntradas.oValorEhDouble(textSalario.getText())){
                                                            salario = Double.parseDouble(textSalario.getText());
                                                            if(contaCorrente.isSelected())
                                                                controleCadastro.cadastroCliente(salario,numeroAgencia,
                                                                        controleCadastro.getNewNumConta(numeroAgencia),
                                                                        controleEntradas.makeStringVetorInString(senha1),"corrente",
                                                                        textNome.getText(),textCPF.getText(),diaNasc,mesNasc,anoNasc,
                                                                        Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(ano));
                                                            else
                                                                controleCadastro.cadastroCliente(salario,numeroAgencia,
                                                                        controleCadastro.getNewNumConta(numeroAgencia),
                                                                        controleEntradas.makeStringVetorInString(senha1),"poupanca",
                                                                        textNome.getText(),textCPF.getText(),diaNasc,mesNasc,anoNasc,
                                                                        Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(ano));

                                                            mensagem.alerta("Cadastro efetuado com sucesso!");
                                                            setVisible(false);
                                                            new TelaLogin();//voltando para a tela de login
                                                        }
                                                        else{
                                                            mensagem.alerta("O valor do salário não foi preenchido corretamente");
                                                        }
                                                    }
                                                }
                                                else{
                                                    mensagem.alerta("A data de nascimento inserida não é válida");
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        mensagem.alerta("As senhas devem ser compatíveis");
                                    }
                                }
                                else{
                                    mensagem.alerta("O campo 'ano de nascimento' não foi preenchido corretamente");
                                }
                            }
                            else{
                                mensagem.alerta("O campo 'mês de nascimento' não foi preenchido corretamente");
                            }
                        }
                        else{
                            mensagem.alerta("O campo 'dia de nascimento' não foi preenchido corretamente");
                        }
                    }
                    else{
                        mensagem.alerta("CPF inválido! Tente não inserir caracteres especiais");
                    }
                }
            }
        });
        contaCorrente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contaPoupança.isSelected()){
                    contaPoupança.setSelected(false);
                }
            }
        });
        contaPoupança.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contaCorrente.isSelected()){
                    contaCorrente.setSelected(false);
                }
            }
        });
    }
}
