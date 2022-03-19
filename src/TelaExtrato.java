import modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class TelaExtrato extends JFrame {
    private JButton voltarButton;
    private JPanel painelExtrato;
    private JTextArea textoExtrato;

    public TelaExtrato(Cliente cliente){
        setContentPane(painelExtrato);
        setTitle("Banco Pair Bank");
        setSize(650, 460);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        TabelaExtrato tabela = new TabelaExtrato();
        tabela.addExtrato("Deposito","21/12/2021","0");
        tabela.addExtrato("Saque","12/12/2012","1661");
        tabela.addExtrato("Deposito","21/12/2021","18822");
        tabela.addExtrato("Saque","12/12/2012","1661");
        tabela.addExtrato("Deposito","21/12/2021","18822");
        tabela.addExtrato("Pix","10/10/2010","100");
        tabela.addExtrato("Transferência","10/10/2010","100");
        tabela.addExtrato("Saque","12/12/2012","1661");
        tabela.addExtrato("Deposito","21/12/2021","18822");
        tabela.addExtrato("Saque","12/12/2012","1661");
        textoExtrato.append(tabela.toString());
        textoExtrato.setEditable(false);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaUsuario(cliente);
            }
        });
    }
}

class TabelaExtrato{
    private String extrato;
    private int valorPixSpace;
    private int valorTransferenciaSpace;
    private int valorSaqueSpace;
    private int valorDepositoSpace;
    public TabelaExtrato(){
        valorPixSpace = 75;
        valorDepositoSpace = 64;
        valorSaqueSpace = 68;
        valorTransferenciaSpace = 55;
        extrato = new String("          Descrição                                                                   Data                                                                   Valor\n");
        extrato += "----------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }
    public void addExtrato(String descricao,String data,String valor){
        extrato += "          "+descricao;
        switch (descricao) {
            case "Pix":
                for (int i = 0; i < valorPixSpace; i++) {
                    extrato += " ";
                }
                break;
            case "Transferência":
                for (int i = 0; i < valorTransferenciaSpace; i++) {
                    extrato += " ";
                }
                break;
            case "Saque":
                for (int i = 0; i < valorSaqueSpace; i++) {
                    extrato += " ";
                }
                break;
            case "Deposito":
                for (int i = 0; i < valorDepositoSpace; i++) {
                    extrato += " ";
                }
                break;
        }
        extrato+=data;
        if(valor.length() > 4)
            for(int i = 0;i<59;i++){
                extrato += " ";
            }
        else
            for(int i = 0;i<60;i++){
                extrato += " ";
            }
        extrato+=valor;
        extrato += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }

    public String toString(){
        return extrato;
    }
}
