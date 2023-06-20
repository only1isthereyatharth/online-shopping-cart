package com.servlet.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.shoppingcart.DbCon;


@WebServlet("/user-registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = res.getWriter()){
				out.println("Registration class is opened <br>");
			String full_name = req.getParameter("register-name");
			String email = req.getParameter("register-email");
			String password = req.getParameter("register-password");
			String query = "INSERT INTO databaseshopping.users (name,email,password) values(?,?,?);";
			
			PreparedStatement pstm = DbCon.getConnection().prepareStatement(query);
			pstm.setObject(1, full_name);
			pstm.setObject(2, email);
			pstm.setObject(3, password);
//			pstm.setObje
			if(pstm.executeUpdate()>0)out.println("Successfully inserted");
			else out.println("Failed! please try again later");
			res.sendRedirect("login.jsp");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
