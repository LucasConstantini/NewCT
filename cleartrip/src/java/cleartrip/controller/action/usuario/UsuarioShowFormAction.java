package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class UsuarioShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            Usuario usuario = ServiceLocator.getUsuarioService().readById(id);
            output.setValue("usuario", usuario);
            consequence = "UPDATE";
        }
        this.preload();
        return consequence;
    }
    
     private void preload() throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Empresa> empresas = ServiceLocator.getEmpresaService().readByCriteria(criteria);
        Map<Long, String> empresasOptions = new LinkedHashMap<Long, String>();
        for (Empresa empresa : empresas) {
            empresasOptions.put(empresa.getId(), empresa.getNomeFantasia());
        }
        output.setValue("empresas", empresasOptions);
    }
}
