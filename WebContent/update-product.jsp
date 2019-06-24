<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">
	<meta http-equiv="Content-Type" content=text/html; charset="ISO-8859-1">

    <!-- Title Page-->
    <title>Update Product</title>

    <!-- Icons font CSS-->
    <link href="up1/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="up1/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="up1/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="up1/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="up1/css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50" >
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">UPDATE PRODUCTS</h2>
                </div>
                <div class="card-body">
                    <form action="ProductController" method="get">
					<input type="hidden" name="COMMAND" value="UPDATE">
					<input type="hidden" name="productId" value="${PRODUCT.productId}">
						<div class="form-row">
                            <div class="name">Product Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="productName" value="${PRODUCT.productName}" required="required" placeholder="Product Name">
                                </div>
                            </div>
                        </div>
						<div class="form-row">
                            <div class="name">Quantity Available</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="quantity" value="${PRODUCT.quantity}" required="required" placeholder="Quantity">
                                </div>
                            </div>
                        </div>
						<div class="form-row m-b-55">
                            <div class="name">Price</div>
                            <div class="value">
										<div class="input-group-desc">
                                            <input class="input--style-5" type="number" name="price" value="${PRODUCT.price}" required="required" placeholder="Price">
                                        </div>
                                    
                                
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">Date of Manufacture :</div>
                            <div class="value">
                                
                                    
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="date" name="dateOfManufacture" value="${PRODUCT.dateOfManufacture}" required="required" placeholder="Date Of Manufacture">
                                           
										</div>
                                   
                            </div>
							</div>
							<div class="form-row m-b-55">
                            <div class="name">Date of Expiry:</div>
                            <div class="value">
                                
                                    
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="date" name="dateOfExpiry" value="${PRODUCT.dateOfExpiry}" placeholder="Date Of Expiry" required="required">
                                            
										</div>
                                   
                            </div>
							</div>
                        
                        
                        <div class="form-row">
                            <div class="name">Location</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="location">
                                            <option disabled="disabled" selected="selected">Choose option</option>
                                            <option>chandigarh</option>
                                            <option>delhi</option>
                                            <option>mumbai</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
						
						<div class="form-row">
                            <div class="name">Product Category</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="productCategory">
                                            <option disabled="disabled" selected="selected">Choose option</option>
                                            <option>health care</option>
                                            <option>packaged food</option>
                                            <option>cosmetics</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
						<div class="form-row">
                            <div class="name">Products Sub Category</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="productSubCategory">
                                            <option disabled="disabled" selected="selected">Choose option</option>
                                            <option>medicine</option>
                                            <option>facewash</option>
                                            <option>chips</option>
											<option>drinks</option>
											<option>face creams</option>
											<option>deodrants</option>
											<option>makeup material</option>
										
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit" name="save" value="save">Save</button>
						
               </div>
                    </form><br>
					<a href="ProductController"><button class="btn btn--radius-2 btn--red"  >Back to List</button></a>
				</div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="up1/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="up1/vendor/select2/select2.min.js"></script>
    <script src="up1/vendor/datepicker/moment.min.js"></script>
    <script src="up1/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="up1/js/global.js"></script>

</body>

</html>
