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
<c:if test="${sessionScope.usuario.getNivel() != 3}">
    <c:set var="mensagem" value="Você não tem acesso o suficiente"
    scope="request" />
    <jsp:forward page="index.jsp" />
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="imports.jsp" %>
        <script src="js/validacao.js"></script>
    </head>
    <body>
        <%@include file="components/navbarCliente.jsp" %>
        <div class="container">
            <div class="tab-content">
                <div class="tab-pane fade show active" id="atendimentos">
                    <h4 class="mt-2">Home tab content</h4>
                    <p>Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui. Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                </div>
                <div class="tab-pane fade" id="novoAtendimento">
                    <div style="padding: 50px;">
                        <form class="mt-2">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="produto">Produto</label>
                                    <select id="produto" class="form-control">
                                        <option selected>Escolher...</option>
                                         <c:forEach var="prd" items="${requestScope.listaProduto}">
                                            <option value="${prd.getId()}"> ${prd.getNome()} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="atendimento">Tipo de atendimento</label>
                                    <select id="atendimento" class="form-control">
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
                                    <textarea class="form-control" id="descricao" style="height: 250px;"></textarea>
                                </div>
                            </div>
                            <div class="mx-auto">
                                <button type="submit" class="btn btn-primary btn-lg" style="background-color: #57ba85; border-color:#57ba85;" >Enviar</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="tab-pane fade" id="alterarDados">
                    <h4 class="mt-2">Alterar dados cadastrados</h4>
                    <jsp:useBean id="usuario" class="com.br.beibe.tads.bean.Usuario" scope="session" />
                    <jsp:setProperty name="usuario" property="*"/> 
                    <form>
                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" class="form-control" value="${usuario.nome}" >
                        </div>
                        <div class="form-group">
                            <label>Endereço</label>
                            <input type="text" class="form-control" value="${usuario.endereco}"></br> 
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
                            </select> </br>
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
                        <button type="submit" class="btn btn-primary" id="botao">Enviar</button>
                    </form>
                </div>
            </div>
        </div>               
    </body>
</html>
    
