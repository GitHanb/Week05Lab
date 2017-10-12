<%-- 
    Document   : shoppingList
    Created on : 12-Oct-2017, 9:08:38 AM
    Author     : 636334
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShoppingList Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
        </div>
        <h1>List</h1>
        <div>
            <form action="ShoppingList?action=add" method="post">
                Add item: <input type="text" name="item" value="${item}">
                <input type="submit" value="Add">
            </form>
            <br>
            ${itemList}
            <br><br>
            <input type="submit" value="Delete" formaction="ShoppingList?action=delete">
        </div>
    </body>
</html>
