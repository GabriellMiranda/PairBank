import modelo.Cliente;
import visao.popUPmensagem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEmprestimo extends JFrame{
    private JButton voltarButton;
    private JButton solicitarEmpréstimoButton;
    private JLabel ValorSalario;
    private JLabel valorEmpréstimo;
    private JPanel painelEmprestimo;
    private popUPmensagem mensagem;

    public TelaEmprestimo(Cliente cliente){
        mensagem = new popUPmensagem();
        setContentPane(painelEmprestimo);
        setTitle("Banco Pair Bank");
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        ValorSalario.setText(Double.toString(cliente.getSalario()));
        valorEmpréstimo.setText(Double.toString(cliente.getSalario() + cliente.getSalario()*0.15));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
        solicitarEmpréstimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// aqui vai ser depositado na conta do usuário o valor do empréstimo
                if(cliente.getTipodeConta().equals("corrente")) {
                    cliente.contaCorrente.setValor(cliente.contaCorrente.getValor() + cliente.getSalario() + cliente.getSalario() * 0.15);
                }
                else{
                    cliente.contaPoupanca.setValor(cliente.contaPoupanca.getValor() + cliente.getSalario() + cliente.getSalario() * 0.15);
                }
                //Depositar o valor no banco de dados
                mensagem.alerta("Foi depositado em sua conta o valor do empréstimo!");
            }
        });
    }
}
