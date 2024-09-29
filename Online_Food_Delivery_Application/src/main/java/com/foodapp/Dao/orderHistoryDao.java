package com.foodapp.Dao;

import java.util.ArrayList;
import com.foodapp.model.orderHistory;
public interface orderHistoryDao {

	int addorderHistory(orderHistory oh);
	ArrayList<orderHistory> getAllOrderHistory();
	ArrayList<orderHistory> getOrderHistory(int orderHistoryId);
	int updateOrderHistory(orderHistory oh,int OrderHistoryId);
	int deleteOrderHistory(int OrderHistoryId);
}
