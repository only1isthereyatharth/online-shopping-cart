package com.dao.shoppingcart;

import com.connection.shoppingcart.DbCon;
import com.model.shoppingcart.*;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao{
	private Connection con;
	private ResultSet rs;
	private static String query;
	private PreparedStatement pstm;
	
	public OrderDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertOrder(Order model) {
//		boolean result = false;
		try {
			query = "insert into databaseshopping.orders(p_id, u_id, o_quantity, o_date) values(?,?,?,?)";
			pstm = this.con.prepareStatement(query);
			pstm.setObject(1, model.getId());
			pstm.setObject(2,model.getUid());
			pstm.setObject(3, model.getQuantity());
			pstm.setObject(4,model.getDate());
			
			if(pstm.executeUpdate()>0) {
				System.out.println("insert Successfull!");
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Order> userOrder(int id){
		List<Order> list = new ArrayList<>();
		
		try {
			query = "select * from databaseshopping.orders where u_id=? order by orders.o_id desc";
			pstm = DbCon.getConnection().prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
//				ProductDao productDao = new ProductDao(this.con);
//                int pId = rs.getInt("p_id");
//                Product product = productDao.getSingleProduct(pId);
				int pId = rs.getInt(id);
				Product product = new ProductDao().getSingleProduct(pId);
				
				order.setId(pId);
				order.setQuantity(rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				order.setCategory(product.getCategory());
				order.setName(product.getName());
				order.setPrice(product.getPrice()*rs.getInt("o_quantity"));
				list.add(order);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
