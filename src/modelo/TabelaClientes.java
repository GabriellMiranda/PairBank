package modelo;

public class TabelaClientes {
    private String Cliente;
    private int nomeCliente;
    public TabelaClientes(){
        nomeCliente = 85;
        Cliente = new String("                                              CPF                                                                                               Nome Cliente\n");
        Cliente += "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }
    public void addCliente(String nome,String CPF){
        Cliente += "                                       "+CPF;
        for(int i = 0;i<nomeCliente;i++){
            Cliente += " ";
        }
        Cliente+=nome;
        Cliente += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }

    public String toString(){
        return Cliente;
    }
}
