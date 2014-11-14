package cleartrip.controller.action.categoriadespesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class CategoriaDespesaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("valorLimite", input.getDouble("valorLimite"));
        Map<String, String> error = ServiceLocator.getCategoriaDespesaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
            Usuario user = new Usuario();
            user = (Usuario) session.getAttribute("usuarioLogado");
            categoriaDespesa.setNome((String) form.get("nome"));
            categoriaDespesa.setValorLimite((Double) form.get("valorLimite"));
            //Set empresa
            Long idEmpresa = (Long) user.getEmpresa().getId();
            Empresa empresa = ServiceLocator.getEmpresaService().readById(idEmpresa);
            categoriaDespesa.setEmpresa(empresa);
            
            ServiceLocator.getCategoriaDespesaService().create(categoriaDespesa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
