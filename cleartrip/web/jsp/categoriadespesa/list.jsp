<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<!DOCTYPE html>

<head>
    <script>
        $(function() {
            $('#CategoriaDespesa').addClass('active');
        });
    </script>
    <title>Categorias de Despesa</title>
</head>


<div class="input-append">
    <mtw:form action="CategoriaDespesaRead.mtw">
        <label for="inputNome">Nome:</label>
        <mtw:input name="nome" id ="inputNome" type="text"/>
        <br/>
        <label for="inputValorInicio">Valor Inicial:</label>
        <mtw:input name="valorLimiteInicio" id="inputValorInicio" type="text"/>
        <br/>
        <label for="inputValorFim">Valor Final:</label>
        <mtw:input name="valorLimiteFim" id="inputValorFim" type="text"/>
        <br/>
        <button class="btn" type="submit"><img src='img/pesquisar.png'></button>
        <a href="CategoriaDespesaShowForm.mtw" class="btn"><img src='img/novo.png' />Novo</a>
        </mtw:form>
</div>
<div>
    <div class="tabela">
        <display:table name="lista" id="item" pagesize="5" requestURI="" defaultsort="1" sort="list">
            <display:column property="id" sortName="id" sortable="true" title="Código" style="width:20%;"/>
            <display:column property="nome" sortable="true" title="Nome" style="width:50%;"/>
            <display:column value="<img src='img/editar.png'alt='Editar'>" href="CategoriaDespesaShowForm.mtw" title="Editar" paramId="id" paramProperty="id" style="width:15%;"/>
            <display:column value="<img src='img/lixeira.png'alt='Excluir'>" href="CategoriaDespesaDelete.mtw"  title="Excluir" paramId="id" paramProperty="id" class="deleteLink" style="width:15%;"/>
        </display:table>
    </div>
</div>
<!--------------------------------------------------------------------------------->        

<div class="modal hide fade" id="confirmDelete">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">
        <p>Você deseja realmente excluir?</p>
        <div class="alert alert-error">
            Atenção: esta operação não pode ser desfeita.
        </div>
    </div>
    <div class="modal-footer" >
        <a href="#" class="btn btn-danger">Excluir</a>
        <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
    </div>   
</div>
<!--------------------------------------------------------------------------------->        
<script>
    $(function() {
        $("td.deleteLink a").click(function() {
            $('#confirmDelete').modal('show');
            $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
            return false;
        });
        $('#botaoOk').click(function() {
            $('#mensagemErro').val('');

        });
    });
</script>