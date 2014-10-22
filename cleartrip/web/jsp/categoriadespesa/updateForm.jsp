<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="CategoriaDespesaUpdate.mtw" method="post">
    <mtw:input type="hidden" name="categoriaDespesa.id"/>
    <legend>Alterar Categoria de Despesa</legend>
    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="categoriaDespesa.nome"/>
             <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputValorLimite">Valor Limite</label>
        <div>
            <mtw:input type="text" id="inputValorLimite" name="categoriaDespesa.valorLimite"/>
             <span class="label label-important">${error.valorLimite}</span>
        </div>
    </div>
    <br />
    <div>
        <div>
            <button type="submit" name="entrar" class="btn btn-success">Confirmar</button>
        </div>
    </div>
</mtw:form>