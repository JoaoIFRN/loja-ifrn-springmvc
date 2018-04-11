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
        <div class="container">
            <h1>Home</h1>
            <nav>
                <ul>
                    <li><a href="produtos/lista">Lista de produtos</a></li>
                    <li><a href="produtos/form">Cadastrar produtos</a></li> 
                    <li><a href="usuarios/lista">Lista de usuários</a></li> 
                </ul>
            </nav>
        </div>
    </body>
</html>
