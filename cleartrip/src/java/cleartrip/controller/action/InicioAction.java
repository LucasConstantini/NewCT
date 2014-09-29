package cleartrip.controller.action;

import cleartrip.model.pojo.Usuario;
import org.mentawai.core.BaseAction;

public class InicioAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        output.setValue("Usuario", usuarioLogado);
        return SUCCESS;
    }
}