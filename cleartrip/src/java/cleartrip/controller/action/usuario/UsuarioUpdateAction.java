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
        Usuario usuario = new Usuario();
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("usuario.id"));
        form.put("nome", input.getString("usuario.nome"));
        form.put("empresa.id", input.getLong("usuario.empresa.id"));
        form.put("senha", input.getString("usuario.senha"));
        form.put("cpf", input.getLong("usuario.cpf"));
        form.put("rg", input.getString("usuario.rg"));
        form.put("emailCorporativo", input.getString("usuario.emailCorporativo"));
        form.put("emailPessoal", input.getString("usuario.emailPessoal"));
        form.put("telCorporativo", input.getString("usuario.telefoneCorporativo"));
        form.put("telefonePessoal", input.getString("usuario.telefonePessoal"));

        form.put("tipo", input.getString("usuario.tipo"));
        form.put("login", input.getString("usuario.login"));

        //Validando
        Map<String, String> error = ServiceLocator.getUsuarioService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            usuario = new Usuario();
            usuario.setId((Long) form.get("id"));
            usuario.setNome((String) form.get("nome"));
            usuario.setLogin((String) form.get("login"));
            usuario.setSenha((String) form.get("senha"));
            usuario.setCpf((Long) form.get("cpf"));
            usuario.setRg((String) form.get("rg"));
            usuario.setEmailCorporativo((String) form.get("emailCorporativo"));
            usuario.setEmailPessoal((String) form.get("emailPessoal"));
            usuario.setTelefonePessoal((String) form.get("telefonePessoal"));
            usuario.setTelefoneCorporativo((String) form.get("telefoneCorporativo"));
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
