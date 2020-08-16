<%-- 
    Document   : atendimentoMaisInformacoes
    Created on : 16/08/2020, 19:29:56
    Author     : gabri
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
        <%@include file="components/navbarClienteVisualizandoAtendimento.jsp"%>
        <div class="container">
            <h1>${requestScope.atendimento.getId()}</h1>
            <c:if test="${requestScope.atendimento.getStatus().getId() == 1}">
                <h1>${requestScope.atendimento.getStatus().getNome()}</h1>
                <a class="btn btn-primary" href="/projeto-beibe/AtendimentoServlet?action=removerAtendimento&id=${requestScope.atendimento.getId()}">Remover</a>
            </c:if>
        </div>
    </body>
</html>
