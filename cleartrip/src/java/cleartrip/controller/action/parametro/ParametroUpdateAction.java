package cleartrip.controller.action.parametro;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Parametro;
import java.sql.Date;
import java.sql.Time;
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
        form.put("manha", Time.valueOf(input.getString("parametro.manha")));
        form.put("tarde", Time.valueOf(input.getString("parametro.tarde")));
        form.put("noite", Time.valueOf(input.getString("parametro.noite")));
        form.put("dataInicio", input.getDate("parametro.dataInicio"));
        form.put("dataTermino", input.getDate("parametro.dataTermino"));
        form.put("custoKm", input.getLong("parametro.custoKm"));
        form.put("margemDeslocamento", input.getInt("parametro.margemDeslocamento"));
        form.put("empresa.id", input.getLong("parametro.empresa.id"));

        //Validando
        Map<String, String> error = ServiceLocator.getUsuarioService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            parametro = new Parametro();
            parametro.setId((Long) form.get("id"));
            parametro.setManha((Time) form.get("manha"));
            parametro.setTarde((Time) form.get("tarde"));
            parametro.setNoite((Time) form.get("noite"));
            parametro.setDataInicio((Date) form.get("dataInicio"));
            parametro.setDataTermino((Date) form.get("dataTermino"));
            parametro.setCustoKm((Long) form.get("custoKm"));
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