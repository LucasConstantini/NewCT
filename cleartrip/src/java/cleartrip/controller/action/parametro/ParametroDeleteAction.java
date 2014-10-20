package cleartrip.controller.action.parametro;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Parametro;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ParametroDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Map<String, String> erro = new HashMap<String, String>();
        Long id = input.getLong("id");
        //verificando os parametros ainda valem
        Parametro parametro = new Parametro();
        parametro = ServiceLocator.getParametroService().readById(id);
        if (parametro.getDataTermino() == null) {
            erro.put("erroParametro", "Não é possivel excuir o Parâmetros válidos!");
            output.setValue("erro", erro);

        }else{
            try {
                ServiceLocator.getParametroService().delete(id);
                consequence = SUCCESS;
            } catch (Exception e) {
                erro.put("erro", "Este parâmetro não pode ser excluído!");
                output.setValue("erro", erro);

            }
        }
        return consequence;
    }
}