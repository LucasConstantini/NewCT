<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>


    <mtw:form action="TransporteCreate.mtw" method="post">

        <legend>Novo Meio de Transporte</legend>
        <div>
            <label for="inputNome">Nome</label>
            <div>
                <mtw:input type="text" id="inputNome" name="nome"/>
                 <span class="label label-important">${error.nome}</span>
            </div>
        </div>
        <div>
            <div>
                <button type="submit" name="entrar" class="btn btn-success">Confirmar</button>
            </div>
        </div>
    </mtw:form>