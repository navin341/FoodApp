package com.foodapp.Dao;

import java.util.ArrayList;

import com.foodapp.model.orderItem;

public interface orderItemDao {

	int addItem(orderItem oi);
	ArrayList<orderItem> getAllItems();
	int updateItem(orderItem oi,int orderItemId);
	int deleteItem(int orderItemId);
	ArrayList<orderItem> getItem();
	ArrayList<orderItem> getSpecificItem(int orderId);
}
