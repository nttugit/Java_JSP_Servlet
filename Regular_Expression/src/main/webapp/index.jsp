<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Index</title>

        <style>
            .error {
                color: red;
            }
        </style>
    </head>

    <body>
        <% String error_amount=request.getAttribute("error_amount") + "" ; error_amount=error_amount.equals("null") ? ""
            : error_amount; String error_phone=request.getAttribute("error_phone") + "" ;
            error_phone=error_phone.equals("null") ? "" : error_phone; String
            error_email=request.getAttribute("error_email") + "" ; error_email=error_email.equals("null") ? "" :
            error_email; String amount=request.getAttribute("amount") + "" ; amount=amount.equals("null") ? "" : amount;
            String phone=request.getAttribute("phone") + "" ; phone=phone.equals("null") ? "" : phone; String
            email=request.getAttribute("email") + "" ; email=email.equals("null") ? "" : email; %>

            <form action="order" method="POST">
                Số lượng cần mua: <input value="<%= amount %>" type="text" name="amount" required />
                <span class="error">
                    <%= error_amount %>
                </span>
                <br />


                Số điện thoại: <input value="<%= phone %>" type="text" name="phone" required />
                <span class="error">
                    <%= error_phone %>
                </span>
                <br>

                Email: <input value="<%= email %>" type="text" name="email" required />
                <span class="error">
                    <%= error_email %>
                </span>
                <br />
                <button type="submit">Đặt hàng</button>
            </form>
    </body>

    </html>