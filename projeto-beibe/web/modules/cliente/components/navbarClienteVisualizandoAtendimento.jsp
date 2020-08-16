<%-- 
    Document   : navbarClienteVisualizandoAtendimento
    Created on : 16/08/2020, 20:14:40
    Author     : gabri
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
                <a class="nav-link" href="/projeto-beibe/ClienteServlet?action=listarAtendimentos">Retornar ao portal<span class="sr-only">(current)</span></a>
            </li>            
        </ul>
    </div>
</nav>
