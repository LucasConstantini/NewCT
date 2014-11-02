package cleartrip.controller.action.despesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Viagem;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class DespesaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        this.preload();
        return consequence;
    }

    private void preload() throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<CategoriaDespesa> categoriaDespesa = ServiceLocator.getCategoriaDespesaService().readByCriteria(criteria);
        Map<Long, String> categoriaDespesaOptions = new LinkedHashMap<Long, String>();
        for (CategoriaDespesa categoriaDespesas : categoriaDespesa) {
            categoriaDespesaOptions.put(categoriaDespesas.getId(), categoriaDespesas.getNome());
        }
        output.setValue("categoriaDespesa", categoriaDespesaOptions);
    }
}
