<%-- 
    Document   : listaAtendimento
    Created on : 16/08/2020, 11:30:37
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
    </head>
    <body>
        <%@include file="components/navbarCliente.jsp" %>
        <div class="container">
            <c:forEach var="atendimento" items="${requestScope.listaAtendimento}">
                <div class="card">
                    <div class="card-body">
                        ${atendimento.getId()}
                        ${atendimento.getDataCriacao()}<br>
                        ${atendimento.getTipoAtendimento().getNome()}<br>
                        ${atendimento.getStatus().getNome()}<br>                                    
                        ${atendimento.getProduto().getNome()}
                     </div>
                    <div class="card-body text-right">
                        <a href="AtendimentoServlet?action=maisInformacoes&id=${atendimento.getId()}" class="btn btn-primary">Mais informações</a>
                    </div>
                </div>
            </c:forEach>   
        </div>
        <script>
           
          $("#listarAtendimentos").addClass("active");
              
        </script>
    </body>
</html>
