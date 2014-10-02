package cleartrip.controller.action.viagem;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Viagem;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;

public class ViagemDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Map<String, String> erro = new HashMap<String, String>();
        Long id = input.getLong("id");
        //verificando se é administrador
        Viagem viagem = new Viagem();
        viagem = ServiceLocator.getViagemService().readById(id);
        if (viagem.getStatus().equalsIgnoreCase("Aprovado")) {
            erro.put("erroViagem", "Esta viagem já foi APROVADA!");
            output.setValue("erro", erro);

        }else{
            try {
                ServiceLocator.getViagemService().delete(id);
                consequence = SUCCESS;
            } catch (Exception e) {
                erro.put("erro", "Esta viagem não pode ser excluída");
                output.setValue("erro", erro);

            }
        }
        return consequence;
    }
}