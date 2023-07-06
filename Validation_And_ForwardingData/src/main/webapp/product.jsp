<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Product</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <style>
            body {
                background-color: rgb(240, 238, 238);
            }

            .required_field,
            .error {
                color: red;
            }
        </style>
    </head>

    <body>
        <% String error_productID=request.getAttribute("error_productID") + "" ; String
            productID=request.getAttribute("productID") + "" ; String productName=request.getAttribute("productName")
            + "" ; String productCostPrice=request.getAttribute("productCostPrice") + "" ; String
            productRetailPrice=request.getAttribute("productRetailPrice") + "" ; String
            productExpiredDate=request.getAttribute("productExpiredDate") + "" ; String
            productVAT=request.getAttribute("productVAT") + "" ; String productDesc=request.getAttribute("productDesc")
            + "" ; if(productID==null || productID.equals("null")){ productID="" ; } if(error_productID==null ||
            error_productID.equals("null")){ error_productID="" ; } if(productName==null || productName.equals("null")){
            productName="" ; } if(productCostPrice==null || productCostPrice.equals("null")){ productCostPrice="" ; }
            if(productRetailPrice==null || productRetailPrice.equals("null")){ productRetailPrice="" ; }
            if(productExpiredDate==null || productExpiredDate.equals("null")){ productExpiredDate="" ; }
            if(productVAT==null || productVAT.equals("null")){ productVAT="" ; } if(productDesc==null ||
            productDesc.equals("null")){ productDesc="" ; } %>
            <br>
            <h1 style="text-align: center;"> Nhập sản phẩm</h1>
            <br>
            <div class="container">
                <form class="row g-3 needs-validation" id="productForm" action="save-product">
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label" for="productID">
                                Mã sản phẩm <span class="required_field">*</span>
                            </label>
                            <input value="<%= productID %>" type="text" class="form-control" id="productID"
                                name="productID" required />
                            <span class="error" id="error_productID">
                                <%= error_productID %>
                            </span>

                        </div>
                        <div class="col-6">
                            <label class="form-label" for="productName">
                                Tên sản phẩm <span class="required_field">*</span>
                            </label>
                            <input value="<%= productName %>" type="text" class="form-control" id="productName"
                                name="productName" required />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label" for="productCostPrice">
                                Giá nhập <span class="required_field">*</span>
                            </label>
                            <input value="<%= productCostPrice %>" ype="number" class="form-control"
                                id="productCostPrice" name="productCostPrice" required />
                        </div>
                        <div class="col-6">
                            <label class="form-label" for="productRetailPrice">
                                Giá bán <span class="required_field">*</span>
                            </label>
                            <input value="<%= productRetailPrice %>" type="number" class="form-control"
                                id="productRetailPrice" name="productRetailPrice" required />
                            <span class="error" id="retail_price_error"></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label" for="productExpiredDate">
                                Hạn sử dụng
                            </label>
                            <input value="<%= productExpiredDate %>" type="datetime-local" class="form-control"
                                id="productExpiredDate" name="productExpiredDate" />
                        </div>
                        <div class="col-6">
                            <label class="form-label" for="productVAT">
                                VAT
                            </label>
                            <input value="<%= productVAT %>" type="number" step="0.01" class="form-control"
                                id="productVAT" name="productVAT" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <label class="form-label" for="productDesc">
                                Mô tả sản phẩm
                            </label>
                            <textarea class="form-control" id="productDesc" rows="10" cols="20"
                                name="productDesc"><%= productDesc %></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12" style="text-align: center;">
                            <button class="btn btn-primary" type="submit" id="productSubmitBtn">Lưu sản phẩm</button>
                        </div>
                    </div>
                </form>
            </div>

            <script>
                let productSubmitBtn = document.getElementById("productSubmitBtn");
                let productForm = document.getElementById('productForm');
                let productID = document.getElementById("productID");
                let productRetailPrice = document.getElementById("productRetailPrice");
                function isEmpty(value = "") {
                    return value.length == 0;
                }

                // productSubmitBtn.addEventListener('click', (e) => {
                //     e.preventDefault();
                //     if (isEmpty(productID.value)) {
                //         alert("oh no    ")
                //         return;
                //     }

                //     if (Number(productRetailPrice.value) < 0) {
                //         document.getElementById('retail_price_error').innerHTML = "Giá bán phải >= 0"
                //         return;
                //     } else {
                //         document.getElementById('retail_price_error').hidden = true;

                //     }

                //     productForm.submit();
                // })
            </script>

            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
                integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
                crossorigin="anonymous"></script>
    </body>

    </html>