package cleartrip.controller.action.viagem;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Transporte;
import cleartrip.model.pojo.Usuario;
import cleartrip.model.pojo.Viagem;
import java.sql.Date;
import java.sql.Time;
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

            form.put("meioTransporte.id", input.getString("meioTransporte.id"));
            form.put("Usuario.id", input.getString("Usuario.id"));
            form.put("status", input.getString("status"));
            form.put("destino", input.getLong("destino"));
            form.put("motivo", input.getString("motivo"));
            form.put("enderecoDestino", input.getLong("enderecoDestino"));
            form.put("telefoneDestino", input.getString("telefoneDestino"));
            form.put("outrosMateriais", input.getString("outrosMateriais"));
            form.put("cidadePartida", input.getString("cidadePartida"));
            form.put("enderecoPartida", input.getString("enderecoPartida"));
            form.put("telefonePartida", input.getString("telefonePartida"));
            form.put("dataPartida", input.getString("dataPartida"));
            form.put("horaPartida", input.getString("horaPartida"));
            form.put("aeroportoPartida", input.getString("aeroportoPartida"));
            form.put("ciaAereaIda", input.getString("ciaAereaIda"));
            form.put("numeroVooIda", input.getString("numeroVooIda"));
            form.put("dataCompromisso", input.getString("dataCompromisso"));
            form.put("horaCompromisso", input.getString("horaCompromisso"));
            form.put("dataVolta", input.getString("dataVolta"));
            form.put("horaVolta", input.getString("horaVolta"));
            form.put("aeroportoVolta", input.getString("aeroportoVolta"));
            form.put("ciaAereaVolta", input.getString("ciaAereaVolta"));
            form.put("numeroVooVolta", input.getString("numeroVooVolta"));
            form.put("valorAdiantamento", input.getString("valorAdiantamento"));
            form.put("valorReembolso", input.getString("valorReembolso"));
            form.put("valorRessarcimento", input.getString("valorRessarcimento"));
            form.put("numeroReciboAdiantamento", input.getString("numeroReciboAdiantamento"));
            form.put("numeroReciboResssarcimento", input.getString("numeroReciboResssarcimento"));
            form.put("relatoViagem", input.getString("relatoViagem"));
            form.put("dataAprovacao", input.getString("dataAprovacao"));
            form.put("dataEncerramento", input.getString("dataEncerramento"));
            
            error = ServiceLocator.getViagemService().validateForCreate(form);

        } catch (Exception e) {

        }


        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Viagem viagem = new Viagem();
            viagem.setStatus((String) form.get("status"));
            viagem.setDestino((String) form.get("destino"));
            viagem.setMotivo((String) form.get("motivo"));
            viagem.setEnderecoDestino((String) form.get("enderecodestino"));
            viagem.setTelefoneDestino((String) form.get("telefonedestino"));
            viagem.setOutrosMateriais((String) form.get("outrosmateriais"));
            viagem.setCidadePartida((String) form.get("cidadepartida"));
            viagem.setTelefonePartida((String) form.get("telefonepartida"));
            viagem.setDataPartida((Date) form.get("datapartida"));
            viagem.setHoraPartida((Time) form.get("horapartida"));
            viagem.setAeroportoIda((String) form.get("aeroportoida"));
            viagem.setCiaAereaIda((String) form.get("ciaaereaida"));
            viagem.setNumeroVooIda((String) form.get("numerovooida"));
            viagem.setDataCompromisso((Date) form.get("datacompromisso"));
            viagem.setHoraCompromisso((Time) form.get("horacompromisso"));
            viagem.setDataVolta((Date) form.get("datavolta"));
            viagem.setHoraVolta((Time) form.get("horavolta"));
            viagem.setAeroportoVolta((String) form.get("aeroportovolta"));
            viagem.setCiaAereaVolta((String) form.get("ciaaereavolta"));
            viagem.setNumeroVooVolta((String) form.get("numerovoovolta"));
            viagem.setValorAdiantameto((Double) form.get("valoradiantamento"));
            viagem.setValorReembolso((Double) form.get("valorreembolso"));
            viagem.setValorRessarcimento((Double) form.get("valorressarcimento"));
            viagem.setNumeroReciboAdiantamento((String) form.get("nreciboadiantamento"));
            viagem.setNumeroReciboRessarcimento((String) form.get("nreciboressarcimento"));
            viagem.setRelatoViagem((String) form.get("relatoviagem"));
            viagem.setDataAprovacao((Date) form.get("dataaprovacao"));
            viagem.setDataEncerramento((Date) form.get("dataencerramento"));

            //Set usuario
            Long idUsuario = (Long) form.get("usuario.id");
            Usuario usuario = ServiceLocator.getUsuarioService().readById(idUsuario);
            viagem.setUsuario(usuario);
            
            //Set meio de transporte
            Long idTransporte = (Long) form.get("transporte.id");
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
