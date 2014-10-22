package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.CategoriaDespesaDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        Double valorLimiteInicio = input.getDouble("valorLimiteInicio");
        Double valorLimiteFim = input.getDouble("valorLimiteFim");

        if (nome != null && !nome.isEmpty()) {
            criteria.put(CategoriaDespesaDAO.CRITERION_NOME, nome);
        }
        if (valorLimiteFim != null && !(valorLimiteInicio < 0)) {
            if (valorLimiteInicio != null && !(valorLimiteInicio < 0)) {
                criteria.put(CategoriaDespesaDAO.CRITERION_VALOR_LIMITE_FIM, valorLimiteFim);
                criteria.put(CategoriaDespesaDAO.CRITERION_VALOR_LIMITE_INICIO, valorLimiteInicio);
            }
        }
        else{
            output.setValue("error", "Para Pesquisar é preciso um valor Final!");
        }
        List<CategoriaDespesa> categoriaDespesa = ServiceLocator.getCategoriaDespesaService().readByCriteria(criteria);
        output.setValue("lista", categoriaDespesa);
        return consequence;
    }
}
