<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<mtw:form action="NewDespesa.mtw" method="post">

<legend>Informar Despesa</legend>

<div class="control-group">
  <label class="control-label" for="file">Comprovante</label>
  <div class="controls">
    <input id="file" name="file" class="input-file" type="file">
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="valor">Valor</label>
  <div class="controls">
    <input id="valor" name="valor" type="text" placeholder="" class="input-small" required="">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="categoria">Categoria de Despesa</label>
  <div class="controls">
    <select id="categoria" name="categoria" class="input-xlarge">
      <option>Option one</option>
      <option>Option two</option>
    </select>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="cnpj">CNPJ Fornecedor</label>
  <div class="controls">
    <input id="cnpj" name="cnpj" type="text" placeholder="" class="input-xlarge">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="fornecedor">Fornecedor</label>
  <div class="controls">
    <input id="fornecedor" name="fornecedor" type="text" placeholder="" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="observacoes">Observações</label>
  <div class="controls">                     
    <textarea id="observacoes" name="observacoes"></textarea>
  </div>
</div>

</mtw:form>