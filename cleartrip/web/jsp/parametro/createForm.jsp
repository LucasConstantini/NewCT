<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form action="ParametroCreate.mtw" method="post">
    <legend>
        <p>Novos Parâmetros</p>
    </legend>
    <div>
        <br/>
        <div>
            <label for="inputManha">Manha</label>
            <div>
                <mtw:input type="text" klass="campoHora" id="inputNome" name="manha"/>
            </div>
        </div>
        <br/>
        <div>
            <label for="inputTarde">Tarde</label>
            <div>
                <mtw:input type="text" id="inputTarde" name="tarde"/>
                <span class="label label-important">${error.tarde}</span>
            </div>
        </div>

        <div>
            <label for="inputNoite">Noite</label>
            <div>
                <mtw:input type="text" id="inputNoite" name="noite"/>
                <span class="label label-important">${error.noite}</span>
            </div>
        </div>
        <div>
            <label for="inputCustoKm">Custo Km</label>
            <div>
                <mtw:input type="text" id="inputCustoKm" name="custoKm"/>
                <span class="label label-important">${error.custoKm}</span>
            </div>
        </div>

        <div>
            <label for="inputMargemDeslocamento">Margem Limite de Deslocamento</label>
            <div>
                <mtw:input type="text" id="inputMargemDeslocamento" name="margemDeslocamento"/>
                <span class="label label-important">${error.custoKm}</span>
            </div>
        </div>

        <div>
            <label for="inputDataTermino">Data de Termino</label>
            <div>
                <mtw:input type="text" klass="calendario" id="inputDataTermino" name="dataTermino"/>
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
