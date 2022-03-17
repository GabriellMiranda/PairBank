package visao;

import javax.swing.*;

public class popUPmensagem {
    private JFrame mensagem;
    public popUPmensagem(){
        mensagem = new JFrame();
    }
    public void alerta(String mensagemAlerta){
        JOptionPane.showMessageDialog(mensagem,mensagemAlerta);
    }
}
