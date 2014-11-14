<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>


<div class="tabela tabelaFormatacao">
    <display:table name="lista" pagesize="3" requestURI="" defaultsort="1">
        <display:column property="nome" sortName="nome" sortable="true" title="Nome" style="width:4%;"/>
        <display:column property="valorLimite" title="Valor Limite" style="width:4%;"/>
    </display:table>    
</div>

<div class="tabela tabelaFormatacao">
    <table>
        <tr> 
        <td>Nome</td>
        <td>Valor</td>
        </tr>
        <c:forEach items="${gastos}" var="gasto">
            <tr> 
            <td>${gasto.key}</td>
            <td>${gasto.value}</td>
            </tr>
        </c:forEach>
    </table>
</div>