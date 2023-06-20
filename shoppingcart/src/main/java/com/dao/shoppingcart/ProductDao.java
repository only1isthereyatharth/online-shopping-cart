package com.dao.shoppingcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.product.shoppingcart.*;
import java.util.List;
import java.util.ArrayList;


public class ProductDao {
	private Connection con;
	private ResultSet rs;
	private String query;
	private PreparedStatement pstm;
	
	public ProductDao(Connection con) {
		this.con = con;
	}
	
	public List<Product> getALlProducts(){
		List<Product> list = new ArrayList<>();
		try {
			query ="SELECT * FROM databaseshopping.products;";
			pstm  =  this.con.prepareStatement(query);
			rs = pstm.getResultSet();
			while(rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setImage(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getString("price"));
				row.setImage(rs.getString("image"));
				list.add(row);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list; 
	}
}
