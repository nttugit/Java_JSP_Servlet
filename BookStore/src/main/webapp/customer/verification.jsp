<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Laozi Book | Xác minh tài khoản</title>
        <link rel="icon" type="image/x-icon" href="./img/green-book-icon.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.7.0.js"
            integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>

        <style>
            body {
                background-color: rgb(236, 238, 240);
            }

            .red {
                color: red;
            }

            #logoutBtn a {
                text-decoration: none;
                color: white;
            }

            /* .dropdown-menu>li>a {
					-webkit-transform: rotateY(180deg);
				} */
            .avatar_href_wrapper {
                padding: 5px;
            }

            #customerAvatar {
                width: 30px;
                height: 30px;
                border-radius: 50%;
            }

            .verify_area {
                width: 50%;
                margin: auto;
                padding: 20px;
            }

            .verify_area_image img {
                max-height: 70vh;
            }
        </style>
    </head>

    <body>


        <!-- Header -->
        <%@ include file="/layout/header.jsp" %>


            <% String verifyMsg=(request.getAttribute("verifyMsg") !=null) ? request.getAttribute("verifyMsg") + "" : ""
                ; String verifyError=(request.getAttribute("verifyError") !=null) ? request.getAttribute("verifyError")
                + "" : "" ; String resendMsg=(request.getAttribute("resendMsg") !=null) ?
                request.getAttribute("resendMsg") + "" : "" ; String customerID=(request.getParameter("customerID")
                !=null) ? request.getParameter("customerID") + "" : null ;%>
                <% if (customerID==null) { String redirectURL=path + "/" ; response.sendRedirect(redirectURL); } %>

                    <!-- Page content -->
                    <div class="container verify_area">

                        <form action="<%= path %>/customer" class="form" method="POST">
                            <h3>Xác minh tài khoản</h3>
                            <input type="hidden" name="action" value="resendVerificationCode">
                            <input type="hidden" name="customerID" value="<%= customerID %>">

                            <% if(resendMsg.length() !=0) { %>
                                <div class="red" id="resendMsg">
                                    <%=resendMsg%>
                                </div>
                                <% } else {%>

                                    <% if(verifyMsg.length() !=0) { %>
                                        <div class="red" id="verifyMsg">
                                            <%=verifyMsg%>
                                        </div>
                                        <% }else{ %>
                                            <div class="red" id="verifyMsg">
                                                <%=verifyError%>
                                                    Hãy bấm "Gửi" để nhận đường liên kết xác thực mới
                                            </div>
                                            <br>

                                            <button type="submit" class="btn btn-success" id="submitBtn">
                                                Gửi</button>
                                            <% }%>

                                                <% }%>
                        </form>

                        <div class="verify_area_image">
                            <img src="<%=path%>/img/bia-sach-ton-tu.png" alt="">
                        </div>

                    </div>

                    <!-- Footer -->
                    <%@ include file="../layout/footer.jsp" %>

                        <!-- Login modal -->
                        <%@ include file="../loginModal.jsp" %>



    </body>

    </html>