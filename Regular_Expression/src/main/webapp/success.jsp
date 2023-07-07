<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Your order</title>
    </head>

    <body>
        <% String productName="Banh Futsal 2030" ; String amount=request.getParameter("amount") + "" ; String
            phone=request.getParameter("phone") + "" ; String email=request.getParameter("email") + "" ; %>
            <h1>Bạn đã đặt hàng thành công. Đơn hàng của bạn:</h1>
            Tên sản phẩm: <h3>
                <%= productName %>
            </h3>
            Số lượng: <h3>
                <%= amount %>
            </h3>
            Số điện thoại đặt hàng: <h3>
                <%= phone %>
            </h3>
            Email: <h3>
                <%= email %>
            </h3>

    </body>

    </html>