<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form action="ParametroUpdate.mtw" method="post">
    <mtw:input type="hidden" name="parametro.id"/>

    <div>
        <legend>
            <p>Alterar Parâmetros</p>
        </legend>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputEmpresa">Empresa</label>
        <div class="controls">
            <mtw:select id="inputEmpresa" name="parametro.empresa.id" list="empresas" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.empresa}</span>
        </div>
    </div>
    <br/>
    <div>
        <label for="inputManha">Manha</label>
        <div>
            <mtw:input type="text" klass="campoHora" id="inputNome" name="parametro.manha"/>
        </div>
    </div>
    <br/>
    <div>
        <label for="inputTarde">Tarde</label>
        <div>
            <mtw:input type="text" id="inputTarde" name="parametro.tarde"/>
            <span class="label label-important">${error.tarde}</span>
        </div>
    </div>

    <div>
        <label for="inputNoite">Noite</label>
        <div>
            <mtw:input type="text" id="inputNoite" name="parametro.noite"/>
            <span class="label label-important">${error.noite}</span>
        </div>
    </div>
    <div>
        <label for="inputCustoKm">Custo Km</label>
        <div>
            <mtw:input type="text" id="inputCustoKm" name="parametro.custoKm"/>
            <span class="label label-important">${error.custoKm}</span>
        </div>
    </div>

    <div>
        <label for="inputMargemDeslocamento">Mardem Limite de Deslocamento</label>
        <div>
            <mtw:input type="text" id="inputMargemDeslocamento" name="parametro.margemDeslocamento"/>
            <span class="label label-important">${error.custoKm}</span>
        </div>
    </div>

    <div>
        <label for="inputDataTermino">Data de Termino</label>
        <div>
            <mtw:input type="text" klass="calendario" id="inputDataTermino" name="parametro.dataTermino"/>
        </div>
    </div>

    <!-- Button -->
    <div class="control-group">
        <label class="control-label" for="entrar"></label>
        <div class="controls">
            <mtw:submit name="entrar" klass="btn btn-success" value="Confirmar" />
        </div>
    </div>

</div>


</mtw:form>