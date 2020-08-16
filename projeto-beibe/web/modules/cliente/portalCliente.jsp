<%-- 
    Document   : portalCliente
    Created on : 16/08/2020, 11:30:57
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
            <c:if test="${not empty sessionScope.mensagemSucesso}">
                <div class="alert alert-success">
                    <strong><c:out value="${sessionScope.mensagemSucesso}"/></strong>
                </div>
                <c:set var="mensagemSucesso" value="" scope="request"/>
            </c:if>
            <c:if test="${not empty sessionScope.mensagemErro}">
                <div class="alert alert-success">
                    <strong><c:out value="${sessionScope.mensagemErro}"/></strong>
                </div>
                <c:set var="mensagemErro" value="" scope="request"/>
            </c:if>
            <h1>Bem vindo Cliente</h1> 
        </div>
    </body>
</html>
