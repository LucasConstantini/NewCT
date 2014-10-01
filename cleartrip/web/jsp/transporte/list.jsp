<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Meio de Transporte</title>
    </head>

    <body>
        <div class="input-append">
            <mtw:form action="TransporteRead.mtw">
                <mtw:input name="nome" type="text"/>
                <button class="btn" type="submit"><img src='img/pesquisar.png'></button>
                <a href="TransporteShowForm.mtw" class="btn"><img src='img/novo.png'>Novo</a>
                </mtw:form>
        </div>
        <div>
            <div class="tabela">
                <display:table name="lista" id="item" pagesize="3" requestURI="" defaultsort="1" sort="list">
                    <display:column property="id" sortName="id" sortable="true" title="Código" style="width:20%;"/>
                    <display:column property="nome" sortable="true" title="Nome" style="width:50%;"/>
                    <display:column value="<img src='img/editar.png'alt='Editar'>" href="TransporteShowForm.mtw" paramId="id" paramProperty="id" style="width:15%;"/>
                    <display:column value="<img src='img/lixeira.png'alt='Excluir'>" href="TransporteDelete.mtw"  paramId="id" paramProperty="id" style="width:15%;"/>
                </display:table>
            </div>
        </div>
    </body>
</html>
