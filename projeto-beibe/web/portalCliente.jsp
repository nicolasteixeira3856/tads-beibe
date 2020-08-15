<%-- 
    Document   : portalUsuario
    Created on : 14/08/2020, 19:51:46
    Author     : nicol
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.logado}" >
    <c:set var="mensagem" value="É necessário estar logado"
    scope="request" />
    <jsp:forward page="index.jsp" />
</c:if>
<c:if test="${sessionScope.usuarioNivel != 3}">
    <c:set var="mensagem" value="Você não tem acesso o suficiente"
    scope="request" />
    <jsp:forward page="index.jsp" />
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="imports.jsp" %>
    </head>
    <body>
        <h1>${sessionScope.usuarioId}</h1>
        <%@include file="components/navbarCliente.jsp" %>
    </body>
</html>
    
