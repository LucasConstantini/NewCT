package cleartrip.controller.action.despesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.DespesaDAO;
import cleartrip.model.pojo.Despesa;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class DespesaReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        Usuario usuarioLogado = new Usuario();
        usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado != null) {
            criteria.put(DespesaDAO.CRITERION_VIAGEM, input.getLong("viagem.id"));
            criteria.put(DespesaDAO.CRITERION_USUARIO, usuarioLogado.getId());
            List<Despesa> despesas = ServiceLocator.getDespesaService().readByCriteria(criteria);
            output.setValue("lista", despesas);

        }
        else{
            consequence = ERROR;
        }

        Map<String,Double> mapa = ServiceLocator.getUsuarioService().listGastos(usuarioLogado.getId());
        output.setValue("gastos", mapa);
        
        return consequence;
    }
}
