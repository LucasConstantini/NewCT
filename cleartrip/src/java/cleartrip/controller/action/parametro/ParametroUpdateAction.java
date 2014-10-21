package cleartrip.controller.action.parametro;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Parametro;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ParametroUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Parametro parametro = new Parametro();
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("parametro.id"));
        form.put("manha", input.getString("parametro.manha"));
        form.put("tarde", input.getString("parametro.tarde"));
        form.put("noite", input.getString("parametro.noite"));
        form.put("custoKm", input.getDouble("parametro.custoKm"));
        form.put("margemDeslocamento", input.getInt("parametro.margemDeslocamento"));
        form.put("dataTermino", input.getString("parametro.dataTermino"));
        form.put("dataInicio", input.getString("parametro.dataInicio"));
        form.put("empresa.id", input.getLong("parametro.empresa.id"));

        //Validando
        Map<String, String> error = ServiceLocator.getParametroService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            parametro = new Parametro();
            parametro.setId((Long) form.get("id"));
            parametro.setManha((String) form.get("manha"));
            parametro.setTarde((String) form.get("tarde"));
            parametro.setNoite((String) form.get("noite"));
            parametro.setDataInicio((String) form.get("dataInicio"));
            parametro.setDataTermino((String) form.get("dataTermino"));
            parametro.setCustoKm((Double) form.get("custoKm"));
            parametro.setMargemDeslocamento((Integer) form.get("margemDeslocamento"));
            //Set empresa
            Long idEmpresa = (Long) form.get("empresa.id");
            Empresa empresa = ServiceLocator.getEmpresaService().readById(idEmpresa);
            parametro.setEmpresa(empresa);

            //Persistindo
            ServiceLocator.getParametroService().update(parametro);

            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
