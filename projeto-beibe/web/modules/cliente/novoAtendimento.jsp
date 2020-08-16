<%-- 
    Document   : novoAtendimento
    Created on : 16/08/2020, 11:30:27
    Author     : nicol
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.logado}" >
    <c:set var="mensagem" value="É necessário estar logado"
    scope="request" />
    <jsp:forward page="index.jsp" />
</c:if>
<c:if test="${sessionScope.usuario.getNivel() != 3}">
    <c:set var="mensagem" value="Você não tem acesso o suficiente"
    scope="request" />
    <jsp:forward page="index.jsp" />
</c:if>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/imports.jsp" %>
         <link rel="stylesheet" href="css/cadastro.css">
    </head>
    <body>
        <%@include file="components/navbarCliente.jsp" %>
        <div class="centro">
             <h4 class="mt-4">Novo Atendimento</h4>
        </div>
        <div class="container" style="margin-top: -40px;">
            <div style="width:700px;">
                <form action="AtendimentoServlet?action=novoAtendimento" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="produto">Produto</label>
                            <select name="produto" class="form-control">
                                <option selected>Escolher...</option>
                                 <c:forEach var="prd" items="${requestScope.listaProduto}">
                                    <option value="${prd.getId()}"> ${prd.getNome()} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="atendimento">Tipo de atendimento</label>
                            <select name="tipoAtendimento" class="form-control">
                                <option selected>Escolher...</option>
                                <c:forEach var="tipoAtd" items="${requestScope.listaTipoAtendimento}">
                                    <option value="${tipoAtd.getId()}"> ${tipoAtd.getNome()} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="descricao">Descrição</label>
                            <textarea class="form-control" name="descricao" style="height: 250px;"></textarea>
                        </div>
                    </div>
                    <div class="mx-auto">
                        <button type="submit" class="btn btn-primary btn-lg" style="background-color: #57ba85; border-color:#57ba85;" >Enviar</button>
                    </div>
                </form>
            </div>
        </div>
        <script>
           
          $("#novoAtendimento").addClass("active");
              
        </script>
    </body>
    
</html>
