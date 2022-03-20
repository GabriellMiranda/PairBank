import modelo.Cliente;
import visao.popUPmensagem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controle.ControleCadastro;
import controle.ControleContaPoupanca;
import controle.ControleContaCorrente;

public class TelaDeposito extends JFrame{
    private JTextField valorAserDepositado;
    private JButton depositarButton;
    private JButton voltarButton;
    private JPanel painelDeposito;
    private popUPmensagem mensagem;
    private ControleCadastro controle;
    private ControleContaPoupanca contaPoupanca;
    private ControleContaCorrente contaCorrente;
    public TelaDeposito(Cliente cliente){
        mensagem = new popUPmensagem();
        controle = new ControleCadastro();
        contaCorrente = new ControleContaCorrente();
        contaPoupanca = new ControleContaPoupanca();
        setContentPane(painelDeposito);
        setTitle("Banco Pair Bank");
        setSize(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
        depositarButton.addActionListener(new ActionListener() {// aqui sera depositado na conta do usuário um valor ficticio
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controle.oValorEhDouble(valorAserDepositado.getText())){
                    if(cliente.getTipodeConta().equals("corrente"))
                        if(contaCorrente.Deposito(Double.parseDouble(valorAserDepositado.getText()),cliente.getCpf(),cliente.contaCorrente)) {
                            mensagem.alerta("O valor de " + valorAserDepositado.getText() + " foi depositado em sua conta com sucesso");
                        }
                        else mensagem.alerta("O valor inserido não é possivel de ser depositado");
                    else
                    if(contaPoupanca.Deposito(Double.parseDouble(valorAserDepositado.getText()),cliente.contaPoupanca)){
                        mensagem.alerta("O valor de "+ valorAserDepositado.getText() + " foi depositado em sua conta com sucessos");
                    }
                    else mensagem.alerta("O valor inserido não é possivel de ser depositado");
                }
                else mensagem.alerta("O valor a ser depositado deve ser um número");
            }
        });
    }
}
