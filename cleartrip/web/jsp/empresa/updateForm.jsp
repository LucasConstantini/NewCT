<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="EmpresaUpdate.mtw" method="post">
    <mtw:input type="hidden" name="empresa.id"/>
        <legend>Alterar Empresa</legend>
        <div>
            <label for="inputNome">Nome</label>
            <div>
                <mtw:input type="text" id="inputNome" name="empresa.nome"/>
            </div>
        </div>
            <div>
            <label for="inputNomeFantasia">Nome Fantasia</label>
            <div>
                <mtw:input type="text" id="inputNomeFantasia" name="empresa.nomeFantasia"/>
            </div>
        </div>
            <div>
            <label for="inputEndereco">Endereço</label>
            <div>
                <mtw:input type="text" id="inputEndereco" name="empresa.endereco"/>
            </div>
        </div>
            <div>
            <label for="inputTelefone">Telefone</label>
            <div>
                <mtw:input type="text" id="inputTelefone" name="empresa.telefone"/>
            </div>
        </div>
            <div>
            <label for="inputNomeRepresentante">Nome do Representante</label>
            <div>
                <mtw:input type="text" id="inputNomeRepresentante" name="empresa.nomeRepresentante"/>
            </div>
        </div>
            <div>
            <label for="inputcpfRepresentante">CPF do Representante</label>
            <div>
                <mtw:input type="text" id="inputcpfRepresentante" name="empresa.cpfRepresentante"/>
            </div>
            <div>
            <label for="inputcnpj">CNPJ</label>
            <div>
                <mtw:input type="text" id="inputcnpj" name="empresa.cnpj"/>
            </div>
        </div>
        <div>
            <div>
                <button type="submit">Confirmar</button>
            </div>
        </div>
    </mtw:form>