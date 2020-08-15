<%-- 
    Document   : navbarCliente
    Created on : 14/08/2020, 23:15:40
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: #57ba85">
  <a class="navbar-brand" href="#">Navbar w/ text</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Atendimentos <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Novo atendimento</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Alterar dados</a>
      </li>
    </ul>
    <span class="navbar-text">
      Logout
    </span>
  </div>
</nav>
