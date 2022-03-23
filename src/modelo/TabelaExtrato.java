package modelo;

public class TabelaExtrato{
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
