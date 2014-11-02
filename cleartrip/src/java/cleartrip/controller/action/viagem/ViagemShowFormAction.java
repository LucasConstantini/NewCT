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
        String consequence = ERROR;
        Long id = input.getLong("id");
        if (id > 0) {
            Usuario user = new Usuario();
            user = (Usuario) session.getAttribute("usuarioLogado");
            if (user.getTipo().equals("Financeiro")) {
                Viagem viagem = ServiceLocator.getViagemService().readById(id);
                output.setValue("viagem", viagem);
                consequence = "Financeiro";
            } else {
                Viagem viagem = ServiceLocator.getViagemService().readById(id);
                output.setValue("viagem", viagem);
                consequence = "Solicitante";

            }
        } else {
            consequence = "CREATE";
        }            
        this.preload();
        return consequence;
    }

    private void preload() throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Transporte> transportes = ServiceLocator.getTransporteService().readByCriteria(criteria);
        Map<Long, String> transporteOptions = new LinkedHashMap<Long, String>();
        for (Transporte transporte : transportes) {
            transporteOptions.put(transporte.getId(), transporte.getNome());
        }

        output.setValue("transportes", transporteOptions);
    }
}
