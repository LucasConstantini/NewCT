<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<head>
    <script>
        $(function(){
            $('#Viagem').addClass('active');
        });
    </script>
</head> 
<div class="tabela tabelaFormatacao"> 
    <display:table  name="lista" pagesize="20" requestURI="" defaultsort="1">        
        <display:column property="id" sortName="id" sortable="true" title="Código" style="width:5%;"/>
        <display:column property="usuario.nome" title="Solicitante" style="width:5%;"/>
        <display:column property="destino" title="Destino" style="width:5%;"/>
        <display:column property="dataPartida" title="Data da Partida" format="{0, date, dd/MM/yyyy}" style="width:15%;"/>
        <display:column title="Gerenciar" value="<img src='img/editar.png'alt='Gerenciar'>" href="ViagemUpdate.mtw" paramId="id" paramProperty="id" style="width:5%;color:"  />        
    </display:table>
</div>