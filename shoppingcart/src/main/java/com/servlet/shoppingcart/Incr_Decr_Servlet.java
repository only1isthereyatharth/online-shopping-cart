package com.servlet.shoppingcart;

import java.io.IOException;
import com.model.shoppingcart.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
/**
 * Servlet implementation class Incr_Decr_Servlet
 */
@WebServlet("/incr-decr")
public class Incr_Decr_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println(request.getParameter("action"));
		
		ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
		
		if(action!=null && id>0) {
			if(action.equals("incr")) {
				for(Cart c: cart_list) {
					if(c.getId()==id) {
						int quantity = c.getQuantity();
						quantity++;
						c.setQuantity(quantity);
						response.sendRedirect("cart.jsp");
					}
				}
			}
		
			
			else if(action.equals("decr")) {
				for(Cart c: cart_list) {
					if(c.getId()==id && c.getQuantity()>1) {
						int quantity = c.getQuantity();
						quantity--;
						c.setQuantity(quantity);
						break;
					}
				}

				response.sendRedirect("cart.jsp");
			}
			else {
				response.sendRedirect("cart.jsp");
			}
		}
		
		
	}

}
