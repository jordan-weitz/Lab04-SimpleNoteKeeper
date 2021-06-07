<%-- 
    Document   : viewnote
    Created on : 2-Jun-2021, 12:30:31 PM
    Author     : jweit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h3>View Note</h3>
        <p>Title: ${title}</p>
        <p>Content: ${content}</p>
        <a href="note?edit">Edit</a>
    </body>
</html>
