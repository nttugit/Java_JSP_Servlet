<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>trang 1</title>
    </head>

    <body>
        <% String username=(String)session.getAttribute("username"); %>

            <h1>Xin chào: <%= username %>
                    <h1>trang 1</h1>

                    <form action="logout" action="GET">
                        <button type="submit">Logout</button>
                    </form>
    </body>

    </html>