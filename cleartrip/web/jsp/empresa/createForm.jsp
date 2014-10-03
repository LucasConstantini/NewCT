<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>


<mtw:form action="EmpresaCreate.mtw" method="post">

    <legend>Nova Empresa</legend>
    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="nome"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputNomeFantasia">Nome Fantasia</label>
        <div>
            <mtw:input type="text" id="inputNomeFantasia" name="nomeFantasia"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputEndereco">Endereço</label>
        <div>
            <mtw:input type="text" id="inputEndereco" name="endereco"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputTelefone">Telefone</label>
        <div>
            <mtw:input type="text" id="inputTelefone" name="telefone"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputNomeRepresentante">Nome do Representante</label>
        <div>
            <mtw:input type="text" id="inputNomeRepresentante" name="nomeRepresentante"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputcpfRepresentante">CPF do Representante</label>
        <div>
            <mtw:input type="text" id="inputcpfRepresentante" name="cpfRepresentante"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputcnpj">CNPJ</label>
        <div>
            <mtw:input type="text" id="inputcnpj" name="cnpj"/>
        </div>
    </div>
    <br />
    <div>
        <div>
            <button type="submit" name="entrar" class="btn btn-success">Confirmar</button>
        </div>
    </div>
</mtw:form>
</div>