<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>


<mtw:form action="EmpresaCreate.mtw" method="post">

    <legend>Nova Empresa</legend>
    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="nome"/>
             <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputNomeFantasia">Nome Fantasia</label>
        <div>
            <mtw:input type="text" id="inputNomeFantasia" name="nomeFantasia"/>
             <span class="label label-important">${error.nomeFantasia}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputEndereco">Endereço</label>
        <div>
            <mtw:input type="text" id="inputEndereco" name="endereco"/>
             <span class="label label-important">${error.endereco}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputTelefone">Telefone</label>
        <div>
            <mtw:input type="text" id="inputTelefone" name="telefone"/>
             <span class="label label-important">${error.telefone}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputNomeRepresentante">Nome do Representante</label>
        <div>
            <mtw:input type="text" id="inputNomeRepresentante" name="nomeRepresentante"/>
             <span class="label label-important">${error.nomeRepresentante}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputcpfRepresentante">CPF do Representante</label>
        <div>
            <mtw:input type="text" id="inputcpfRepresentante" name="cpfRepresentante"/>
             <span class="label label-important">${error.cpfRepresentante}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputcnpj">CNPJ</label>
        <div>
            <mtw:input type="text" id="inputcnpj" name="cnpj"/>
             <span class="label label-important">${error.cnpj}</span>
        </div>
    </div>
    <br />
    <div>
        <div>
            <button type="submit" name="entrar" class="btn btn-success">Confirmar</button>
        </div>
    </div>
</mtw:form>