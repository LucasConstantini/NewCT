package cleartrip.controller.action.viagem;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Transporte;
import cleartrip.model.pojo.Usuario;
import cleartrip.model.pojo.Viagem;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ViagemShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            Viagem viagem = ServiceLocator.getViagemService().readById(id);
            output.setValue("viagem", viagem);
            consequence = "UPDATE";
            this.preload();
        } else {
            this.preload();
        }
        return consequence;
    }

    private void preload() throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Usuario> usuarios = ServiceLocator.getUsuarioService().readByCriteria(criteria);
        List<Transporte> transportes = ServiceLocator.getTransporteService().readByCriteria(criteria);
        
        Map<Long, String> usuarioOptions = new LinkedHashMap<Long, String>();
        for (Usuario usuario : usuarios) {
            usuarioOptions.put(usuario.getId(), usuario.getNome());
        }

        output.setValue("usuarios", usuarioOptions);
        
        Map<Long, String> transporteOptions = new LinkedHashMap<Long, String>();
        for (Transporte transporte : transportes) {
            transporteOptions.put(transporte.getId(), transporte.getNome());
        }

        output.setValue("transportes", transporteOptions);
    }
}
