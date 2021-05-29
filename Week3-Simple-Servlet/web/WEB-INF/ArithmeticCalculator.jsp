<%-- 
    Document   : ArithmeticCalculator
    Created on : 26-May-2021, 1:45:31 PM
    Author     : jweit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
        <label>First: </label>
        <input type="text" name="first_num" value="${firstNum}">
        <br>
        <label>Second: </label>
        <input type="text" name="second_num" value="${secondNum}">
        <br>
        <input type="submit" value="plus" name="calc">
        <input type="submit" value="minus" name="calc">
        <input type="submit" value="times" name="calc">
        <input type="submit" value="mod" name="calc">
        </form>
        
        <p>${message}</p>
        <a href="age">Age Calculator</a>
    </body>
</html>
