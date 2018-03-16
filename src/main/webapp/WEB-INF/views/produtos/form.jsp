<%-- 
    Document   : form
    Created on : 09/03/2018, 14:33:07
    Author     : joaon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar produto</h1>
        <h2>${mensagem}</h2>
        <hr/>
        <spring:url var="path_salvar" value="/produtos"/>
        <form:form action="${path_salvar}" method="post" modelAttribute="produto">
            <form:input type="hidden" path="id"/>
            <label for="nome">Nome</label>
            <form:input type="text" path="nome"/>
            <c:if test = "${produto.id != null}">
                <input type="submit" value="atualizar"/>
            </c:if>
            <c:if test = "${produto.id == null}">
                <input type="submit" value="Cadastrar"/>
            </c:if>
        </form:form>
        <hr/>
    </body>
</html>
