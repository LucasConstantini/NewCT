package cleartrip.controller.action.parametro;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Parametro;
import cleartrip.model.pojo.Usuario;
import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ParametroCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Map<String, Object> form = new HashMap<String, Object>();
        //Validando
        Map<String, String> error = new HashMap<String, String>();

        try {

            form.put("manha", input.getString("manha"));
            form.put("tarde", input.getString("tarde"));
            form.put("noite", input.getString("noite"));
            form.put("custoKm", input.getDouble("custoKm"));
            form.put("margemDeslocamento", input.getInt("margemDeslocamento"));
            form.put("dataTermino", input.getString("dataTermino"));

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String dataInicio = dateFormat.format(date);
            form.put("dataInicio", dataInicio);            
            
            Usuario usuario = new Usuario();
            usuario = (Usuario) session.getAttribute("usuarioLogado");
            if (usuario != null) {
                form.put("empresa.id", usuario.getEmpresa().getId());
            }
            error = ServiceLocator.getParametroService().validateForCreate(form);

        } catch (Exception e) {
        }

        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Parametro parametro = new Parametro();
            parametro.setManha((String)form.get("manha"));
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
            ServiceLocator.getParametroService().create(parametro);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
