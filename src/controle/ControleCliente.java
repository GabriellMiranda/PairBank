package controle;

import Dao.ClienteDao;
import modelo.Cliente;

import java.util.logging.Logger;

public class ControleCliente {
    private static final Logger LOGGER = Logger.getLogger("controleCliente");
    private ControleCadastro validar = new ControleCadastro();
    private ClienteDao clienteDao;

    public ControleCliente(){
        clienteDao = new ClienteDao();
    }


    public boolean cadastroCliente(double salario,String agencia, String conta, String senha, String tipodeconta, String nome, String cpf, int diaNascimento, int mesNascimento, int anoNascimento, int diaCriacao,
                                   int mesCriacao, int anoCriacao) {

       if(clienteDao.clienteExiste(cpf) != null){
           LOGGER.info("CLiente já existente no banco de dados");
           return false;
       }
       Cliente cliente = new Cliente(agencia,conta,senha,tipodeconta,nome,cpf,diaNascimento,mesNascimento,anoNascimento,diaCriacao, mesCriacao,anoCriacao);
       cliente.setSalario(salario);
       clienteDao.inserirCliente(cliente);
       return true;
    }
    public String getNewNumConta(String numeroAgencia){
        return clienteDao.getNewNumConta(numeroAgencia);
    }
    public double simularEmprestimo(Cliente cli){
        return cli.getSalario() + cli.getSalario()*0.1;
    }
    public Cliente login(String CPF,String senha) {
        String tipoConta = clienteDao.clienteExiste(CPF);
        if(tipoConta.equals("corrente")){
            return clienteDao.loginBDCorrente(CPF, senha);
        }else{
            return clienteDao.loginBDPoupanca(CPF, senha);
        }

    }

    public Cliente retornaCliente(String cpf){
        return clienteDao.retornaCliente(cpf);
    }

    public String verificandoExistenciaCliente(String CPF) {
       return clienteDao.clienteExiste(CPF);
    }

    public void alterarNome(Cliente cliente,String novoNome){
        clienteDao.atualizarNome(cliente.getCpf(),novoNome);
    }
    public void alterarSenha(Cliente cliente,String novaSenha){
        clienteDao.atualizarSenha(cliente.getCpf(),novaSenha);
    }
    public void alterarData(Cliente cliente,String Data){
        clienteDao.atualizarDataNascimento(cliente.getCpf(),Data);
    }
}
