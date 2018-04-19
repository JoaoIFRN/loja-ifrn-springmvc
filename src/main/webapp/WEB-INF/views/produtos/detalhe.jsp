<%-- 
    Document   : detalhe
    Created on : 06/04/2018, 09:07:23
    Author     : joaon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/static/bootstrap/css/bootstrap.css" var="bootstrap"/>
        <link href="${bootstrap}" rel="stylesheet"  type="text/css" />  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Detalhes do produto - ${produto.nome}</h1>
        <a href='${spring:mvcUrl("CC#adicionarItem").arg(0,produto.id).build()}'>Comprar</a>
    </body>
</html>
