package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class AlterarSenhaAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Map<String, String> error = new HashMap<String, String>();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (error.isEmpty()) {
            String senhaAtual = input.getString("senhaAtual");
            String novaSenha = input.getString("senhaNova");
            String confirmacao = input.getString("senhaConfirmacao");

            if (senhaAtual != null && !senhaAtual.isEmpty()) {
                boolean ok = false;
                if (senhaAtual.equals(usuarioLogado.getSenha())) {
                    if (novaSenha != null && !novaSenha.isEmpty() && confirmacao != null && !confirmacao.isEmpty() && novaSenha.equals(confirmacao)) {
                        usuarioLogado.setSenha(novaSenha);
                        ServiceLocator.getUsuarioService().update(usuarioLogado);
                        consequence = SUCCESS;
                        ok = true;
                    }
                }
                if (!ok) {
                    error.put("senhaAtual", "As senhas não conferem!");
                    output.setValue("error", error);
                }
            } else {
                ServiceLocator.getUsuarioService().update(usuarioLogado);
                consequence = SUCCESS;
            }
        } else {
            output.setValue("error", error);
        }

        return consequence;
    }
}
