<%-- 
    Document   : navbarCliente
    Created on : 14/08/2020, 23:15:40
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #57ba85">
    <a class="navbar-brand" href="#">Beibe</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav nav mr-auto">
          <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#atendimentos">Atendimentos<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#novoAtendimento">Novo atendimento</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#alterarDados">Alterar dados</a>
          </li>
        </ul>
        <span class="navbar-text">
            Logout
        </span>
    </div>
</nav>