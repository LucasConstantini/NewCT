<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<head>
    <script>
        $(function() {
            $('#Usuarios').addClass('active');
        });
    </script>
</head>
<mtw:form klass="form-horizontal blocoExterno" action="UsuarioUpdate.mtw" method="post">
    <mtw:input type="hidden" name="usuario.id"/>
    <mtw:input name="usuario.login" type="hidden"/>
    <div>
        <legend>Alterar Usuario</legend>
    </div>

    <div>
        <label for="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="usuario.nome"/>
            <span class="label label-important">${error.nome}</span> <br />
            <mtw:input type="text" id="tipoUsuario" value="${usuario.tipo}" name="usuario.tipo"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputEmpresa">Empresa</label>
        <div>
            <mtw:input type="text" id="inputEmpresa" value="usuario.empresa.id" name="usuario.empresa.nome"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputCpf">CPF</label>
        <div>
            <mtw:input type="text" id="inputCpf" name="usuario.cpf"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputRg">RG</label>
        <div>
            <mtw:input type="text" id="inputRg" name="usuario.rg"/>
        </div>
    </div>
    <br />

    <br />
    <div>
        <label for="inputEmailPessoal">Email Pessoal:</label>
        <div>
            <mtw:input type="text" id="inputEmailPessoal" name="usuario.emailPessoal"/>
        </div>
    </div>
    <br />
    <div>
        <label for="inputEmailCorporativo">Email Corporativo:</label>
        <div>
            <mtw:input type="text" id="inputEmailCorporativo" name="usuario.emailCorporativo"/>
        </div>
    </div>
    <br />
    <div>
        <div>
            <label for="inputTelefonePessoal">Telefone Pessoal:</label>
            <div>
                <mtw:input type="text" id="inputTelefonePessoal" name="usuario.telefonePessoal"/>
            </div>
        </div>
        <div>
            <div>
                <label for="inputTelefoneCorporativo">Telefone Corporativo:</label>
                <div>
                    <mtw:input type="text" id="inputTelefoneCorporativo" name="usuario.telefoneCorporativo"/>
                </div>
            </div>
            <div>

                <div class="controls">
                    <button type="submit" class="btt botao" style="margin-left: 0%" ><i class="icon-ok icon-white"></i> Confirmar</button>
                </div>
            </div>

        </div>
    </div>
    <input type="text" id="tipoUsuario" value="${usuario.tipo}" class="hide"/>
</mtw:form>

<script>
    $(function() {
        $('#tipoUsuario').attr('disabled', 'disabled');
        $('#inputLogin').addClass('hide');
    });
</script>




