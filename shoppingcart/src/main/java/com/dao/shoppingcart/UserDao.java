package com.dao.shoppingcart;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.model.shoppingcart.*;

public class UserDao {
	private Connection con ;
	private String query;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		
		try{
			query = "select * from databaseshopping.users where email = ? and password = ?"; // sql injection ke through koi bhi information na nikale
			pstm = this.con.prepareStatement(query);							// isliye ? daala nhi toh sidha apn email and password pass karwa dete.
			pstm.setString(1,email);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
//	For security purpose we don't return here
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User userRegistration(String name, String email, String password) {
		User user = null;
		try {
			query = "insert into databaseshopping.users values(?,?,?,?)"; 
			pstm = this.con.prepareStatement(query);
			pstm.setString(2, name);
			pstm.setString(3, email);
			pstm.setString(4, password);
			
			if(pstm.execute()) {
				return user;
			}
			else {
				System.out.println("Exception occured! please try with different email.");
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
