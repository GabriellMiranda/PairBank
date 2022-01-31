package controle;
import modelo.Cliente;
import modelo.Pessoa;
import modelo.Administrador;


public class controleCadastro {
    public boolean CPF(String CPF){
        return this.validaCPF(CPF);
    }

    public boolean SENHA(String senha){
        return this.validaSenha(senha);
    }

    private boolean validaSenha(String senha){
        String[] aux = senha.split("");
        if(aux.length < 8){
            System.out.print("\nPara a segurança do sistema, a senha deve possuir 8 digitos!\n");
            return false;
        }
        else {
            int qtdLetrasMaiusculas = 0;
            int qtdLetras = 0;
            int qtdNumeros = 0;
            for (String c : aux) {
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
                System.out.println("\nPara a segurança do sistema, a senha deve possuir ao menos uma letra maiúscula!");
                return false;
            }
            else if(qtdNumeros == 0){
                System.out.println("\nPara a segurança do sistema, a senha deve possuir ao menos um numero!");
                return false;
            }
            else if(qtdLetras == 0){
                System.out.println("\nPara a segurança do sistema, a senha deve possuir ao menos uma letra!");
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