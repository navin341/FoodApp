package com.foodapp.Dao;

import java.util.ArrayList;

import com.foodapp.model.orderTable;

public interface orderTableDao {

	int addOrder(orderTable ot);
	ArrayList<orderTable> getAllOrders();
	ArrayList<orderTable> getOrder(int orderId);
	int updateUser(orderTable ot,int orderId);
	int deleteOrder(int orderId);
	orderTable getSpecificOrder();
}
