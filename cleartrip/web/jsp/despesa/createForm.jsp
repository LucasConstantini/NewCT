<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form klass="form-horizontal" action="DespesaCreate.mtw" method="post" enctype="multipart/form-data">
    <mtw:input type="hidden" name="viagem.id"/>
    <legend>Informar Despesa</legend>

    <div>
        <label for="comprovante">Comprovante</label>
        <div>
            <input id="comprovante" name="comprovante" type="file"/>
        </div>
    </div>
    <br />
    <div>
        <label for="valor">Valor</label>
        <div>
            <mtw:input id="valor" name="valor" type="text" />
        </div>
    </div>
    <br />
    <div>
        <label for="inputCategoriaDespesa">Categoria Despesa</label>
        <div class="controls">
            <mtw:select id="inputCategoriaDespesa" name="categoriaDespesa.id" list="categoriaDespesa" emptyField="true" emptyFieldValue="Selecione..."/>
        </div>
    </div>
    <br/>

    <div>
        <label for="inputEstabelecimento">Estabelecimento</label>
        <div>
            <mtw:input name="estabelecimento" id="inputEstabelecimento" type="text" />

        </div>
    </div>
    <br />
    <div>
        <label for="inputCnpjEstabelecimento">CNPJ Estabelecimento</label>
        <div>
            <mtw:input name="cnpjEstabelecimento" id="inputCnpjEstabelecimento" type="text"/>

        </div>
    </div>
    <br />


    <!-- Textarea -->
    <div>
        <label for="observacoes">Observações</label>
        <div>                     
            <mtw:textarea id="observacoes" name="observacoes"/>
        </div>
    </div>

    <br />
    <div>
        <mtw:submit name="entrar" klass="btn btn-success" value="Confirmar" />
    </div>


</mtw:form>
