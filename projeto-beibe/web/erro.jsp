<%-- 
    Document   : erro
    Created on : 16/08/2020, 16:15:31
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/erro.css">
    </head>
    <body>
        <section class="centered">
            <h1 class="h1Main">ERRO!</h1>
            <div class="container">
                <h1 class="color">${requestScope.mensagem}</h1>
                <h3 class="alignCenter"><a class="linkPagina" href="${requestScope.pagina}">Clique aqui para retornar</a></h3>
            </div>
        </section>
    </body>
</html>
