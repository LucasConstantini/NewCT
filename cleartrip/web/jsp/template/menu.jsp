<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        
        <a class="brand" href="Inicio.mtw">ClearTrip</a>

        <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                MENU <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><mtw:hasAuthorization permission="Usuario"><a href="UsuarioRead.mtw">Usuários</a></mtw:hasAuthorization></li>
                <li><mtw:hasAuthorization permission="Transporte"><a href="TransporteRead.mtw">Meios de Transporte</a></mtw:hasAuthorization></li>
                <li><mtw:hasAuthorization permission="Empresa"><a href="EmpresaRead.mtw">Empresas</a></mtw:hasAuthorization></li>
                <li class="divider"></li>
                <li><a href="UsuarioShowForm.mtw" paramId="login" paramProperty="login">Configurações</a></li>
                <li class="divider"></li>
                <li><a href="Logout.mtw">Sair</a></li>
            </ul>
        </div>
    </div>
</div>