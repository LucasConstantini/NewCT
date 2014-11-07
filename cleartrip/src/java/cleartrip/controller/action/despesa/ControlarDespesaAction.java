package cleartrip.controller.action.despesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.DespesaDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Despesa;
import cleartrip.model.pojo.Transporte;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mentawai.core.BaseAction;

public class ControlarDespesaAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<CategoriaDespesa> categoriasDespesa = ServiceLocator.getCategoriaDespesaService().readByCriteria(criteria);
        criteria.clear();
        
        criteria.put(DespesaDAO.CRITERION_USUARIO, usuario.getId());
        List<Despesa> despesas = ServiceLocator.getDespesaService().readByCriteria(criteria);
        Set<Despesa> setDespesa = new HashSet<Despesa>(despesas);
        Map<Long, Double> despesasOptions = new LinkedHashMap<Long, Double>();
        for (Despesa despesa : despesas) {
            despesasOptions.put(despesa.getId(), despesa.getValor());
        }
        output.setValue("despesasOptions", despesasOptions);
        
        output.setValue("lista", categoriasDespesa);
        
        
        return SUCCESS;
    }
}
