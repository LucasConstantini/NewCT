package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class UsuarioUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
            form.put("id", input.getString("usuario.id"));
            form.put("nome", input.getString("usuario.nome"));
            form.put("empresa.id", input.getLong("usuario.empresa.id"));
            form.put("senha", input.getString("usuario.senha"));
            form.put("cpf", input.getLong("usuario.cpf"));
            form.put("rg", input.getString("usuario.rg"));
            form.put("emailCorporativo", input.getString("usuario.emailcorporativo"));
            form.put("emailPessoal", input.getString("usuario.emailpessoal"));
            form.put("telCorporativo", input.getString("usuario.telefonecorporativo"));
            form.put("telefonePessoal", input.getString("usuario.telefonepessoal"));

        Usuario usuario = (Usuario) session().getAttribute("usuarioLogado");
        if (usuario.getLogin() == input.getString("usuario.login")) {
            form.put("tipo", "Administrador");
            

        } else {
            form.put("tipo", input.getString("usuario.tipo"));
        }

        //Validando
        Map<String, String> error = ServiceLocator.getUsuarioService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            usuario = new Usuario();
            usuario.setNome((String) form.get("id"));
            usuario.setNome((String) form.get("nome"));
            usuario.setLogin((String) form.get("login"));
            usuario.setSenha((String) form.get("senha"));
            usuario.setCpf((Long) form.get("cpf"));
            usuario.setRg((String) form.get("rg"));
            usuario.setEmailCorporativo((String) form.get("emailcorporativo"));
            usuario.setEmailPessoal((String) form.get("emailpessoal"));
            usuario.setTelefonePessoal((String) form.get("telefonepessoal"));
            usuario.setTelefoneCorporativo((String) form.get("telefonecorporativo"));
            usuario.setTipo((String) form.get("tipo"));
            //Set empresa
            Empresa empresa = ServiceLocator.getEmpresaService().readById((Long) form.get("empresa.id"));
            usuario.setEmpresa(empresa);
             //Persistindo
            ServiceLocator.getUsuarioService().update(usuario);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}