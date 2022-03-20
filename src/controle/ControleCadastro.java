package controle;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;
import visao.popUPmensagem;
public class ControleCadastro {

    private static final Logger LOGGER = Logger.getLogger("controleCadastro");
    private popUPmensagem mensagem;
    public ControleCadastro(){
        mensagem = new popUPmensagem();
    }

    public boolean oValorEhMaiorQue0(String valor){
        return Double.parseDouble(valor) > 0;
    }
    public String makeStringVetorInString(String[] entrada){
        String stringSaida = new String("");
        for(String c:entrada){
            stringSaida +=c;
        }
        return stringSaida;
    }

    public String[] makeCharToStringVetor(char[] valores){
        String[] retorno = new String[valores.length];
        int pos = 0;
        for(char c : valores){
            retorno[pos] = Character.toString(c);
            pos++;
        }
        return retorno;
    }
    public boolean dataEhValida(int dia,int mes,int ano){
        if(dia > 31 || dia <= 0){
            return false;
        }
        else {
            if (mes > 12 || mes < 0) {
                return false;
            } else {
                Date dataHoraAtual = new Date();
                String anoAtual = new SimpleDateFormat("yyyy").format(dataHoraAtual);
                return ano < Integer.parseInt(anoAtual) && ano > 0;
            }
        }
    }

    public boolean oValorEhInteiro(String valor){
        try {
            Integer.parseInt(valor);
            return true;
        }
        catch (Exception error){
            return false;
        }
    }

    public boolean oValorEhDouble(String valor){
        try {
            Double.parseDouble(valor);
            return true;
        }
        catch (Exception error){
            return false;
        }
    }

    public boolean CPF(String CPF){
        return this.validaCPF(CPF);
    }

    public boolean SENHA(String[] senha){
        return this.validaSenha(senha);
    }
    //validando a senha do usuário que deve ter ao menos 8 dígitos e 1 letra maiuscula e 1 número
    private boolean validaSenha(String[] senha){
        if(senha.length < 8){
            mensagem.alerta("Para a segurança do sistema, a senha deve possuir 8 digitos!");
            LOGGER.warning("\nPara a segurança do sistema, a senha deve possuir 8 digitos!\n");
            return false;
        }
        else {
            int qtdLetrasMaiusculas = 0;
            int qtdLetras = 0;
            int qtdNumeros = 0;
            for (String c : senha) {
                if(!c.equals("9") && !c.equals("8") && !c.equals("7") && !c.equals("6") &&
                        !c.equals("5") && !c.equals("4") && !c.equals("3") && !c.equals("2") && !c.equals("1") && !c.equals("0")){
                    if(c.equals(c.toUpperCase()))
                        qtdLetrasMaiusculas++;
                    qtdLetras++;
                }
                else{
                    qtdNumeros++;
                }
            }
            if(qtdLetrasMaiusculas == 0 && qtdLetras>0){
                mensagem.alerta("Para a segurança do sistema, a senha deve possuir ao menos uma letra maiúscula!");
                LOGGER.warning("\nPara a segurança do sistema, a senha deve possuir ao menos uma letra maiúscula!\n");
                return false;
            }
            else if(qtdNumeros == 0){
                mensagem.alerta("Para a segurança do sistema, a senha deve possuir ao menos um numero!");
                LOGGER.warning("\nPara a segurança do sistema, a senha deve possuir ao menos um numero!\n");
                return false;
            }
            else if(qtdLetras == 0){
                mensagem.alerta("Para a segurança do sistema, a senha deve possuir ao menos uma letra!");
                LOGGER.warning("\nPara a segurança do sistema, a senha deve possuir ao menos uma letra!\n");
                return false;
            }
            else{
                return true;
            }
        }
    }

    private boolean validaCPF(String CPF) {
        if (CPF.length() == 11) {
            String[] aux = CPF.split("");
            int qtd = 0;
            String verify = aux[0];
            for (String c : aux) {
                if (c.equals(verify)) {
                    qtd++;
                }
            }
            return primeiroDigitoVerificador(aux) && segundoDigitoVerificador(aux) && qtd < 11;
        } else {
            return false;
        }
    }
    private boolean primeiroDigitoVerificador(String[] CPF){
        int result = 0;
        for (int i = 0; i < 9; i++) {
            result += Integer.parseInt(CPF[i]) * (10-i);
        }
        result = (result*10)%11;
        if(result == 10)
            result = 0;
        return result == Integer.parseInt(CPF[9]);
    }

    private boolean segundoDigitoVerificador(String[] CPF){
        int result = 0;
        for(int i = 0;i<10;i++){
            result += Integer.parseInt(CPF[i]) * (11 - i);
        }
        result = (result*10)%11;
        return result == Integer.parseInt(CPF[10]);
    }
}