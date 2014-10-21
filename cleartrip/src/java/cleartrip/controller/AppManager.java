package cleartrip.controller;

import cleartrip.controller.action.InicioAction;
import cleartrip.controller.action.empresa.EmpresaCreateAction;
import cleartrip.controller.action.empresa.EmpresaDeleteAction;
import cleartrip.controller.action.empresa.EmpresaReadAction;
import cleartrip.controller.action.empresa.EmpresaShowFormAction;
import cleartrip.controller.action.empresa.EmpresaUpdateAction;
import cleartrip.controller.action.parametro.ParametroCreateAction;
import cleartrip.controller.action.parametro.ParametroDeleteAction;
import cleartrip.controller.action.parametro.ParametroReadAction;
import cleartrip.controller.action.parametro.ParametroShowFormAction;
import cleartrip.controller.action.parametro.ParametroUpdateAction;
import cleartrip.controller.action.transporte.TransporteCreateAction;
import cleartrip.controller.action.transporte.TransporteDeleteAction;
import cleartrip.controller.action.transporte.TransporteReadAction;
import cleartrip.controller.action.transporte.TransporteShowFormAction;
import cleartrip.controller.action.transporte.TransporteUpdateAction;
import cleartrip.controller.action.usuario.LoginAction;
import cleartrip.controller.action.usuario.UsuarioCreateAction;
import cleartrip.controller.action.usuario.UsuarioDeleteAction;
import cleartrip.controller.action.usuario.UsuarioReadAction;
import cleartrip.controller.action.usuario.UsuarioShowFormAction;
import cleartrip.controller.action.usuario.UsuarioUpdateAction;
import cleartrip.controller.action.viagem.ViagemCreateAction;
import cleartrip.controller.action.viagem.ViagemDeleteAction;
import cleartrip.controller.action.viagem.ViagemReadAction;
import cleartrip.controller.action.viagem.ViagemShowFormAction;
import cleartrip.controller.action.viagem.ViagemUpdateAction;
import org.mentawai.action.LogoutAction;
import org.mentawai.authorization.AuthorizationManager;
import org.mentawai.authorization.Group;
import org.mentawai.authorization.Permission;
import org.mentawai.core.ActionConfig;
import org.mentawai.core.ApplicationManager;
import org.mentawai.core.Context;
import org.mentawai.core.Forward;
import org.mentawai.core.Redirect;
import org.mentawai.filter.AuthenticationFilter;
import org.mentawai.filter.AuthorizationFilter;

public class AppManager extends ApplicationManager {

    @Override
    public void loadFilters() {
        this.addGlobalFilter(new AuthenticationFilter());
        this.addGlobalConsequence(LOGIN, new Redirect("/"));
        this.addGlobalConsequence(ACCESSDENIED, new Redirect("Logout.mtw"));
    }

    @Override
    public void init(Context application) {
        //Grupos de Usuários
        Group financeiro = new Group("Financeiro");
        financeiro.addPermission("Transporte");
        financeiro.addPermission("Empresa");
        financeiro.addPermission("Parametro");
        financeiro.addPermission("Inicio");
        financeiro.addPermission("Viagem");
        AuthorizationManager.addGroup(financeiro);
        //
        Group solicitante = new Group("Solicitante");
        solicitante.addPermission("Inicio");
        solicitante.addPermission("Viagem");
        AuthorizationManager.addGroup(solicitante);
        //
        Group administrador = new Group("Administrador");
        administrador.addPermission("Usuario");
        administrador.addPermission("Inicio");
        AuthorizationManager.addGroup(administrador);
    }

    @Override
    public void loadActions() {
        //Configurar App.
        ActionConfig ac = null;

        //Action de Teste
        ac = new ActionConfig("Inicio", InicioAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/teste.page"));
        this.add(ac);

        //Autenticação
        ac = new ActionConfig("Login", LoginAction.class);
        ac.addConsequence(ERROR, new Redirect("/"));
        ac.addConsequence("Financeiro", new Redirect("Inicio.mtw"));
        ac.addConsequence("Solicitante", new Redirect("Inicio.mtw"));
        ac.addConsequence("Administrador", new Redirect("Inicio.mtw"));
        this.add(ac);

        ac = new ActionConfig("Logout", LogoutAction.class);
        ac.addConsequence(SUCCESS, new Redirect("/"));
        this.add(ac);

        //Meio de Transporte
        ac = new ActionConfig("TransporteRead", TransporteReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/transporte/list.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Transporte")));
        this.add(ac);

        ac = new ActionConfig("TransporteShowForm", TransporteShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/transporte/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/transporte/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Transporte")));
        this.add(ac);

        ac = new ActionConfig("TransporteCreate", TransporteCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TransporteRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/transporte/createForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Transporte")));
        this.add(ac);

        ac = new ActionConfig("TransporteUpdate", TransporteUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TransporteRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/transporte/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Transporte")));
        this.add(ac);

        ac = new ActionConfig("TransporteDelete", TransporteDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TransporteRead.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Transporte")));
        this.add(ac);

        //Usuario
        ac = new ActionConfig("UsuarioRead", UsuarioReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/usuario/list.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Usuario")));
        this.add(ac);

        ac = new ActionConfig("UsuarioShowForm", UsuarioShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/usuario/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/usuario/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Usuario")));
        this.add(ac);

        ac = new ActionConfig("UsuarioCreate", UsuarioCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/usuario/createForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Usuario")));
        this.add(ac);

        ac = new ActionConfig("UsuarioUpdate", UsuarioUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/usuario/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Usuario")));
        this.add(ac);

        ac = new ActionConfig("UsuarioDelete", UsuarioDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("UsuarioRead.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Usuario")));
        this.add(ac);

        //Empresa
        ac = new ActionConfig("EmpresaRead", EmpresaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/empresa/list.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Empresa")));
        this.add(ac);

        ac = new ActionConfig("EmpresaShowForm", EmpresaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/empresa/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/empresa/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Empresa")));
        this.add(ac);

        ac = new ActionConfig("EmpresaCreate", EmpresaCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("EmpresaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/empresa/createForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Empresa")));
        this.add(ac);

        ac = new ActionConfig("EmpresaUpdate", EmpresaUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("EmpresaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/empresa/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Empresa")));
        this.add(ac);

        ac = new ActionConfig("EmpresaDelete", EmpresaDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("EmpresaRead.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Empresa")));
        this.add(ac);

        //Parametro
        ac = new ActionConfig("ParametroRead", ParametroReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/parametro/list.page"));
        ac.addConsequence(ERROR, new Redirect("Inicio.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Parametro")));
        this.add(ac);

        ac = new ActionConfig("ParametroShowForm", ParametroShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/parametro/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/parametro/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Parametro")));
        this.add(ac);

        ac = new ActionConfig("ParametroCreate", ParametroCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ParametroRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/parametro/createForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Parametro")));
        this.add(ac);

        ac = new ActionConfig("ParametroUpdate", ParametroUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ParametroRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/parametro/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Parametro")));
        this.add(ac);

        ac = new ActionConfig("ParametroDelete", ParametroDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ParametroRead.mtw"));
        ac.addConsequence(ERROR, new Forward("ParametroRead.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Parametro")));
        this.add(ac);

        //Viagem
        ac = new ActionConfig("ViagemRead", ViagemReadAction.class);
        ac.addConsequence("Financeiro", new Forward("jsp/viagem/readForm.page"));
        ac.addConsequence("Solicitante", new Forward("jsp/viagem/list.page"));
        ac.addConsequence(ERROR, new Forward("Inicio.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Viagem")));
        this.add(ac);

        ac = new ActionConfig("ViagemShowForm", ViagemShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/viagem/createForm.page"));
        ac.addConsequence("Financeiro", new Forward("jsp/viagem/manageForm.page"));
        ac.addConsequence("Solicitante", new Forward("jsp/viagem/updateForm.page"));
        ac.addConsequence(ERROR, new Forward("Inicio.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Viagem")));
        this.add(ac);

        ac = new ActionConfig("ViagemCreate", ViagemCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ViagemRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/viagem/createForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Viagem")));
        this.add(ac);

        ac = new ActionConfig("ViagemUpdate", ViagemUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ViagemRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/viagem/updateForm.page"));
        ac.addFilter(new AuthorizationFilter(new Permission("Viagem")));
        this.add(ac);

        ac = new ActionConfig("ViagemDelete", ViagemDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ViagemRead.mtw"));
        ac.addFilter(new AuthorizationFilter(new Permission("Viagem")));
        this.add(ac);

    }
}
