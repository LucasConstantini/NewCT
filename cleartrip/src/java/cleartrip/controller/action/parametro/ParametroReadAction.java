package cleartrip.controller.action.parametro;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.ParametroDAO;
import cleartrip.model.pojo.Parametro;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ParametroReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        Usuario usuarioLogado = new Usuario();
        usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        if (usuarioLogado != null) {
            criteria.put(ParametroDAO.CRITERION_USUARIO, usuarioLogado.getId());
            List<Parametro> parametros = ServiceLocator.getParametroService().readByCriteria(criteria);
            output.setValue("lista", parametros);

        }
        else{
            consequence = ERROR;
        }

        return consequence;
    }
}
