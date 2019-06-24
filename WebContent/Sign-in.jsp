<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<title>Sign-In Page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content=text/html; charset="ISO-8859-1">
	
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="s1/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="s1/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="s1/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="s1/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="s1/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="s1/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="s1/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="s1/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="s1/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="s1/css/util.css">
	<link rel="stylesheet" type="text/css" href="s1/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<% 
              String str=(String)request.getAttribute("msg");
            %><%
              if(str!=null){
            	%> 
            	  <h4 style="color: red;">  <%=str%></h4>
            	  <%
              }
              %>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('s1/a12.jpg');">
			<div class="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
				<form class="login100-form validate-form flex-sb flex-w" action="EmployeeController" method="get">
				<input type="hidden" name="command" value="EMPLOYEE">
					<span class="login100-form-title p-b-53">
						Sign In 
					</span>
					<div class="p-t-31 p-b-9">
						<span class="txt1">
							Employee Id
						</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Username is required">
						<input class="input100" type="text" name="employeeId" required="required" >
						<span class="focus-input100"></span>
					</div>
					
					<div class="p-t-13 p-b-9">
						<span class="txt1">
							Password
						</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="password" required="required" >
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn" type="submit" name="Sign-in">
							Sign In
						</button>
					</div>

					<div class="w-full text-center p-t-55">
						<span class="txt2">
							Not an employee?
						</span>

						<a href="registration.jsp" class="txt2 bo1">
							Register
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	


</body>
</html>