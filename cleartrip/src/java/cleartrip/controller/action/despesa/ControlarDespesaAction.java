package cleartrip.controller.action.despesa;

import cleartrip.model.ServiceLocator;
import cleartrip.model.dao.CategoriaDespesaDAO;
import cleartrip.model.dao.DespesaDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Despesa;
import cleartrip.model.pojo.Transporte;
import cleartrip.model.pojo.Usuario;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mentawai.core.BaseAction;
import org.mentawai.core.MapOutput;

public class ControlarDespesaAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put(CategoriaDespesaDAO.CRITERION_EMPRESA, usuario.getEmpresa().getId());
        List<CategoriaDespesa> categoriasDespesa = ServiceLocator.getCategoriaDespesaService().readByCriteria(criteria);
        criteria.clear();
                
        output.setValue("lista", categoriasDespesa);
        
        Map<String,Double> mapa = ServiceLocator.getUsuarioService().listGastos(usuario.getId());
        output.setValue("gastos", mapa);
        
        
        return SUCCESS;
    }
}
