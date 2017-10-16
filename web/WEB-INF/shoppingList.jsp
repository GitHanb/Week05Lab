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
            Add Item: <input type="text" name="textFieldAddStuff" value="">
            <input type="submit" value="Add"><br>
        </form>
        ${shoppingListMessage}

        <c:forTokens var="part" items="${theItem}" delims="[],">
        <td>${part}</td><br>
        </c:forTokens>
         <br>
         
         <form action="shoppingList?action=delete" method="post">
        	<input type="submit" name="deleteButton" value="Delete">
         </form>
    </body>
</html>
