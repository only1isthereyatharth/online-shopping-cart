<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file = "includes/header.jsp" %>
</head>
<body style="text-align: center">
<%@include file = "includes/navBar.jsp" %>

	<div class ="container d-flex justify-content-center">
		<div class = "card w-50 mx-atuo my-5">
			<div class = "card-header text-center">User Registration</div>
			<div class = "card-body">
			
				<form action = "user-registration" method ="post">
					<div class ="form-group" >
						<label>Full Name</label>
						<input type ="text" placeholder= "Enter your name" class = "form-control" name = "register-name">
					</div>
					<div class = "form-group">
						<label>Email Address</label>
						<input type="email" placeholder ="lashkarimeyjind@gmail.com" class="form-control" name = "register-email">
					</div>
					
					<div class = "form-group">
						<label>Password</label>
						<input type="password" placeholder="*********" class="form-control" name="register-password">
					</div>
					
					<div class = "text-center">
						<button type ="submit" class = "btn btn-primary">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<h1>Hey We Started building project</h1>
<%@include file = "includes/footer.jsp" %>
</body>
</html>