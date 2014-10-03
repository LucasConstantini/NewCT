<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<head>
    <script>
        $(function() {
            $('#Usuarios').addClass('active');
        });
    </script>
    <title>Meios de Transporte</title>
</head>

<div class="input-append">
    <mtw:form action="EmpresaRead.mtw">
        <mtw:input name="nome" type="text"/>
        <button class="btn" type="submit"><img src='img/pesquisar.png'></button>
        <a href="EmpresaShowForm.mtw" class="btn"><img src='img/novo.png' />Nova</a>
    </mtw:form>
</div>
<div>
    <div class="tabela">
        <display:table name="lista" id="item" pagesize="3" requestURI="" defaultsort="1" sort="list">
            <display:column property="id" sortName="id" sortable="true" title="Código" style="width:10%;"/>
            <display:column property="nome" sortable="true" title="Nome" style="width:30%;"/>
            <display:column property="telefone" sortable="true" title="Telefone" style="width:20%;"/>
            <display:column property="nomeRepresentante" sortable="true" title="Representante" style="width:30%;"/>
            <display:column value="<img src='img/editar.png'alt='Editar'>" href="EmpresaShowForm.mtw" paramId="id" paramProperty="id" title="Editar" style="width:5%;"/>
            <display:column value="<img src='img/lixeira.png'alt='Excluir'>" href="EmpresaDelete.mtw"  paramId="id" paramProperty="id" title="Excluir" class="deleteLink" style="width:5%;"/>
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