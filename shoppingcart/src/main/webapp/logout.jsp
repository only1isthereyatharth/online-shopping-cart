<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.*, javax.servlet.*,com.model.shoppingcart.*" %>
<% User auth = (User)request.getSession().getAttribute("auth"); 
	if(auth!=null)request.getSession().setAttribute("auth", auth);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navBar.jsp" %>
	<h1>Hey We Started building project</h1>
<%@include file = "includes/footer.jsp" %>
</body>
</html>