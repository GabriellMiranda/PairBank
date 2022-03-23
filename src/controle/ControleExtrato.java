package controle;
import Dao.ExtratoDao;
import modelo.Cliente;
import modelo.Data;
import modelo.TabelaExtrato;
import controle.ControleCliente;
public class ControleExtrato {

    public void verificarExtrato(String cpf){
        ExtratoDao extratoDao = new ExtratoDao();
        extratoDao.imprimirExtratos(cpf);
    }

    public TabelaExtrato obterExtrato(String cpf){
        ExtratoDao extrato = new ExtratoDao();
        ControleCliente controle = new ControleCliente();
        if(controle.verificandoExistenciaCliente(cpf) == null){
            return null;
        }
        return extrato.obterExtrato(cpf);
    }
}
