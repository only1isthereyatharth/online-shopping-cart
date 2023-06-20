package com.servlet.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.shoppingcart.DbCon;
import com.dao.shoppingcart.UserDao;
import com.model.shoppingcart.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*Because of Security */res.sendRedirect("login.jsp");/*If some try to access our data using url we can redirect him login page*/
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = res.getWriter()){
				out.println("LoginServlet class is opened <br>");
			String email = req.getParameter("login-email");
			String password = req.getParameter("login-password");
			
			UserDao udao = new UserDao(DbCon.getConnection());
			User user = udao.userLogin(email, password);
			
			if(user!=null) {
				out.print("User login successfull");
				req.getSession().setAttribute("auth",user);
				res.sendRedirect("index.jsp");
			}
			else {
				out.println("User login Failded!<br>");
//				out.println("");
//				res.fo("");
//				RequestDispatcher rd = req.getRequestDispatcher("registration_redirect");
//				rd.forward(req, res);
//				user = udao.userRegistration(req.getParameter("name"),req.getParameter("email"), req.getParameter("password"));
				res.sendRedirect("registration.jsp");
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
