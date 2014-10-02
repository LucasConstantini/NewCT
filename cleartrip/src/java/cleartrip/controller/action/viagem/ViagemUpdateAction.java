package cleartrip.controller.action.viagem;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Transporte;
import cleartrip.model.pojo.Usuario;
import cleartrip.model.pojo.Viagem;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ViagemUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
            form.put("meioTransporte.id", input.getLong("viagem.meioTransporte.id"));
            form.put("usuario.id", input.getLong("viagem.Usuario.id"));
            form.put("status", input.getString("viagem.status"));
            form.put("destino", input.getLong("viagem.destino"));
            form.put("motivo", input.getString("viagem.motivo"));
            form.put("enderecoDestino", input.getLong("viagem.enderecoDestino"));
            form.put("telefoneDestino", input.getString("viagem.telefoneDestino"));
            form.put("outrosMateriais", input.getString("viagem.outrosMateriais"));
            form.put("cidadePartida", input.getString("viagem.cidadePartida"));
            form.put("enderecoPartida", input.getString("viagem.enderecoPartida"));
            form.put("telefonePartida", input.getString("viagem.telefonePartida"));
            form.put("dataPartida", input.getDate("viagem.dataPartida"));
            
            form.put("horaPartida", input.getString("viagem.horaPartida"));
            form.put("aeroportoPartida", input.getString("viagem.aeroportoPartida"));
            form.put("ciaAereaIda", input.getString("viagem.ciaAereaIda"));
            form.put("numeroVooIda", input.getString("viagem.numeroVooIda"));
            form.put("dataCompromisso", input.getDate("viagem.dataCompromisso"));
            
            form.put("horaCompromisso", input.getString("viagem.horaCompromisso"));
            form.put("dataVolta", input.getDate("viagem.dataVolta"));
            
            form.put("horaVolta", input.getString("viagem.horaVolta"));
            form.put("aeroportoVolta", input.getString("viagem.aeroportoVolta"));
            form.put("ciaAereaVolta", input.getString("viagem.ciaAereaVolta"));
            form.put("numeroVooVolta", input.getString("viagem.numeroVooVolta"));
            form.put("valorAdiantamento", input.getString("viagem.valorAdiantamento"));
            form.put("valorReembolso", input.getString("viagem.valorReembolso"));
            form.put("valorRessarcimento", input.getString("viagem.valorRessarcimento"));
            form.put("numeroReciboAdiantamento", input.getString("viagem.numeroReciboAdiantamento"));
            form.put("numeroReciboResssarcimento", input.getString("viagem.numeroReciboResssarcimento"));
            form.put("relatoViagem", input.getString("viagem.relatoViagem"));
            form.put("dataAprovacao", input.getDate("viagem.dataAprovacao"));
            form.put("dataEncerramento", input.getDate("viagem.dataEncerramento"));

        //Validando
        Map<String, String> error = ServiceLocator.getViagemService().validateForUpdate(form);
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
            viagem.setTelefonePartida((String) form.get("telefonePartida"));
            viagem.setDataPartida((Date) form.get("dataPartida"));
            viagem.setHoraPartida((Time) form.get("horaPartida"));
            viagem.setAeroportoIda((String) form.get("aeroportoIda"));
            viagem.setCiaAereaIda((String) form.get("ciaaereaIda"));
            viagem.setNumeroVooIda((String) form.get("numerovooIda"));
            viagem.setDataCompromisso((Date) form.get("dataCompromisso"));
            viagem.setHoraCompromisso((Time) form.get("horaCompromisso"));
            viagem.setDataVolta((Date) form.get("dataVolta"));
            viagem.setHoraVolta((Time) form.get("horaVolta"));
            viagem.setAeroportoVolta((String) form.get("aeroportoVolta"));
            viagem.setCiaAereaVolta((String) form.get("ciaaereaVolta"));
            viagem.setNumeroVooVolta((String) form.get("numeroVooVolta"));
            viagem.setValorAdiantameto((Double) form.get("valorAdiantamento"));
            viagem.setValorReembolso((Double) form.get("valorReembolso"));
            viagem.setValorRessarcimento((Double) form.get("valorRessarcimento"));
            viagem.setNumeroReciboAdiantamento((String) form.get("numeroReciboAdiantamento"));
            viagem.setNumeroReciboRessarcimento((String) form.get("numeroReciboRessarcimento"));
            viagem.setRelatoViagem((String) form.get("relatoViagem"));
            viagem.setDataAprovacao((Date) form.get("dataAprovacao"));
            viagem.setDataEncerramento((Date) form.get("dataEncerramento"));
            
            //Set usuario
            Long idUsuario = (Long) form.get("usuario.id");
            Usuario usuario = ServiceLocator.getUsuarioService().readById(idUsuario);
            viagem.setUsuario(usuario);
            
            //Set meio de transporte
            Long idTransporte = (Long) form.get("transporte.id");
            Transporte transporte = ServiceLocator.getTransporteService().readById(idTransporte);
            viagem.setTransporte(transporte);
            
             //Persistindo
            ServiceLocator.getViagemService().update(viagem);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}