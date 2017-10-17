<%-- 
    Document   : shoppingList
    Created on : 12-Oct-2017, 9:08:38 AM
    Author     : 636334
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            Hello, ${username}
            <a href ="ShoppingList?action=logout">Logout</a>
        </div>
        <br>
        
        <h1>List</h1>
        <form action="ShoppingList?action=add" method="post">
            Add Item: <input type="text" name="item" value="">
            <input type="submit" value="Add">
        </form>
        <br>
        ${shoppingListMessage}
         <br>
         <c:if test="${listsize > 0}">
            <form action="Shoppinglist?action=delete" method="post">
                <c:forEach var="item" items="${itemlist}" varStatus="status">
                    <input type="radio" name="itemname" value="${status.index}"> 
                    ${item}
                    <br>
                </c:forEach>
                <input type="submit" value="Delete">
            </form>
        </c:if>
    </body>
</html>
