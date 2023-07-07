<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <% String username=(String)session.getAttribute("username"); %>

            <h1>Xin chào: <%= username %>
            </h1>

            <h1>Đây là trang chào mừng </h1>
            <a href="trang1.jsp">Trang 1</a> |
            <a href="trang2.jsp">Trang 2</a> |
            <a href="trang3.jsp">Trang 3</a>

            <form action="logout" action="GET">
                <button type="submit">Logout</button>
            </form>
    </body>

    </html>