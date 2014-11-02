package cleartrip.controller.action;

import cleartrip.model.pojo.Usuario;
import org.mentawai.core.BaseAction;

public class InicioAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado != null) {
            setSessionObj(usuarioLogado);
            String grupo = usuarioLogado.getClass().getSimpleName();
            setSessionGroup(grupo);
            session.setAttribute("usuarioLogado", usuarioLogado);
            session.setAttribute("grupo", grupo);
            consequence = grupo;
        }
        return consequence;

    }
}
