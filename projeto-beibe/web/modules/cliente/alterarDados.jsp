<%-- 
    Document   : alterarDados
    Created on : 16/08/2020, 11:30:50
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
             <h4 class="mt-4">Alterar dados cadastrados</h4>
        </div>
        <div class="container" style="margin-top: 40px;">
           
            <jsp:useBean id="usuario" class="com.br.beibe.tads.bean.Usuario" scope="session" />
            <jsp:setProperty name="usuario" property="*"/> 
              <form class="ml-4 mr-4" style="width: 600px;">
                    <div class="form-row">
                        <div class="form-group col-md-12">
                          <label for="nome">Nome</label>
                           <input type="text" class="form-control" value="${usuario.nome}" >
                        </div>

                     </div>
                        <div class="form-row">
                          <div class="form-group col-md-12">
                            <label for="email">Endereço</label>
                            <input type="text" class="form-control" value="${usuario.endereco}">
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                             <label for="estado">Estado</label>
                              <select  class="form-control">
                                   <c:forEach var="lstEstd" items="${requestScope.listaEstado}">
                                       <c:choose>
                                           <c:when test="${usuario.cidade.estado.id == lstEstd.getId()}">
                                             <option selected value="${lstEstd.getId()}"> ${lstEstd.getNome()} </option>
                                           </c:when>
                                           <c:otherwise>
                                              <option value="${lstEstd.getId()}"> ${lstEstd.getNome()} </option>
                                           </c:otherwise>
                                        </c:choose>
                                   </c:forEach>
                               </select>
                           </div>
                           <div class="form-group col-md-6">
                             <label for="estado">Cidade</label>
                            <select  class="form-control">
                                <c:forEach var="lstCdd" items="${requestScope.listaCidade}">
                                    <c:choose>
                                        <c:when test="${usuario.cidade.id == lstCdd.getId()}">
                                          <option selected value="${lstCdd.getId()}"> ${lstCdd.getNome()} </option>
                                        </c:when>
                                        <c:otherwise>
                                           <option value="${lstCdd.getId()}"> ${lstCdd.getNome()} </option>
                                        </c:otherwise>
                                     </c:choose>
                                </c:forEach>
                             </select>
                           </div>

                         </div>
                <div class="form-group">
                    <label>Telefone</label>
                    <input type="text" class="form-control" value="${usuario.telefone}"> 
                </div>   
                <div class="form-group validacao">
                    <label>Senha</label>
                    <input type="password" class="form-control" placeholder="Digite sua senha atual"></br>
                    <input type="password" class="form-control nova_senha" id="valida" placeholder="Digite sua nova senha"></br>
                    <input type="password" class="form-control confirma_senha" id="valida2" placeholder="Confirmar nova senha">
                    <span id="error"></span>       
                </div>
                <div class="mx-auto">
                        <button type="submit" class="btn btn-primary btn-lg" style="background-color: #57ba85; border-color:#57ba85;" >Enviar</button>
                 </div>
            </form>
        </div>
        <script src="js/validacao.js"></script>
         <script>
           
          $("#alterarDados").addClass("active");
              
        </script>
    </body>
</html>
