package modelo;

public class Transacao {
    private Data date;
    private String descricao;
    private double valor;

    public Transacao(String descricao, int dia, int mes, int ano, double valor){
        this.descricao = descricao;
        date = new Data(dia, mes, ano);
        this.valor = valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public String toString(){
        return date.toString() + " " + getDescricao() + " " + Double.toString(valor);
    }

}
