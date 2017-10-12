<%-- 
    Document   : register
    Created on : 12-Oct-2017, 8:57:52 AM
    Author     : 636334
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            <form action="ShoppingList?action=register" method="post">
                Username: <input type="text" name="username" value="${username}">
                <input type="submit" value="Resgister name">
            </form>
            <br>
            ${registerMessage}
        </div>
    </body>
</html>
