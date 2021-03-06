<%-- 
    Document   : form
    Created on : 09/03/2018, 14:33:07
    Author     : joaon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>Cadastrar produto</h1>
        <h2>${mensagem}</h2>
        <hr/>
        <spring:url var="path_salvar" value="/produtos"/>
        <form:form action="${path_salvar}" method="post" modelAttribute="produto" enctype="multipart/form-data">
            <form:input type="hidden" path="id"/>
            <div class="form-group">
                <label for="nome">Nome</label><br/>
                <form:input type="text" path="nome" id="nome"/><br/>
                <form:errors path="nome" cssStyle="color: red"/>
            </div >
            <div class="form-group">
                <label>Data de fabricação</label><br/>
                <form:input type="text" path="dataFabricacao"/><br/>
                <form:errors path="dataFabricacao" cssStyle="color: red"/>
            </div>
            <div class="form-group">
                <label for="preco">Preço</label><br/>
                <form:input type="text" path="preco"/><br/>
                <form:errors path="preco" cssStyle="color: red"/>
            </div>
            <div class="form-group">
                <label for="foto">Foto</label><br/>
                <input type="file" class="form-control-file" name="foto"/><br/>                
            </div>
            <c:if test = "${produto.id != null}">
                <input type="submit" value="Atualizar"/>
            </c:if>
            <c:if test = "${produto.id == null}">
                <input type="submit" value="Cadastrar"/>
            </c:if>
        </form:form>
        <hr/>
    </body>
</html>
