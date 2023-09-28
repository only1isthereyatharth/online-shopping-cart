<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.text.DecimalFormat, com.model.shoppingcart.*,com.dao.shoppingcart.*, java.util.*, com.connection.shoppingcart.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   <%
   DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
   @SuppressWarnings("unchecked")
	ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");;
	if (cart_list != null) {
		request.setAttribute("cart-list", cart_list);
	}
		
	List<Order> order = Collections.emptyList();	/* Null pointer error se bachne ko */
  	User auth = (User)request.getSession().getAttribute("auth");
  	if(auth!=null){
  		request.setAttribute("auth",auth);
  	  	order = new OrderDao(DbCon.getConnection()).userOrder(auth.getId());
  	}
  	else {
  		response.sendRedirect("login.jsp");
  	}
	
   %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order pagee</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navBar.jsp" %>

<c:if test="${auth!=null}">
   	
   </c:if>
   
   
   
	<div class = "container">
		<div class = "card-header-grey my-3 "> ALL ORDERS
			<table class = "table table-light">
				<thead>
					<tr>
						<th scope="col" >Date</th>
						<th scope="col" >Name</th>
						<th scope="col" >Category</th>
						<th scope="col" >Quantity</th>
						<th scope="col" >Price</th>
						<th scope="col" >Cancel</th>
					</tr>
				</thead>
				<tbody>
				   <c:if test="${order==null}">
				   	<tr> <td>Order cart is empty!</td> </tr>
				   </c:if>
					<c:if test="${order!=null}">
						<%for(Order o: order){ %>
							<tr>
								<td><%=o.getDate() %></td>
								<td><%=o.getName() %></td>
								<td><%=o.getCategory() %></td>
								<td><%=o.getQuantity() %></td>
								<td><%=o.getPrice() %></td>
								<td><a class ="btn btn-sm btn-danger" href="cancel-order?id=<%= o.getId()%>">Cancel</a></td>
							</tr>
						<%} %>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	
	
	<h1>Hey We Started building project</h1>
<%@include file = "includes/footer.jsp" %>
</body>
</html>
