package cleartrip.controller.action.empresa;

import cleartrip.model.ServiceLocator;
import org.mentawai.core.BaseAction;

public class EmpresaDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getEmpresaService().delete(id);
        return SUCCESS;
    }
}