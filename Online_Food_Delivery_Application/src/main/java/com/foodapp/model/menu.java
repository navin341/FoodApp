package com.foodapp.model;

public class menu {

	private int menuId;
	private int restaurant_Id;
	private String menuName;
	private float price;
	private String description;
	private boolean isAvailable;
	private String imgPath;
	public menu() {
		
	}
	public menu(int menuId, int restaurant_Id, String menuName, float price, String description, 
			boolean isAvailable,String imgPath) {
		super();
		this.menuId = menuId;
		this.restaurant_Id = restaurant_Id;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	} 
//	public menu(int restaurant_Id, String menuName, float price, String description,
//			String imgPath) {
//		super();
//		this.restaurant_Id = restaurant_Id;
//		this.menuName = menuName;
//		this.price = price;
//		this.description = description;
//		this.imgPath = imgPath;
//	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurant_Id() {
		return restaurant_Id;
	}
	public void setRestaurant_Id(int restaurant_Id) {
		this.restaurant_Id = restaurant_Id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", restaurant_Id=" + restaurant_Id + ", menuName=" + menuName + ", price="
				+ price + ", description=" + description + ", isAvailable=" + isAvailable + ", imgPath=" + imgPath
				+ "]";
	}
	
}
