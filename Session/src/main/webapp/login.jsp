<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>



    <body>
        <% String username=(String)session.getAttribute("username"); %>

            <% if(username !=null) { %>
                <jsp:forward page="success.jsp"></jsp:forward>
                <% } %>


                    <h1>
                        <%= username %>
                    </h1>
                    <h3>Login</h3>
                    <form action="login" method="POST">
                        Username: <input type="text" name="username" /> <br>
                        Password: <input type="password" name="password" />
                        <button type="submit">Login</button>
                    </form>
    </body>

    </html>