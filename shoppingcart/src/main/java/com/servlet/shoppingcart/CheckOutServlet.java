package com.servlet.shoppingcart;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.connection.shoppingcart.DbCon;
import com.dao.shoppingcart.OrderDao;
import com.model.shoppingcart.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
//			out.println("Inside server check out servlet");
			
			SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			
			User auth = (User)request.getSession().getAttribute("auth");
			@SuppressWarnings("unchecked")
			ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
			
			if(auth!=null && cart_list!=null) {
				for(Cart c : cart_list) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(SDFormat.format(date));
					
					try {
						OrderDao dao = new OrderDao(DbCon.getConnection());
						if(dao.insertOrder(order)) {
							cart_list.clear();
							response.sendRedirect("order.jsp");
						}
						else break;
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					
				}
			}
			else {
				if(cart_list==null)response.sendRedirect("cart.jsp");
				else response.sendRedirect("login.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
