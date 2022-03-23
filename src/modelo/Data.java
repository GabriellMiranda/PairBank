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

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
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
        String aux1 = String.valueOf(mes), aux2 = String.valueOf(dia);
        if(mes < 10){
            aux1 = "0"+String.valueOf(mes);
        }
        if(dia < 10){
            aux2 = "0" + String.valueOf(dia);
        }
        return Integer.toString(this.ano) + "-" + aux1 + "-" + aux2;
    }
}
