<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<head>
    <script>
        $(function() {
            $('#Parametro').addClass('active');
        });
    </script>
</head>

<div class="input-append">
        <a href="ParametroShowForm.mtw" class="btn"><img src='img/novo.png'>Novo</a>   
</div>


<div class="tabela tabelaFormatacao">
    <display:table name="lista" pagesize="3" requestURI="" defaultsort="1">
        <display:column property="dataInicio" sortName="dataInicio" sortable="true" title="Data Inicio" style="width:4%;"/>
        <display:column title="Editar" value="<img src='img/editar.png'alt='Editar'>" href="ParametroShowForm.mtw"  paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column title="Excluir" value="<img src='img/lixeira.png'alt='Excluir'>" href="ParametroDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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
<!--Nao deletar Parametro válido -->

<div class="modal hide fade" id="excessaoDeleteAdm">
    <div class="modal-header">
        <button style="color: red;font-size: 24px" type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">

        <div class="alert alert-error">
            <input class="hide" id="mensagemErroAdm" value="${erro.erroPar}"/>
            <p>${erro.erroPar}</p>
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
        if ($('#mensagemErroPar').val()) {
            $('#excessaoDeletePar').modal('show');

        }
        ;
        $('#botaoOk').click(function() {
            $('#mensagemErro').val('');

        });
    });
</script>