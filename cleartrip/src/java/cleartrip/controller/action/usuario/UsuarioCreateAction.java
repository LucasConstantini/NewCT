package cleartrip.controller.action.usuario;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class UsuarioCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Map<String, Object> form = new HashMap<String, Object>();
        //Validando
        Map<String, String> error = new HashMap<String, String>();

        try {

            form.put("nome", input.getString("nome"));
            form.put("login", input.getString("emailCorporativo"));
            form.put("senha", input.getString("cpf"));
            form.put("cpf", input.getLong("cpf"));
            form.put("rg", input.getString("rg"));
            form.put("empresa.id", input.getLong("empresa.id"));
            form.put("emailCorporativo", input.getString("emailCorporativo"));
            form.put("emailPessoal", input.getString("emailPessoal"));
            form.put("telefoneCorporativo", input.getString("telefoneCorporativo"));
            form.put("telefonePessoal", input.getString("telefonePessoal"));
            form.put("tipo", input.getString("tipo"));
            
            error = ServiceLocator.getUsuarioService().validateForCreate(form);

        } catch (Exception e) {

        }


        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Usuario usuario = new Usuario();
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
            Long idEmpresa = (Long) form.get("empresa.id");
            Empresa empresa = ServiceLocator.getEmpresaService().readById(idEmpresa);
            usuario.setEmpresa(empresa);
            //Persistindo
            ServiceLocator.getUsuarioService().create(usuario);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
