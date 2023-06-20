    <%@ page import="java.util.*, javax.servlet.*,com.model.shoppingcart.*" %>
<% User auth = (User)request.getSession().getAttribute("auth"); 
	if(auth!=null)request.getSession().setAttribute("auth", auth);
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="index.jsp">E-Commerce Shopping-Cart</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav"  style ="margin-left:auto">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="cart.jsp">Cart</a>
        </li>
<!--         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li> -->
        <% if(auth!=null) {%>
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="order.jsp">Orders</a><!--tabindex="-1" aria-disabled="true"  nav-link dispabled-->
        </li>
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="log-out">Logout</a>
        </li>
        <%} else{%>
        
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="login.jsp">Login</a>
        </li>
        
        <%} %>
      </ul>
      <!-- <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form> -->
    </div>
  </div>
</nav>