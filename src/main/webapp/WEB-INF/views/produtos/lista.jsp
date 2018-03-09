<%-- 
    Document   : lista
    Created on : 07/03/2018, 14:50:39
    Author     : joaon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Lista de produtos</h1>
        </header>
        <main>
            <ul>
                <c:forEach var="produto" items="${produtos}">
                    <li>${produto.nome}</li>
                </c:forEach>
            </ul>
        </main>
    </body>
</html>
