<%@page import="com.store.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">

<head>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">
	<meta http-equiv="Content-Type" content=text/html; charset="ISO-8859-1">

    <!-- Title Page-->
    <title>Product List</title>
	
	

    <!-- Icons font CSS-->
    <link href="pl1/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="pl1/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="pl1/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="pl1/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="pl1/css/main.css" rel="stylesheet" media="all">
	<meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
	
	<%Employee theEmployee=(Employee)session.getAttribute("employee"); %>
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a style="color:yellow;font-weight:bolder;font-size:30px;"class="navbar-brand">Shopping Store Management</a>
    </div>
    <ul class="nav navbar-nav">
      <li style="color:white;" class="navbar-brand">Welcome <%= theEmployee.getEmployeeName() %>  </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      
      <li><a href="EmployeeController?command=SIGN-OUT"><span class="glyphicon glyphicon-log-in"></span>  Sign Out</a></li>
    </ul>
  </div>
</nav>


    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                
                <div class="card-body">
				<div>
					<form action="add-product.jsp" >
                            <button class="btn btn--radius-2 btn--red" type="submit" value="Add Product" class="add-product-button">Add Items</button>
                        </form>
                        </div>
                    
                    <form action="ProductController" method="get">
                        <input type="hidden" name="command" value="SEARCH" />
                    
                        <div class="form-row">
						<input type="hidden" name="COMMAND" value="SEARCH" />
                            <div class="name">SEARCH PRODUCT</div>
                            <div class="value">
                                <div class="input-group"><br>
                                   <input class="input--style-5" required="required" type="text" name="theSearchName"/>
                         
                            <input class="btn btn--radius-2 btn--red" type="submit" value="Search" class="add-product-button"/>
						</div>
            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div><br><br>
		
		<table class="table-fill">
<thead>
<tr>
    <th>Product Name</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Product Category</th>
    <th>Date Of Manufacture</th>
    <th>Date Of Expiry</th>
    <th>Action</th>
    </tr>
</thead>
<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
    
    <c:url var="updateLink" value="ProductController">
    <c:param name="COMMAND" value="LOAD"/>
    <c:param name="productId" value="${tempProduct.productId}"/>
    
    <c:url var="deleteLink" value="ProductController">
    <c:param name="COMMAND" value="DELETE"/>
    <c:param name="productId" value="${tempProduct.productId}"/>
    </c:url>
    
    </c:url>
<tbody class="table-hover">
<tr>
    <td> ${tempProduct.productName } </td>
	<td> ${tempProduct.quantity } </td>
    <td> ${tempProduct.price } </td>
    <td> ${tempProduct.productCategory } </td>
    <td> ${tempProduct.dateOfManufacture } </td>
    <td> ${tempProduct.dateOfExpiry } </td>
	
    <td><a href="${updateLink}">Update</a>/<a href="${deleteLink}">Delete</a></td>
    </tr>
	  </c:forEach>
</tbody>
</table>
    </div>

	

</body>
</html>