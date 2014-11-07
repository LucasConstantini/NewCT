<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>


<mtw:form action="CategoriaDespesaCreate.mtw" method="post">

    <legend>Nova Categoria de Despesa</legend>
    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <br />
    <div>
        <label for="inputValorLimite">Valor Limite</label>
        <div>
            <mtw:input type="text" id="inputValorLimite" name="valorLimite" klass="dinheiro"/>
            <span class="label label-important">${error.valorLimite}</span>
        </div>
    </div>
    <br />
    <div>
        <div>
            <button type="submit" name="entrar" class="btn btn-success">Confirmar</button>
        </div>
    </div>
</mtw:form>
<script type="text/javascript">
    $(document).ready(function() {
        $("input.dinheiro").maskMoney({showSymbol: true, symbol: "R$", decimal: ",", thousands: "."});
    });
</script>