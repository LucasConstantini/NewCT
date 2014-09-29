package cleartrip.controller.action.empresa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class EmpresaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("nomeFantasia", input.getString("nomeFantasia"));
        form.put("endereco", input.getString("endereco"));
        form.put("telefone", input.getString("telefone"));
        form.put("nomeRepresentante", input.getString("nomeRepresentante"));
        form.put("cpfRepresentante", input.getLong("cpfRepresentante"));
        form.put("cnpj", input.getLong("cnpj"));
        
        //Validando      
        Map<String, String> error = ServiceLocator.getEmpresaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Empresa empresa = new Empresa();
            empresa.setNome((String) form.get("nome"));
            empresa.setNomeFantasia((String) form.get("nomeFantasia"));
            empresa.setEndereco((String) form.get("endereco"));
            empresa.setTelefone((String) form.get("telefone"));
            empresa.setNomeRepresentante((String) form.get("nomeRepresentante"));
            empresa.setCpfRepresentante((Long) form.get("cpfRepresentante"));
            empresa.setCnpj((Long) form.get("cnpj"));
            
            //Persistindo
            ServiceLocator.getEmpresaService().create(empresa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}