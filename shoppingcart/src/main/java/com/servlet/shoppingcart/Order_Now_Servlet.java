package com.servlet.shoppingcart;
import com.model.shoppingcart.Cart;
import com.model.shoppingcart.Order;
import com.connection.shoppingcart.DbCon;
import com.dao.shoppingcart.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.model.shoppingcart.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order_Now_Servlet
 */
@WebServlet("/order-now")
public class Order_Now_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			SimpleDateFormat SDFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			
			User user = (User)request.getSession().getAttribute("auth");
			if(user!=null) {
				int id = Integer.parseInt(request.getParameter("id"));
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				
				Order order = new Order(id,user.getId(),productQuantity,SDFormat.format(date));
				OrderDao dao = new OrderDao(DbCon.getConnection());
				
				if(dao.insertOrder(order)){
					@SuppressWarnings("unchecked")
					ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
					if(cart_list!=null) {
						for(Cart c: cart_list) {
							if(c.getId()==id) {
								cart_list.remove(c);
								break;
							}
						}
					}
					response.sendRedirect("order.jsp");
				}
				else {
				response.getWriter().println("Order Failed!!");}	
			}
			else 
				response.sendRedirect("login.jsp");			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
