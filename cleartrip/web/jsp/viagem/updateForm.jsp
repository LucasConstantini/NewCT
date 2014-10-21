<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form klass="form-horizontal" action="ViagemUpdate.mtw" method="post">
    <mtw:input type="hidden" name="viagem.id"/>
    
    <legend>Soliciatar Viagem</legend>

    <div>
        <!-- Inicio da JSP -->
        <div>
            <label for="inputDestino">Destino</label>
            <div>
                <mtw:input type="text" id="inputDestino" name="viagem.destino" />
                <br /><span class="label label-important">${error.destino}</span> <br />
            </div>
        </div>
        <br />
        <div class="control-group">
            <label class="control-label" for="inputTransporte">Transporte</label>
            <div class="controls">
                <mtw:select id="inputTransporte" name="viagem.transporte.id" list="transportes" emptyField="true" emptyFieldValue="Selecione..."/>
                <span class="label label-important">${error.transporte}</span>
            </div>
        </div>
        <br/>
        <div>
            <label for="inputMotivo">Motivo</label>
            <div>
                <mtw:input type="text" id="inputMotivo" name="viagem.motivo" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputEnderecoDestino">Endereco Destino</label>
            <div>
                <mtw:input type="text" id="inputEnderecoDestino" name="viagem.enderecoDestino" />
                <br /><span class="label label-important">${error.enderecoDestino}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputTelefoneDestino">Telefone Destino</label>
            <div>
                <mtw:input type="text" id="inputTelefoneDestino" name="viagem.telefoneDestino" />
                <br /><span class="label label-important">${error.telefoneDestino}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputOutrosMateriais">Outros Materiais</label>
            <div>
                <mtw:input type="text" id="inputOutrosMateriais" name="viagem.outrosMateriais" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputCidadePartida">Cidade Partida</label>
            <div>
                <mtw:input type="text" id="inputCidadePartida" name="viagem.cidadePartida" />
                <br /><span class="label label-important">${error.cidadePartida}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputEnderecoPartida">Endereco Partida</label>
            <div>
                <mtw:input type="text" id="inputEnderecoPartida" name="viagem.enderecoPartida" />
                <br /><span class="label label-important">${error.enderecoPartida}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputTelefonePartida">Telefone Partida</label>
            <div>
                <mtw:input type="text" id="inputTelefonePartida" name="viagem.telefonePartida" />
                <br /><span class="label label-important">${error.telefonePartida}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputAeroportoIda">Aeroporto Ida</label>
            <div>
                <mtw:input type="text" id="inputAeroportoIda" name="viagem.aeroportoIda" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputCiaAereaIda">Cia Aerea Ida</label>
            <div>
                <mtw:input type="text" id="inputCiaAereaIda" name="viagem.ciaAereaIda" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputNumeroVooIda">Numero Voo Ida</label>
            <div>
                <mtw:input type="text" id="inputNumeroVooIda" name="viagem.numeroVooIda" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputAeroportoVolta">Aeroporto Volta</label>
            <div>
                <mtw:input type="text" id="inputAeroportoVolta" name="viagem.aeroportoVolta" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputCiaAereaVolta">Cia Aerea Volta</label>
            <div>
                <mtw:input type="text" id="inputCiaAereaVolta" name="viagem.ciaAereaVolta" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputNumeroVooVolta">Numero Voo Volta</label>
            <div>
                <mtw:input type="text" id="inputNumeroVooVolta" name="viagem.numeroVooVolta" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputRelatoViagem">Descrição</label>
            <div>
                <mtw:textarea id="inputRelatoViagem" name="viagem.relatoViagem" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputDataPartida">Data Partida</label>
            <div>
                <mtw:input type="text" id="inputDataPartida" name="viagem.dataPartida" />
                <br /><span class="label label-important">${error.dataPartida}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputHoraPartida">Hora Partida</label>
            <div>
                <mtw:input type="text" id="inputHoraPartida" name="viagem.horaPartida" />
                <br /><span class="label label-important">${error.horaPartida}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputDataCompromisso">Data Compromisso</label>
            <div>
                <mtw:input type="text" id="inputDataCompromisso" name="viagem.dataCompromisso" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputHoraCompromisso">Hora Compromisso</label>
            <div>
                <mtw:input type="text" id="inputHoraCompromisso" name="viagem.horaCompromisso" />
            </div>
        </div>
        <br />
        <div>
            <label for="inputDataVolta">Data Volta</label>
            <div>
                <mtw:input type="text" id="inputDataVolta" name="viagem.dataVolta" />
                <br /><span class="label label-important">${error.dataVolta}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <label for="inputHoraVolta">Hora Volta</label>
            <div>
                <mtw:input type="text" id="inputHoraVolta" name="viagem.horaVolta" />
                <br /><span class="label label-important">${error.horaVolta}</span> <br />
            </div>
        </div>
        <br />
        <div>
            <mtw:submit name="entrar" klass="btn btn-success" value="Confirmar" />
        </div>
    </div>
</mtw:form>

