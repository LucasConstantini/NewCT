<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">

        <a class="brand" href="Inicio.mtw">ClearTrip</a>

        <div class="btn-group pull-right">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-bars fa-lg"></i>
            </button>
            <ul class="dropdown-menu pull-right" role="menu">
                <li><mtw:hasAuthorization permission="Usuario"><a href="UsuarioRead.mtw"><i class="fa fa-users"></i> Usuários</a></mtw:hasAuthorization></li>
                <li><mtw:hasAuthorization permission="Transporte"><a href="TransporteRead.mtw"><i class="fa fa-car"></i> Meios de Transporte</a></mtw:hasAuthorization></li>
                <li><mtw:hasAuthorization permission="Viagem"><a href="ViagemRead.mtw"><i class="fa fa-globe"></i> Viagens</a></mtw:hasAuthorization></li>
                <li><mtw:hasAuthorization permission="Empresa"><a href="EmpresaRead.mtw"><i class="fa fa-institution"></i> Empresas</a></mtw:hasAuthorization></li>
                <li><mtw:hasAuthorization permission="Parametro"><a href="ParametroRead.mtw"><i class="fa fa-sliders"></i> Parametros</a></mtw:hasAuthorization></li>
                <li><mtw:hasAuthorization permission="CategoriaDespesa"><a href="CategoriaDespesaRead.mtw"><i class="fa fa-money"></i> Categoria Despesa</a></mtw:hasAuthorization></li>
                <li class="divider"></li>
                <li><a href="AlterarSenhaShowForm.mtw"><i class="fa fa-gears"></i> Alterar Senha</a></li>
                <li class="divider"></li>
                <li><a href="Logout.mtw"><i class="fa fa-power-off"></i> Sair</a></li>
            </ul>
        </div>
    </div>
</div>
<br /><br /><br />