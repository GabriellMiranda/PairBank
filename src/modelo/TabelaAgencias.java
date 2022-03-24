package modelo;

public class TabelaAgencias {
    private String agencia;
    private int numero;
    private int nomeGerente;
    public TabelaAgencias(){
        numero = 65;
        nomeGerente = 72;
        agencia = new String("          Nome                                                                   Número                                                                   Nome Gerente\n");
        agencia += "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }
    public void addAgencia(String nome,String numero,String nomeGerente){
        int valorNumero = this.numero;
        switch (nome){
            case "Betim - (MG)":
                valorNumero = this.numero - 6;
                break;
            case "Florestal - (MG)":
                valorNumero = this.numero - 11;
                break;
            case "Juatuba - (MG)":
                valorNumero = this.numero - 10;
                break;
        }
        agencia += "          "+nome;
        for(int i = 0;i<valorNumero;i++){
            agencia += " ";
        }
        agencia+=numero;
        for(int i = 0;i<this.nomeGerente;i++){
            agencia += " ";
        }
        agencia+=nomeGerente;
        agencia += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }

    public String toString(){
        return agencia;
    }
}
