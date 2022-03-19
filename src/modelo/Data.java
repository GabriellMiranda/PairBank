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
    public String getDataModelBrasil(){
        String diaStr,mesStr;
        if(dia <10)
            diaStr = "0" + Integer.toString(dia);
        else
            diaStr = Integer.toString(dia);
        if(mes <10)
            mesStr = "0" + Integer.toString(mes);
        else
            mesStr = Integer.toString(mes);

        return diaStr+"/"+mesStr+"/"+Integer.toString(ano);
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
