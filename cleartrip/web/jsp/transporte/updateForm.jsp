<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="TransporteUpdate.mtw" method="post">
    <mtw:input type="hidden" name="transporte.id"/>
    <legend>Alterar Meio de Transporte</legend>
    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="transporte.nome"/>
             <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <br />
    <div>
        <div>
            <button type="submit" name="entrar" class="btn btn-success">Confirmar</button>
        </div>
    </div>
</mtw:form>