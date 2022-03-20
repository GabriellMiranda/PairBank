package modelo;

public class Cliente extends Pessoa{
    private String senha;
    private String Agencia, conta;
    private Data dataCriacaodaConta;
    public ContaCorrente contaCorrente;
    public ContaPoupanca contaPoupanca;
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
        this.contaPoupanca = new ContaPoupanca(0);
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

    public void setNewDataNascimento(int dia,int mes,int ano){super.setDataNascimento(dia,mes,ano);}
    public void setNomeUsuario(String nome){super.setNome(nome);}
    public void setSenha(String senha){this.senha = senha;}
    public void setAgencia(String agencia) {
        this.Agencia = agencia;
    }
    public void setConta(String conta){
        this.conta = conta;
    }

    public String toString(){
         return super.toString()+"\n" + "Agencia:"+ Agencia +"\n"+ "Conta:"+conta +"\n"+
         "Data Criacção da conta:"+dataCriacaodaConta +"\n"+
         "Tipo de conta:"+ this.TipoDeConta +"\n"+"Saldo conta:"+contaCorrente.getValor()+"\n";
    }

}