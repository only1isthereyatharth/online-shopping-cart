<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart Page</title>
<%@include file = "includes/header.jsp" %>
</head>
<body">
<%@include file = "includes/navBar.jsp" %>

	<div class ="container d-flex justify-content-center">
		<div class = "card w-50 mx-atuo my-5">
			<div class = "card-header text-center">User Login</div>
			<div class = "card-body">
			
				<form action = "user-login" method ="post">
					<div class = "form-group">
						<label>Email Address</label>
						<input type="email" placeholder ="lashkarimeyjind@gmail.com" class="form-control" name = "login-email">
					</div>
					
					<div class = "form-group">
						<label>Password</label>
						<input type="password" placeholder="*********" class="form-control" name="login-password">
					</div>
					
					<div class = "text-center">
						<button type ="submit" class = "btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<h1  style="text-align: center">Hey We Started building project</h1>
<%@include file = "includes/footer.jsp" %>
</body>
</html>