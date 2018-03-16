<%-- 
    Document   : lista
    Created on : 07/03/2018, 14:50:39
    Author     : joaon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <spring:url var="path_excluir" value="/produtos/excluir"/>
        <spring:url var="path_atualizar" value="/produtos/atualizar"/>   
        <spring:url var="path_form" value="/produtos/form"/>  
        <header>
            <h1>Lista de produtos</h1>
            <hr/>
            <h2>${mensagem}</h2>
            <a href="${path_form}">Novo produto</a>
            <hr/>
        </header>
        <main>

            <table>
                <thead>
                <th>Id</th>
                <th>Nomes</th>
                <th>Ações</th>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${produtos}">
                        <tr>   
                            <td>${produto.id}</td>
                            <td>${produto.nome}</td>
                            <td><a href="${path_atualizar}/${produto.id}">Editar</a>&nbsp;&nbsp;<a href="${path_excluir}/${produto.id}">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </body>
</html>
