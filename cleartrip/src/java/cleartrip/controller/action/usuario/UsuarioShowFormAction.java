package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Usuario;
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
        return consequence;
    }
}
