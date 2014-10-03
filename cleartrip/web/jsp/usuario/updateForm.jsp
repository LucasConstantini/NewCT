<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form action="UsuarioUpdate.mtw" method="post">
    <mtw:input type="hidden" name="usuario.empresa.id"/>
    <mtw:input type="hidden" name="usuario.id"/>
    <mtw:input type="hidden" name="usuario.login"/>
    <mtw:input type="hidden" name="usuario.cpf"/>
    <mtw:input type="hidden" name="usuario.rg"/>
    <mtw:input type="hidden" name="usuario.senha"/>
    <mtw:input type="hidden" name="usuario.tipo"/>

    <legend>Alterar Usuário</legend>
    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="usuario.nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputEmailPessoal">Email Pessoal</label>
        <div>
            <mtw:input type="text" id="inputEmailPessoal" name="usuario.emailPessoal"/>
            <span class="label label-important">${error.emailPessoal}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputEmailCorporativo">Email Corporativo</label>
        <div>
            <mtw:input type="text" id="inputEmailCorporativo" name="usuario.emailCorporativo"/>
            <span class="label label-important">${error.emailCorporativo}</span>
        </div>
    </div>

    <div>
        <label for="inputTelefonePessoal">Telefone Pessoal</label>
        <div>
            <mtw:input type="text" id="inputTelefonePessoal" name="usuario.telefonePessoal"/>
            <span class="label label-important">${error.telefonePessoal}</span>
        </div>
    </div>
    <div>
        <label for="inputTelefoneCorporativo">Telefone Corporativo</label>
        <div>
            <mtw:input type="text" id="inputTelefoneCorporativo" name="usuario.telefoneCorporativo"/>
            <span class="label label-important">${error.telefoneCorporativo}</span>
        </div>
    </div>
    <br/>  
    <!-- Button -->
    <div class="control-group">
        <label class="control-label" for="entrar"></label>
        <div class="controls">
            <mtw:submit name="entrar" klass="btn btn-success" value="Confirmar" />
        </div>
    </div>


</mtw:form>