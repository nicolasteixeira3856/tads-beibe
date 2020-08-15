<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <%@include file="imports.jsp" %>
         <link rel="stylesheet" href="css/produto.css">
    </head>
    <body>
        <div  class="container">
        <form class="ml-4 mr-4">
  <div class="form-row">
      <div class="form-group col-md-6">
     
      <label for="produto">Produto</label>
      <select id="produto" class="form-control">
        <option selected>Escolher...</option>
        <option>...</option>
      </select>

    </div>
    <div class="form-group col-md-6">
     
      <label for="atendimento">Tipo de atendimento</label>
      <select id="atendimento" class="form-control">
        <option selected>Escolher...</option>
        <option>...</option>
      </select>

    </div>
  </div>
          <div class="form-row">
    <div class="form-group col-md-12">
     <label for="descricao">Descrição</label>
    <textarea class="form-control" id="descricao"></textarea>
    </div>
  </div>
 
 
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
        </div> 
</html>
