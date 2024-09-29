package com.foodapp.model;

public class cartItem {

	private int itemId;
	private int restaurantId;
	private String name;
	private float price;
	private int quantity;
	private float subTotal;
	public cartItem() {
		// TODO Auto-generated constructor stub
	}
	public cartItem(int itemId,int restaurantId, String name, float price, int quantity, float subTotal) {
		super();
		this.itemId=itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
//	@Override
//	public String toString() {
//		System.out.print("%d %-9s %-9f %d %f\n",restaurantId,name,price,quantity,subTotal);
//	}
	@Override
	public String toString() {
		return "itemId=" + itemId + ", restaurantId=" + restaurantId + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity + ", subTotal=" + subTotal;
	}
	
	
	
}
