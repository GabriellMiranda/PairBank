package com.company;

class no{

    private boolean type;
    private int hashCode;
    public no esquerda;
    public no direita;
    private Object Dados;

    public no criaNoInterno(int hashCode,no esquerda,no direita){
        no novo = new no();
        novo.type = true;
        novo.hashCode = hashCode;
        novo.esquerda = esquerda;
        novo.direita = direita;
        return novo;
    }
    public no criaNoExterno(Object dados,int hashCode){
        no novo = new no();
        novo.hashCode = hashCode;
        novo.type = false;
        novo.esquerda = null;
        novo.direita = null;
        novo.Dados = dados;
        return novo;
    }
    public Object getDados(){
        return this.Dados;
    }
    public boolean getType(){
        return !this.type;
    }
    public int getHashCode(){
        return this.hashCode;
    }
}

class Patricia{
    no root;
    private no insereEntre(Object Dados,no no,int hashCodeInterno){
        if(no.getType()){
            no novo = new no().criaNoExterno(Dados,Dados.hashCode());
            if(Relacao(Dados.hashCode(),no.getDados().hashCode())){
                return new no().criaNoInterno(hashCodeInterno,novo,no);
            }
            else return new no().criaNoInterno(hashCodeInterno,no,novo);
        }
        else{
            if(Relacao(Dados.hashCode(),no.getHashCode())){
                no.esquerda = insereEntre(Dados,no.esquerda,hashCodeInterno);
            }
            else{
                no.direita = insereEntre(Dados,no.direita,hashCodeInterno);
            }
        }
        return no;
    }

    public void insere(Object Dados){
        if(this.root == null){
            this.root =  new no().criaNoExterno(Dados,Dados.hashCode());
        }
        else{
            no aux = this.root;
            while (!aux.getType()){
                if(Relacao(Dados.hashCode(),aux.getHashCode())){
                    aux = aux.esquerda;
                }
                else{
                    aux = aux.direita;
                }
            }
            this.root = insereEntre(Dados, this.root, aux.getHashCode());
        }
    }

    public Object busca(int hashCode){
        no aux = this.root;
        while (!aux.getType()){
            if(Relacao(hashCode,aux.getHashCode()))
                aux = aux.esquerda;
            else aux = aux.direita;
        }
        System.out.print(hashCode+" "+ " "+aux.getHashCode());
        if(hashCode == aux.getHashCode()){
            return aux.getDados();
        }
        else return null;
    }

    private boolean Relacao(int A,int B){
        return A <= B;
    }

    public void imprime(no root){
        if(root.getType()){
            System.out.print(root.getDados() + " ");
        }
        else{
            imprime(root.esquerda);
            imprime(root.direita);
        }
    }
}
