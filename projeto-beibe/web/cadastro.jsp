<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <%@include file="imports.jsp" %>
         <link rel="stylesheet" href="css/cadastro.css">
    </head>
    <body>
        <div class="container">
        <form id ="Pd" class="ml-4 mr-4">
  <div class="form-row">
        <div class="form-group col-md-6">
      <label for="nome">Nome</label>
      <input type="email" class="form-control" id="nome" placeholder="Nome">
    </div>
    <div class="form-group col-md-6">
      <label for="CPF">CPF</label>
      <input type="password" class="form-control" id="CPF" placeholder="CPF">
    </div>
  </div>
    <div class="form-row">
        <div class="form-group col-md-6">
      <label for="telefone">Telefone</label>
      <input type="email" class="form-control" id="telefone" placeholder="Nome">
    </div>
    <div class="form-group col-md-6">
      <label for="senha">Senha</label>
      <input type="password" class="form-control" id="senha" placeholder="CPF">
    </div>
  </div>
   <div class="form-row">
    <div class="form-group col-md-12">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" placeholder="Email">
    </div>
  </div>
    <div class="form-row">
     <div class="form-group col-md-4">
      <label for="estado">Estado</label>
      <select id="estado" class="form-control">
        <option selected>Escolher...</option>
        <option>...</option>
      </select>
    </div>
    <div class="form-group col-md-4">
      <label for="estado">Cidade</label>
      <select id="estado" class="form-control">
        <option selected>Escolher...</option>
        <option>...</option>
      </select>
    </div>
    <div class="form-group col-md-4">
      <label for="cep">CEP</label>
      <input type="text" class="form-control" id="cep">
    </div>
  </div>  
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="rua">Rua</label>
    <input type="text" class="form-control" id="rua" >
  </div>
  <div class="form-group col-md-6">
    <label for="bairro">Bairro</label>
    <input type="text" class="form-control" id="bairro" placeholder="Bairro">
  </div>
  </div>
     <div class="form-row">
        <div class="form-group col-md-4">
      <label for="numero">Numero</label>
      <input type="email" class="form-control" id="numero" placeholder="Numero">
    </div>
    <div class="form-group col-md-4">
      <label for="complemento">Complemento</label>
      <input type="password" class="form-control" id="complemento" placeholder="Complemento">
    </div>
  </div>
 
  <div class="form-group">
  </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
        </div>
</html>
