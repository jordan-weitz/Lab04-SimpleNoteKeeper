<%-- 
    Document   : editnote
    Created on : 2-Jun-2021, 12:30:46 PM
    Author     : jweit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <form method="post" action="note">
            <h1>Simple Note Keeper</h1>
        <h3>View Note</h3>
        <p>Title: </p>
        <textarea name="Title" value="${note.title}"></textarea>
        <p>Content: </p>
        <textarea name="Content" value="${note.content}"></textarea>
        <br>
        <input type="submit" value="Save Note">
        </form>
        
    </body>
</html>
