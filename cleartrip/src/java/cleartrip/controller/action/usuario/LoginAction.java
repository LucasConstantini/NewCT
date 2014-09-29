package cleartrip.controller.action.usuario;


import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Usuario;
import org.mentawai.action.BaseLoginAction;

public class LoginAction extends BaseLoginAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;

        String login = input.getString("login");
        String senha = input.getString("senha");

        Usuario usuarioLogado = ServiceLocator.getUsuarioService().login(login, senha);
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