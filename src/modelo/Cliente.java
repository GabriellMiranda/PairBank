package modelo;

public class Cliente extends Pessoa{
    private String senha;
    private String Agencia, conta;
    private Data dataCriacaodaConta;
    public ContaCorrente contaCorrente;
    private tipoConta TipoDeConta;


    public void defineTipoConta(String nomeTipo){
        if(nomeTipo.equals("corrente")){
            this.TipoDeConta = tipoConta.CORRENTE;
        }
        else{
            this.TipoDeConta = tipoConta.POUPANCA;
        }
    }

    private enum tipoConta {
        CORRENTE("corrente"),POUPANCA("poupança");

        private String descricao;

        tipoConta(String descricao) {
            this.descricao = descricao;
        }

        public String toString(){
            return this.descricao;
        }
    }
    public Cliente(String agencia, String conta, String senha, String tipodeconta,String nome, String cpf, int diaNascimento,int mesNascimento,int anoNascimento, int diaCriacao,
                   int mesCriacao,int anoCriacao){
        super(nome,cpf,diaNascimento,mesNascimento,anoNascimento);
        this.Agencia = agencia;
        this.dataCriacaodaConta = new Data(diaCriacao,mesCriacao,anoCriacao);
        this.defineTipoConta(tipodeconta);
        this.conta = conta;
        this.senha = senha;
        this.contaCorrente = new ContaCorrente(0);
    }
    public String getAgencia(){
        return Agencia;
    }
    public String getConta() {
        return conta;
    }
    public String getDataCriacaodaConta(){
        return dataCriacaodaConta.toString();
    }
    public String getTipodeConta(){
        return this.TipoDeConta.toString();
    }
    public String getSenha(){
        return senha;
    }


    public void setAgencia(String agencia) {
        this.Agencia = agencia;
    }
    public void setConta(String conta){
        this.conta = conta;
    }

    public String toString(){
         return super.toString()+"\n" + "Agencia:"+ Agencia +"\n"+ "Conta:"+conta +"\n"+
         "Data Criacção da conta:"+dataCriacaodaConta +"\n"+
         "Tipo de conta:"+ this.TipoDeConta +"valor em conta:"+contaCorrente+"\n";
    }

}

class Data{
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia,int mes,int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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
        return Integer.toString(this.dia) + "/" + Integer.toString(this.mes) + "/" + Integer.toString(this.ano);
    }
}