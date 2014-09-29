<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empresa</title>
    </head>

    <body>
        <div>
            <mtw:form action="EmpresaRead.mtw">
                <mtw:input name="nome" type="text"/>
                <button class="btn" type="submit"><i class="icon-search"></i> Pesquisar</button>
                <a href="EmpresaShowForm.mtw" class="btn"><i class="icon-plus"></i> Nova</a>
            </mtw:form>
        </div>
        <div>
            <div class="tabela">
                <display:table name="lista" id="item" pagesize="3" requestURI="" defaultsort="1" sort="list">
                    <display:column property="id" sortName="id" sortable="true" title="Código" style="width:10%;"/>
                    <display:column property="nome" sortable="true" title="Nome" style="width:80%;"/>
                    <display:column property="telefone" sortable="true" title="Telefone" style="width:80%;"/>
                    <display:column property="nomeRepresentante" sortable="true" title="Representante" style="width:80%;"/>
                    <display:column value="Editar" href="EmpresaShowForm.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
                    <display:column value="Excluir" href="EmpresaDelete.mtw"  paramId="id" paramProperty="id" style="width:5%;"/>
                </display:table>
            </div>
        </div>
    </body>
</html>
