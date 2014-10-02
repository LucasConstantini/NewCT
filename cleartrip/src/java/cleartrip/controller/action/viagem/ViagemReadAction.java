package cleartrip.controller.action.viagem;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.ViagemDAO;
import cleartrip.model.pojo.Viagem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ViagemReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        String status = input.getString("status");
        if (nome != null && !nome.isEmpty()) {
            criteria.put(ViagemDAO.CRITERION_USUARIO_EQ, nome);
        }
        if (status != null && !status.isEmpty()) {
            criteria.put(ViagemDAO.CRITERION_STATUS_EQ, status);
        }
        List<Viagem> viagens = ServiceLocator.getViagemService().readByCriteria(criteria);
        output.setValue("lista", viagens);
        return consequence;
    }
}
