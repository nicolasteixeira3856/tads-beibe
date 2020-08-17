<%-- 
    Document   : portalClienteMsg
    Created on : 16/08/2020, 15:53:31
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
        <link rel="stylesheet" href="modules/cliente/css/style.css">
    </head>
    <body>
        <%@include file="components/navbarCliente.jsp" %>
        <div class="container">
            <br>
            <c:if test="${not empty sessionScope.mensagemSucesso}">
                <div class="alert alert-success text-center corPrincipal">
                    <strong class="colorSpan"><c:out value="${sessionScope.mensagemSucesso}"/></strong><br>
                    <span><a class="spanLinkMsg" href="/projeto-beibe/ClienteServlet?action=listarAtendimentos">Clique aqui para retornar a página inicial</a></span>
                </div>
                <c:set var="mensagemSucesso" value="" scope="request"/>
            </c:if>
            <c:if test="${not empty requestScope.mensagemErro}">
                <div class="alert alert-error text-center corError">
                    <strong class="colorSpan"><c:out value="${requestScope.mensagemErro}"/></strong><br>
                    <span><a class="spanLinkMsg" href="/projeto-beibe/ClienteServlet?action=listarAtendimentos">Clique aqui para retornar a página inicial</a></span>
                </div>
                <c:set var="mensagemErro" value="" scope="request"/>
            </c:if>
        </div>
    </body>
</html>
