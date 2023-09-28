package com.model.shoppingcart;

public class Order extends Product{

	private int id;
	private int uid;
	private int quantity;
	private String date;
	
	public Order() {}
	
	

	public Order(int id, int uid, int quantity, String data) {
		super();
		this.id = id;
		this.uid = uid;
		this.quantity = quantity;
		this.date = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", quantity=" + quantity + ", date=" + date + "]";
	}
}
