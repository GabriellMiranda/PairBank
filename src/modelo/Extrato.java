package modelo;

public class Extrato {
    private Data date;
    private String descricao;
    private double valor;

    public Extrato(String descricao, int dia, int mes, int ano, double valor){
        this.descricao = descricao;
        date = new Data(dia, mes, ano);
        this.valor = valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public String toString(){
        return"=============================================================\n" +
                "|"+ date.toString() + " | " + getDescricao() + " | " + Double.toString(valor)
                +"\n=============================================================\n";
    }

}