<%-- 
    Document   : home
    Created on : 02/03/2018, 13:58:56
    Author     : joaon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <spring:url value="/static/bootstrap/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"  type="text/css" />  

        <title>JSP Page</title>
    </head>
    <body>

        <c:url value="/index" var="index"/>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
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
                <h1>Home</h1>
                <ul>
                    <li><a href="produtos/lista">Lista de produtos</a></li>
                    <li><a href="produtos/form">Cadastrar produtos</a></li> 
                    <li><a href="usuarios/lista">Lista de usuários</a></li> 
                </ul>
            </div>
        </main>
    </body>
</html>
