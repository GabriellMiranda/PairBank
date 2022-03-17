package modelo;

public class Data{
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia,int mes,int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getAnoFromString(String Data){
        String[] data = Data.split("-");
        return Integer.parseInt(data[0]);
    }
    public int getMesFromString(String Data){
        String[] data = Data.split("-");
        return Integer.parseInt(data[1]);
    }
    public int getDiaFromString(String Data){
        String[] data = Data.split("-");
        return Integer.parseInt(data[2]);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return this.dia;
    }

    public String toString(){
        return Integer.toString(this.ano) + "-" + Integer.toString(this.mes) + "-" + Integer.toString(this.dia);
    }
}
