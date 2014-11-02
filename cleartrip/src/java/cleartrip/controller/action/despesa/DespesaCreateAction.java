package cleartrip.controller.action.despesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Despesa;
import cleartrip.model.pojo.Viagem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import org.mentawai.core.FileUpload;

public class DespesaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        FileUpload arquivo = (FileUpload) input.getValue("comprovante");
        byte[] aux = null;
        if(arquivo!=null){
            aux = arquivo.toByteArray();
        }
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("viagem.id", input.getLong("viagem.id"));
        form.put("valor", input.getDouble("valor"));
        form.put("categoriaDespesa.id", input.getLong("categoriaDespesa.id"));
        form.put("estabelecimento", input.getString("estabelecimento"));
        form.put("cnpjEstabelecimento", input.getLong("cnpjEstabelecimento"));
        form.put("observacoes", input.getString("observacoes"));
        form.put("valorAutorizado", 0.0);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dataInicio = dateFormat.format(date);
        form.put("dataCompra", dataInicio);
        
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        date = new Date();
        String horaCompra = dateFormat.format(date);
        form.put("horaCompra", horaCompra);
        
        form.put("foto", aux);
        Map<String, String> error = ServiceLocator.getDespesaService().validateForCreate(form);
        
        if(error.isEmpty() || error != null){
            Despesa d = new Despesa();
            d.setValor((Double) form.get("valor"));
            d.setNomeEstabelecimento((String) form.get("estabelecimento"));
            d.setDataCompra((String) form.get("dataCompra"));
            d.setHoraCompra((String) form.get("horaCompra"));
            d.setCnpj((Long) form.get("cnpjEstabelecimento"));
            d.setDescritivo((String) form.get("observacoes"));
            d.setValorRealAutorizado((Double) form.get("valorAutorizado"));
            d.setFoto((byte[]) form.get("foto"));
            
            Long idViagem = (Long) form.get("viagem.id");
            Viagem viagem = ServiceLocator.getViagemService().readById(idViagem);
            d.setViagem(viagem);
            
            Long idCategoriaDespesa = (Long) form.get("categoriaDespesa.id");
            CategoriaDespesa categoriaDespesa = ServiceLocator.getCategoriaDespesaService().readById(idCategoriaDespesa);
            d.setCategoriaDespesa(categoriaDespesa);
            
            ServiceLocator.getDespesaService().create(d);
            
            consequence = SUCCESS;
            
            
        }
        else{
            output.setValue("error", error);
        }
        
        return consequence;
    }

}
