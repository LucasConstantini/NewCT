package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
       form.put("id", input.getLong("categoriaDespesa.id"));
       form.put("nome", input.getString("categoriaDespesa.nome"));
       form.put("valorLimite", input.getDouble("categoriaDespesa.valorLimite"));
       Map<String, String> error = ServiceLocator.getCategoriaDespesaService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            CategoriaDespesa categoriaDespesa = new CategoriaDespesa(); 
            categoriaDespesa.setId((Long) form.get("id"));
            categoriaDespesa.setNome((String) form.get("nome"));
            categoriaDespesa.setValorLimite((Double) form.get("valorLimite"));
            ServiceLocator.getCategoriaDespesaService().update(categoriaDespesa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}