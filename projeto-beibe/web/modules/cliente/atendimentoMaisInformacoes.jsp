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
        <link type="text/css" rel="stylesheet" href="css/atendimentoDetalhe.css">
    </head>
    <body>
        <%@include file="components/navbarClienteVisualizandoAtendimento.jsp"%>
        <div class="container">
            <div class="row content">
                <div class="col-md-12">
                    <h2 class="header">Atendimento - Detalhes</h2>
                </div>
                <div class="col-md-12 lista">
                    <dl class="row">
                        <dt class="col-sm-3 title">ID</dt>
                        <dd class="col-sm-9">${requestScope.atendimento.getId()}</dd>
                    </dl>
                    <hr>
                    <dl class="row">
                        <dt class="col-sm-3 title">Data</dt>
                        <dd class="col-sm-9">${requestScope.atendimento.getDataCriacao()}</dd>
                    </dl>
                    <hr>
                    <dl class="row">
                        <dt class="col-sm-3 title">Usuario</dt>
                        <dd class="col-sm-9">${requestScope.atendimento.getUsuario().getNome()}</dd>
                    </dl>
                    <hr>
                    <dl class="row">    
                        <dt class="col-sm-3 title">Situação</dt>
                        <dd class="col-sm-9">${requestScope.atendimento.getStatus().getNome()}</dd>
                    </dl>
                    <hr>
                    <dl class="row">    
                        <dt class="col-sm-3 title">Produto</dt>
                        <dd class="col-sm-9">${requestScope.atendimento.getProduto().getNome()}</dd>
                    </dl>
                    <hr>
                    <dl class="row">    
                        <dt class="col-sm-3 title">Tipo do Atendimento</dt>
                        <dd class="col-sm-9">${requestScope.atendimento.getTipoAtendimento().getNome()}</dd>
                    </dl>
                    <hr>
                    <dl class="row">    
                        <dt class="col-sm-3 title">Descrição</dt>
                        <dd class="col-sm-9">${requestScope.atendimento.getDescricao()}</dd>
                    </dl>
                    <hr>
                    <dl class="row">    
                        <dt class="col-sm-3 title">Solução Apresentada</dt>
                        <dd class="col-sm-9">
                            <c:if test="${requestScope.atendimento.getSolucaoApresentada() == null}">          
                                <h3>Verificar essa parte da solucao apresentada</h3>
                                <dd class="col-sm-9">${requestScope.atendimento.getSolucaoApresentada()}</dd>
                            </c:if>
                        </dd>
                    </dl>
                    <c:if test="${requestScope.atendimento.getStatus().getId() == 1}">          
                        <a class="btn btn-primary float-right botao col-md-2" href="/projeto-beibe/AtendimentoServlet?action=removerAtendimento&id=${requestScope.atendimento.getId()}">Remover</a>
                    </c:if>
                </div>
            </div>          
        </div>
    </body>
</html>
