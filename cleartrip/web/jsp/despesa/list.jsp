<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<head>
    <script>
        $(function() {
            $('#Despesas').addClass('active');
        });
    </script>
</head>

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

<div class="input-append">
    <a href="ControlarDespesa.mtw" class="btn"><img src='img/pesquisar.png' />Limites</a>
</div>

<div class="tabela tabelaFormatacao">
    <display:table name="lista" pagesize="7" requestURI="" defaultsort="1">
        <display:column property="valor" sortName="valor" sortable="true" title="Valor" style="width:4%;"/>
        <display:column property="nomeEstabelecimento" title="Estabelecimento" style="width:4%;"/>
    </display:table>



</div>