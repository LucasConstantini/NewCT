<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form action="UsuarioCreate.mtw" method="post">
    <legend>Novo Usuario</legend>
    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="nome"/>
        </div>
    </div>
    <div class="control-group">
            <label class="control-label" for="inputNome">Empresa</label>
            <div class="controls">
                <mtw:select name="empresa.id" list="empresas" emptyField="true" emptyFieldValue="Selecione..."/>
                <span class="label label-important">${error.empresa}</span>
            </div>
        </div>
        <br/>
        <div>
        <label for="inputCpf">CPF:</label>
        <div>
            <mtw:input type="text" id="inputCpf" name="cpf"/>
        </div>
    </div>
    <div>
        <label for="inputRg">RG:</label>
        <div>
            <mtw:input type="text" id="inputRg" name="rg"/>
        </div>
    </div>
    <div>
        <label for="inputEmailPessoal">Email Pessoal:</label>
        <div>
            <mtw:input type="text" id="inputEmailPessoal" name="emailPessoal"/>
        </div>
    </div>

    <div>
        <label for="inputEmailCorporativo">Email Corporativo:</label>
        <div>
            <mtw:input type="text" id="inputEmailCorporativo" name="emailCorporativo"/>
        </div>
    </div>

    <div>
        <label for="inputTelefonePessoal">Telefone Pessoal:</label>
        <div>
            <mtw:input type="text" id="inputTelefonePessoal" name="telefonePessoal"/>
        </div>
    </div>
    <div>
        <label for="inputTelefoneCorporativo">Telefone Corporativo:</label>
        <div>
            <mtw:input type="text" id="inputTelefoneCorporativo" name="telefoneCorporativo"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTipo">Tipo *</label>
        <div class="controls">
            <select name="tipo">
                <option>Financeiro</option>
                <option>Solicitante</option>
            </select>
            <span class="label label-important">${error.tipo}</span>
        </div>
        <br/>  


        <div>

            <div class="controls">
                <button type="submit" class="btt botao" style="margin-left: 0%" ><i class="icon-ok icon-white"></i> Confirmar</button>
            </div>
        </div>
    </div>
</mtw:form>


<script>
    $(function() {
        $('#Usuarios').addClass('active');

        $("#janelaEmpresa").click(function() {
            $("#opcoesEmpresas").slideToggle();
        });
    });
</script>