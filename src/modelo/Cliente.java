package modelo;

public class Cliente {
    public Pessoa pessoa;
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

    public Cliente(String agencia, String conta, String senha, String tipodeconta, Pessoa pessoa1, int diaCriacao,int mesCriacao,int anoCriacao){
        this.pessoa = pessoa1;
        this.Agencia = agencia;
        this.dataCriacaodaConta = new Data(diaCriacao,mesCriacao,anoCriacao);
        this.defineTipoConta(tipodeconta);
        this.conta = conta;
        this.senha = senha;
        this.contaCorrente = new ContaCorrente(0);
    }

    /*public void isTipoConta(String tipodeconta, double valor){
        if ("Corrente".equals(tipodeconta)){
            contaCorrente = new ContaCorrente();
            contaPoupanca = new ContaPoupanca(valor);
        }else if("Poupança".equals(tipodeconta)){
            contaPoupanca = new ContaPoupanca(valor);
        }
    }
*/
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
    public Pessoa getPessoa(){
        return this.pessoa;
    }
    public String getCPFpessoa(){return this.pessoa.getCpf();}

    public void setAgencia(String agencia) {
        this.Agencia = agencia;
    }
    public void setConta(String conta){
        this.conta = conta;
    }

    public String toString(){
         return pessoa +"\n"+ "Senha:"+senha +"\n" + "Agencia:"+ Agencia +"\n"+ "Conta:"+conta +"\n"+
         "Data Criacção da conta:"+dataCriacaodaConta +"\n"+
         "Tipo de conta:"+ this.TipoDeConta +"\n"+
         contaCorrente;
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