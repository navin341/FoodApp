package com.foodapp.model;

import com.foodapp.Dao.restaurantDao;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String cuisinetype;
	private int deliverytime;
	private String address;
	private int adminId;
	private double rating;
	private boolean isActive;
	private String imgPath;
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int restaurantId, String restaurantName, String cuisinetype, int deliverytime, String address,
			int adminId, double rating, boolean isActive, String imgPath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.address = address;
		this.adminId = adminId;
		this.rating = rating;
		this.isActive = isActive;
		this.imgPath = imgPath;
	}
	public Restaurant(String restaurantName, String cuisinetype, int deliverytime, String address,
			int adminId, double rating, boolean isActive, String imgPath) {
		super();
		this.restaurantName = restaurantName;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.address = address;
		this.adminId = adminId;
		this.rating = rating;
		this.isActive = isActive;
		this.imgPath = imgPath;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public int getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", cuisinetype="
				+ cuisinetype + ", deliverytime=" + deliverytime + ", address=" + address + ", adminId=" + adminId
				+ ", rating=" + rating + ", isActive=" + isActive + ", imgPath=" + imgPath + "]";
	}
	
	
	

}