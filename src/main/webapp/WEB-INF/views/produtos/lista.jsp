<%-- 
    Document   : lista
    Created on : 07/03/2018, 14:50:39
    Author     : joaon
--%>

<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/static/bootstrap/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"  type="text/css" />  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>    
    <body>
        <spring:url var="path_excluir" value="/produtos/excluir"/>
        <spring:url var="path_atualizar" value="/produtos/atualizar"/>   
        <spring:url var="path_form" value="/produtos/form"/>  

        <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
            <c:url value="/index" var="index"/>
            <a class="navbar-brand" href="${index}">Loja IFRN Parnamirim</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <!--
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                    -->
                </ul>
                <form class="form-inline mt-2 mt-md-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Pesquisar" aria-label="pesquisa">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
                </form>
            </div>
        </nav>

        <main role="main" class="container">
            <div class="jumbotron">
                <h1>Lista de produtos</h1>
                <hr/>
                <h2>${mensagem}</h2>
                <a href="${path_form}">Novo produto</a>
                <hr/>

                <table>
                    <thead>
                    <th>Id</th>
                    <th>Nomes</th>
                    <th>Data de fabricação</th>
                    <th>Preço</th>
                    <th>Arquivo foto</th>
                    <th>Ações</th>
                    </thead>
                    <tbody>
                        <c:forEach var="produto" items="${produtos}">
                            <tr>   
                                <td>${produto.id}</td>
                                <td>
                                    ${produto.nome} 
                                    <a href="${spring:mvcUrl('PC#detalhe').arg(0,produto.id).build()}">
                                        ${produto.id}
                                    </a>
                                </td>

                                <td><fmt:formatDate value="${produto.dataFabricacao.time}" pattern="dd/MM/yyyy"/> </td>

                                <td> <fmt:formatNumber value = "${produto.preco}" type = "currency"/> </td> 
                                <td>${produto.fotoPath}</td>
                                <td><a href="${path_atualizar}/${produto.id}">Editar</a>&nbsp;&nbsp;<a href="${path_excluir}/${produto.id}">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>


    </body>
</html>
