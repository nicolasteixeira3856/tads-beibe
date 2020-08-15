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
        <%@include file="components/navbarCliente.jsp" %>
        <div class="container">
            <div class="tab-content">
                <div class="tab-pane fade show active" id="atendimentos">
                    <h4 class="mt-2">Home tab content</h4>
                    <p>Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui. Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                </div>
                <div class="tab-pane fade" id="novoAtendimento">
                    <div style="padding: 50px;">
                        <form class="mt-5">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="produto">Produto</label>
                                    <select id="produto" class="form-control">
                                        <option selected>Escolher...</option>
                                        <option>...</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="atendimento">Tipo de atendimento</label>
                                    <select id="atendimento" class="form-control">
                                        <option selected>Escolher...</option>
                                        <c:forEach var="tipoAtd" items="${requestScope.listaTipoAtendimento}">
                                            <option> ${tipoAtd.getNome()} </option>
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
                    <h4 class="mt-2">Messages tab content</h4>
                    <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis.</p>
                </div>
            </div>
        </div>
    </body>
</html>
    
