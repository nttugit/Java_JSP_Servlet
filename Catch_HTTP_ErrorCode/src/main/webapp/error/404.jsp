<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>


    <body>
        <% String path=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath(); %>
            <div>
                <h1>404 Not found</h1>
                <h1>Back to <a href="<%= path %>">home page</a></h1>


                <img src="https://drudesk.com/sites/default/files/2018-02/404-error-page-not-found.jpg" width="50%"
                    height="50%" alt="">

                <img src="<%= path %>/img/404-notfound.jpg" width="50%" height="50%" alt="">
            </div>
    </body>

    </html>