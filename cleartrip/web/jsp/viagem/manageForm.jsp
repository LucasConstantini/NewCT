<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form klass="form-horizontal" action="UsuarioCreate.mtw" method="post">
    <mtw:input type="hidden" name="viagem.id"/>
    <mtw:input type="hidden" name="viagem.transporte.id"/>

    <legend>Soliciatar Viagem</legend>

    <div>
        <!-- Inicio da JSP -->
        <div>
            <label for="inputStatus">Status</label>
            <div>
                <mtw:input type="text" id="inputStatus" name="viagem.status" />
                <br /><span class="label label-important">${error.status}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputAdiantamento">Adiantamento</label>
            <div>
                <mtw:input type="text" id="inputAdiantamento" name="viagem.adiantamento" />
                <br /><span class="label label-important">${error.adiantamento}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputReembolso">Reembolso</label>
            <div>
                <mtw:input type="text" id="inputReembolso" name="viagem.reembolso" />
                <br /><span class="label label-important">${error.reembolso}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputRessarcimento">Ressarcimento</label>
            <div>
                <mtw:input type="text" id="inputRessarcimento" name="viagem.ressarcimento" />
                <br /><span class="label label-important">${error.ressarcimento}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputNReciboAdiantamento">Nº do Recibo do Adiantamento</label>
            <div>
                <mtw:input type="text" id="inputNReciboAdiantamento" name="viagem.nReciboAdiantamento" />
                <br /><span class="label label-important">${error.nReciboAdiantamento}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputNReciboRessarcimento">Nº do Recibo do Ressarcimento</label>
            <div>
                <mtw:input type="text" id="inputNReciboRessarcimento" name="viagem.nReciboRessarcimento" />
                <br /><span class="label label-important">${error.nReciboRessarcimento}</span> <br />
            </div>
        </div>
        <br />
    </div>
</mtw:form>

