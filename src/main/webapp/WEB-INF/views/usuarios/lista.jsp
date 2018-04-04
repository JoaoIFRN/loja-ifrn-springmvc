<%-- 
    Document   : lista
    Created on : 23/03/2018, 14:32:34
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
        <ul>
            <c:forEach items="${usuarios}" var="usuario">
                <li>${usuario.nome}</li>
            </c:forEach>
        </ul>
    </body>
</html>
