<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="EmpresaUpdate.mtw" method="post">
    <mtw:input type="hidden" name="empresa.id"/>
        <legend>Alterar Empresa</legend>
        <div>
            <label for="inputNome">Nome</label>
            <div>
                <mtw:input type="text" id="inputNome" name="empresa.nome"/>
                 <span class="label label-important">${error.nome}</span>
            </div>
        </div>
            <div>
            <label for="inputNomeFantasia">Nome Fantasia</label>
            <div>
                <mtw:input type="text" id="inputNomeFantasia" name="empresa.nomeFantasia"/>
                 <span class="label label-important">${error.nomeFantasia}</span>
            </div>
        </div>
            <div>
            <label for="inputEndereco">Endereço</label>
            <div>
                <mtw:input type="text" id="inputEndereco" name="empresa.endereco"/>
                 <span class="label label-important">${error.endereco}</span>
            </div>
        </div>
            <div>
            <label for="inputTelefone">Telefone</label>
            <div>
                <mtw:input type="text" id="inputTelefone" name="empresa.telefone"/>
                 <span class="label label-important">${error.telefone}</span>
            </div>
        </div>
            <div>
            <label for="inputNomeRepresentante">Nome do Representante</label>
            <div>
                <mtw:input type="text" id="inputNomeRepresentante" name="empresa.nomeRepresentante"/>
                 <span class="label label-important">${error.nomeRepresentante}</span>
            </div>
        </div>
            <div>
            <label for="inputcpfRepresentante">CPF do Representante</label>
            <div>
                <mtw:input type="text" id="inputcpfRepresentante" name="empresa.cpfRepresentante"/>
                 <span class="label label-important">${error.cpfRepresentante}</span>
            </div>
            <div>
            <label for="inputcnpj">CNPJ</label>
            <div>
                <mtw:input type="text" id="inputcnpj" name="empresa.cnpj"/>
                 <span class="label label-important">${error.cnpj}</span>
            </div>
        </div>
        <div>
            <div>
                <button type="submit" name="entrar" class="btn btn-success">Confirmar</button>
            </div>
        </div>
    </mtw:form>