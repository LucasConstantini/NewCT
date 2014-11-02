<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form action="AlterarSenha.mtw" method="post">
    <div class="form-group">
        <label for="senhaAtual" class="sr-only">Senha Atual</label>
        <mtw:input type="password" name="senhaAtual" id="senhaAtual" klass="form-control" />
    </div>
    <div class="form-group">
        <label for="senhaNova" class="sr-only">Nova Senha</label>
        <mtw:input type="password" name="senhaNova" id="senhaNova" klass="form-control" />
    </div>
    <div class="form-group">
        <label for="senhaConfirmacao" class="sr-only">Confirmação</label>
        <mtw:input type="password" name="senhaConfirmacao" id="senhaConfirmacao" klass="form-control" />
    </div>
    <div id="mostraSenha">
        <span onclick="showPassword()">
            <input type="checkbox" name="checkboxes" id="checkboxes" >

        </span>
        <div id="comentario"> Exibir Senhas</div>
    </div>
    <br />
    <br />
    <span class="label label-important">${error.senhaAtual}</span>
    <br />
    <br />
    <br />
    <div>
        <mtw:submit name="entrar" klass="btn btn-success" value="Confirmar" />
    </div>
</mtw:form>
<script type="text/javascript">
    function showPassword() {

        var key_attr = $('#senhaAtual').attr('type');

        if (key_attr !== 'text') {

            $('.checkbox').addClass('show');
            $('#senhaAtual').attr('type', 'text');
            $('#senhaNova').attr('type', 'text');
            $('#senhaConfirmacao').attr('type', 'text');

        } else {

            $('.checkbox').removeClass('show');
            $('#senhaAtual').attr('type', 'password');
            $('#senhaNova').attr('type', 'password');
            $('#senhaConfirmacao').attr('type', 'password');
        }
    }
</script>