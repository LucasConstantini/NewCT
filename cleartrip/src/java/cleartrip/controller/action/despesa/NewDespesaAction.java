package cleartrip.controller.action.despesa;

import cleartrip.model.ServiceLocator;
import org.mentawai.core.BaseAction;
import org.mentawai.core.FileUpload;

public class NewDespesaAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        FileUpload arquivo = null;
        arquivo = (FileUpload) input.getValue("arquivo");
        byte [] aux = arquivo.toByteArray();
        ServiceLocator.getDespesaService().setImagem(aux);
        consequence = SUCCESS;
        return consequence;
    }
    
}
