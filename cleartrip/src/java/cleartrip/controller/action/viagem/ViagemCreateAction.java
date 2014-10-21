package cleartrip.controller.action.viagem;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Transporte;
import cleartrip.model.pojo.Usuario;
import cleartrip.model.pojo.Viagem;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ViagemCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Map<String, Object> form = new HashMap<String, Object>();
        //Validando
        Map<String, String> error = new HashMap<String, String>();

        try {

            form.put("meioTransporte.id", input.getLong("transporte.id"));
            Usuario usr = new Usuario();
            usr = (Usuario) session.getAttribute("usuarioLogado");
            form.put("usuario.id", usr.getId());
            form.put("status", "E");
            form.put("destino", input.getString("destino"));
            form.put("motivo", input.getString("motivo"));
            form.put("enderecoDestino", input.getString("enderecoDestino"));
            form.put("telefoneDestino", input.getString("telefoneDestino"));
            form.put("outrosMateriais", input.getString("outrosMateriais"));
            form.put("cidadePartida", input.getString("cidadePartida"));
            form.put("enderecoPartida", input.getString("enderecoPartida"));
            form.put("telefonePartida", input.getString("telefonePartida"));
            form.put("dataPartida", input.getString("dataPartida"));
            form.put("horaPartida", input.getString("horaPartida"));
            form.put("aeroportoIda", input.getString("aeroportoIda"));
            form.put("ciaAereaIda", input.getString("ciaAereaIda"));
            form.put("numeroVooIda", input.getString("numeroVooIda"));
            form.put("dataCompromisso", input.getString("dataCompromisso"));
            form.put("horaCompromisso", input.getString("horaCompromisso"));
            form.put("dataVolta", input.getString("dataVolta"));
            form.put("horaVolta", input.getString("horaVolta"));
            form.put("aeroportoVolta", input.getString("aeroportoVolta"));
            form.put("ciaAereaVolta", input.getString("ciaAereaVolta"));
            form.put("numeroVooVolta", input.getString("numeroVooVolta"));
            form.put("relatoViagem", input.getString("relatoViagem"));
   
            error = ServiceLocator.getViagemService().validateForCreate(form);

        } catch (Exception e) {

        }


        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Viagem viagem = new Viagem();
            viagem.setStatus((String) form.get("status"));
            viagem.setDestino((String) form.get("destino"));
            viagem.setMotivo((String) form.get("motivo"));
            viagem.setEnderecoDestino((String) form.get("enderecoDestino"));
            viagem.setTelefoneDestino((String) form.get("telefoneDestino"));
            viagem.setOutrosMateriais((String) form.get("outrosMateriais"));
            viagem.setCidadePartida((String) form.get("cidadePartida"));
            viagem.setEnderecoPartida((String) form.get("enderecoPartida"));
            viagem.setTelefonePartida((String) form.get("telefonePartida"));
            viagem.setDataPartida((String) form.get("dataPartida"));
            viagem.setHoraPartida((String) form.get("horaPartida"));
            viagem.setAeroportoIda((String) form.get("aeroportoIda"));
            viagem.setCiaAereaIda((String) form.get("ciaAereaIda"));
            viagem.setNumeroVooIda((String) form.get("numeroVooIda"));
            viagem.setDataCompromisso((String) form.get("dataCompromisso"));
            viagem.setHoraCompromisso((String) form.get("horaCompromisso"));
            viagem.setDataVolta((String) form.get("dataVolta"));
            viagem.setHoraVolta((String) form.get("horaVolta"));
            viagem.setAeroportoVolta((String) form.get("aeroportoVolta"));
            viagem.setCiaAereaVolta((String) form.get("ciaAereaVolta"));
            viagem.setNumeroVooVolta((String) form.get("numeroVooVolta"));
            viagem.setValorAdiantameto((Double) form.get("valorAdiantamento"));
            viagem.setValorReembolso((Double) form.get("valorReembolso"));
            viagem.setValorRessarcimento((Double) form.get("valorRessarcimento"));
            viagem.setNumeroReciboAdiantamento((String) form.get("nReciboAdiantamento"));
            viagem.setNumeroReciboRessarcimento((String) form.get("nReciboRessarcimento"));
            viagem.setRelatoViagem((String) form.get("relatoViagem"));
            viagem.setDataAprovacao((String) form.get("dataAprovacao"));
            viagem.setDataEncerramento((String) form.get("dataEncerramento"));

            //Set usuario
            Long idUsuario = (Long) form.get("usuario.id");
            Usuario usuario = ServiceLocator.getUsuarioService().readById(idUsuario);
            viagem.setUsuario(usuario);
            
            //Set meio de transporte
            Long idTransporte = (Long) form.get("meioTransporte.id");
            Transporte transporte = ServiceLocator.getTransporteService().readById(idTransporte);
            viagem.setTransporte(transporte);
            

            //Persistindo
            ServiceLocator.getViagemService().create(viagem);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
