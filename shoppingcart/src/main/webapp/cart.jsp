<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.dao.shoppingcart.*, java.text.DecimalFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf",dcf);
 	ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("cart-list");
		List<Cart> cartProduct = null;
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
	    request.setAttribute("person", auth);
	}
	 if(cart_list!=null){
		ProductDao pd = new ProductDao();
		cartProduct =pd.getCartProduct(cart_list);
		double total = pd.getTotalCartPrice(cart_list);
		
		 request.setAttribute("cart_list",cart_list);  
		 request.setAttribute("total",total);	
	 }
	 else{
		double total = 0.0;
		request.setAttribute("total",total);
	 }
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart page</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navBar.jsp" %>
	<div class ="container">
		<div class = "d-flex py-3"><h3>Total Price : $ ${dcf.format(total)}</h3><a class ="mx-3 btn btn-primary" href="check-out">Check Out</a></div>
	</div>
	<div class ="container">
		<table class="table" style ="display:inline-table; table-layout: fixed;">
  			<thead class="table-info" >
				<tr>
					<th scope ="col" style="width:26%">Name</th>
					<th scope ="col" style="width:20%">Category</th>
					<th scope ="col" style="width:16%">Price</th>
					<th scope ="col">Buy Now</th>
					<th scope ="col" style="width:10%">Cancel</th>
				</tr>  
			</thead>
		  	<tbody>
		  	<%-- <% if(cart_list!=null){ --%>
		  		<c:if test ="${cart_list!=null}" >
		  		<%
		  		for(Cart c: cartProduct){
		  		%>	
		  		<%-- <c:forEach items="${cart_list}" var="c1">
		  			<c:out value="${c1.getId()} "></c:out>:<c:out value="${c1.getName()} Name : ${c1.getPrice()} "></c:out>:<c:out value=" ${c1.getQuantity() }"/> --%>	
		  		
   				<tr>
					<%-- <td><c:out value="${c.getName() }"/></td> --%>
					<td><%= c.getName() %></td>
					<td><%= c.getCategory() %></td>
					<td>$<%= dcf.format(c.getPrice()) %></td>
					<td>
					<form class = "form-inline" action ="order-now" method ="post">
						<input type ="hidden" name ="id" value = "<%=c.getId() %>" class = "form-input">
						<div class = "form-group d-flex  ">
							<a class = "btn btn-xl-btn-incre" href ="incr-decr?action=incr&id=<%= c.getId()%>"><i class = "fas fa-plus-square">+</i></a>
							<input class="form-control" type="text" name = "quantity" value = "<%=c.getQuantity() %>" readonly style="width:22%">
							<a class = "btn btn-xl-btn-decre" href = "incr-decr?action=decr&id=<%= c.getId() %>"><i class = "fas fa-minus-square">-</i></a>
							<!-- <a class ="btn btn-xl btn-primary" >Buy</a> -->
							<button type ="submit" class = "btn btn-xl btn-primary">Buy</button>
						</div>
					</form>
					
					</td>
					<td>
						<a class = "btn btn-sm btn-danger" href ="remove-item-from-cart?id=<%= c.getId()%>">Remove</a>
					</td>
				</tr>
				<%-- </c:forEach> --%> 
		  		<%} %>
		  	 </c:if>
		  	
  			</tbody>
		</table>
		</div>
<%@include file = "includes/footer.jsp" %>
</body>
</html>
