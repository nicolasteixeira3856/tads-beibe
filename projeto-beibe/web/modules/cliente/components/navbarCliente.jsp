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
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
<<<<<<< HEAD
                <a id="dashboard" class="nav-link" href="/projeto-beibe/ClienteServlet?action=dashboard">Dashboard<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a id="listarAtendimentos" class="nav-link" href="/projeto-beibe/ClienteServlet?action=listarAtendimentos">Atendimentos<span class="sr-only">(current)</span></a>
=======
                <a class="nav-link" href="/projeto-beibe/ClienteServlet?action=listarAtendimentos">Atendimentos<span class="sr-only">(current)</span></a>
>>>>>>> 78a5d9f4caa6354373a7f77d2b510555941cc4db
            </li>
            <li class="nav-item">
                <a id="novoAtendimento" class="nav-link" href="/projeto-beibe/ClienteServlet?action=novoAtendimento">Novo atendimento</a>
            </li>
            <li class="nav-item">
                <a id="alterarDados" class="nav-link" href="/projeto-beibe/ClienteServlet?action=alterarDados">Alterar dados</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/projeto-beibe/LogoutServlet" class="navbar-text">Logout</a>
            </li>
        </ul>
    </div>
</nav>