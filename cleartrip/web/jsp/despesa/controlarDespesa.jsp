<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>


<div class="tabela tabelaFormatacao">
    <display:table name="lista" pagesize="3" requestURI="" defaultsort="1">
        <display:column property="nome" sortName="nome" sortable="true" title="Nome" style="width:4%;"/>
        <display:column property="valorLimite" title="Valor Limite" style="width:4%;"/>
        </display:table>    
</div>

<div class="tabela tabelaFormatacao">
    <display:table name="setDespesa" pagesize="3" requestURI="" defaultsort="1">
        <display:column property="valor" title="Valor" style="width:4%;"/>
        
        </display:table>    
</div>