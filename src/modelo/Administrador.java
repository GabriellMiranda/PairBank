package modelo;

import java.util.Scanner;

public class Administrador {
    private String usuario;
    private String senha;
    private String CPF;
    private String idCliente; //chave estrangeira

    public void cadastroADM(){ // devem haver apenas duas contas ADM (vefiricar quanto implementar BD)
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEntre com um nome de usuário:");
        setUsuario(scan.next());
        System.out.print("\nSenha:");
        setSenha(scan.next());
        System.out.print("\nCPF(apenas números):");
        setCPF(scan.next());
        System.out.print("\nCadastro efeituado com sucesso!");
    }

    public void login(){//implementar quando houver BD

    }

    public String getSenha() {
        return senha;
    }

    public String getCPF() {
        return CPF;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private void setCPF(String CPF){
        if(validaCPF(CPF)){
            this.CPF = CPF;
        }
        else{
            String newCPF;
            Scanner scan = new Scanner(System.in);
            System.out.print("\nCPF inválido! Digite novamente (apenas números):");
            newCPF = scan.next();
            setCPF(newCPF);
        }
    }

    private boolean validaCPF(String CPF){
        if(CPF.length() == 11) {
            String[] aux = CPF.split("");
            int qtd = 0;
            String verify = aux[0];
            for(String c:aux){
                if(c.equals(verify)){
                    qtd++;
                }
            }
            return primeiroDigitoVerificador(aux) && segundoDigitoVerificador(aux) && qtd < 11;
        }
        else{
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

    private void setSenha(String senha){
        if(this.validaSenha(senha)){
            this.senha = senha;
        }
        else{
            String newSenha;
            Scanner scan = new Scanner(System.in);
            System.out.print("Digite uma nova senha:");
            newSenha = scan.next();
            setSenha(newSenha);
        }
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
}
