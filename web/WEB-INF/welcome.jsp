
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
    <center>
        <h2>
        <% 
        
        if(session.getAttribute("login")== null || session.getAttribute("login")==""){
        response.sendRedirect("index.jsp");
        }
        %>
        welcome,<%=session.getAttribute("login")%>
        </h2>
        
    </center>
    </body>
</html>
