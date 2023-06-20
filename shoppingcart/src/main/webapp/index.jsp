<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.connection.shoppingcart.*,com.model.shoppingcart.User, com.dao.shoppingcart.*, com.product.shoppingcart.*" %>
<%@ page import = "java.util.*" %>
<%
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> list = pd.getALlProducts();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Online Shopping</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navBar.jsp" %>

<!-- Must import Java library before initialization and must use only Static members -->

	<div class="container">
		<div class = "card-header my-3">All Products</div>
		<div class = "row">
			<%if(!list.isEmpty()){ 
				for(Product p : list){
					out.println(p.getCategory());
				}
			}
			%>
			
		</div>
			
		<div class = "col-md-3">
		<div class="card " style="width: 18rem;">
		  <img class="card-img-top" src="product-images/female-shoes.jpg" alt="Card image cap">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <h6 class="price">Price: Rs542</h6>
		    <h6 class = "category">Category: some category</h6>
		    <div class = "mt-3 d-flex justify-content-between">
		    	<a href ="#" class="btn btn-primary">Add to Cart</a>
		    	<a href ="#" class="btn btn-primary">Buy Now</a>
		    </div>
		  </div>
	   	</div>
		
		</div>
	</div>
<% out.println("Hey This code runs fine"); %>

<%@include file = "includes/footer.jsp" %>
</body>
</html>	