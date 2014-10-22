package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Despesa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Long id = input.getLong("id");
//        Map<String, Object> criteria = new HashMap<String, Object>();
//        List<Despesa> despesa = ServiceLocator.getDespesaService().readByCriteria(DespesaDAO.CRITERION_CATEGORIA_DESPESA, criteria);
//        if(despesa.isEmpty()){
        ServiceLocator.getCategoriaDespesaService().delete(id);
        consequence = SUCCESS;
//        }
        
        return consequence;
    }

}
