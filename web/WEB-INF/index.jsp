

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <form method="post" action="LoginController" name="LoginForm" onsubmit="return validate();">
            Username: <input type="text" name="txt_username">
            Password: <input type="password" name="txt_password">
            
            <input type="submit" name="btn_login" value="Login">
            
            <h3>You don't have a account? <a href="register.jsp">Register</a>"</h3>
            
        </form>
    </body>
</html>
