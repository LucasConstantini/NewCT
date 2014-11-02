<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<head>
    <script>
        $(function() {
            $('#Usuarios').addClass('active');
        });
    </script>
</head>

<div class="input-append">
    <mtw:form action="ViagemRead.mtw" method="post">

        <div>
            <select name="status">
                <option value="">Status...</option>
                <option value="A">Aprovado</option>
                <option value="R">Recusado</option>
                <option value="E">Em Espera</option>
            </select>



        </div>
        <button class="btn" type="submit"><img src='img/pesquisar.png'></button>
        <a href="ViagemShowForm.mtw" class="btn"><img src='img/novo.png'>Novo</a>
        </mtw:form>    

</div>


<div class="tabela">
    <display:table name="lista" pagesize="20" requestURI="" defaultsort="1">
        <display:column property="destino" sortName="destino" sortable="true" title="Destino" style="width:50%;"/>
        <display:column title="Lancar Despesa" value="<img src='img/celular.png'>" href="DespesaShowForm.mtw" style="width:5%;" paramId="viagem.id" paramProperty="id"/>
        <display:column title="Listar Despesa" value="<img src='img/configuracao1.png'>" href="DespesaRead.mtw"  paramId="viagem.id" paramProperty="id" style="width:5%;"/>
        <display:column title="Excluir" value="<img src='img/lixeira.png'alt='Excluir'>" href="ViagemDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
    </display:table>
</div>

<div class="modal hide fade" id="excessaoDelete">
    <div class="modal-header">
        <button style="color: red;font-size: 24px" type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">

        <div class="alert alert-error">
            <input class="hide" id="mensagemErro" value="${erro.erro}"/>
            <p>${erro.erro}</p>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-danger" data-dismiss="modal" id="botaoOk">OK</a>
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
<!--Nao deletar Viagem Aprovada -->

<div class="modal hide fade" id="excessaoDeleteAprovada">
    <div class="modal-header">
        <button style="color: red;font-size: 24px" type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">

        <div class="alert alert-error">
            <input class="hide" id="mensagemErroAprovada" value="${erro.erroAprovada}"/>
            <p>${erro.erroAprovada}</p>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-danger" data-dismiss="modal" id="botaoOk">OK</a>
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
        if ($('#mensagemErro').val()) {
            $('#excessaoDelete').modal('show');

        }
        ;
        if ($('#mensagemErroAprovada').val()) {
            $('#excessaoDeleteAAprovada').modal('show');

        }
        ;
        $('#botaoOk').click(function() {
            $('#mensagemErro').val('');

        });
    });
</script>