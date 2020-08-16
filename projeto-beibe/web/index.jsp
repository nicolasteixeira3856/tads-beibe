<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <%@include file="imports.jsp" %>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <div class="container-login">
            <div class="form-login">
                <h3 class="text-center">Beibe</h3>
                <form action="LoginServlet" method="post">
                    <span style="color:red">${mensagem}</span>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" class="form-control form-control-sm" id="email" name="email" aria-describedby="emailHelp">
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control form-control-sm" id="senha" name="senha">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Login</button>
                    <div class="cadastro">
                        Ainda não possui uma conta? <a href="cadastro.jsp">Cadastre-se</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
