package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.orderHistoryDao;
import com.foodapp.model.orderHistory;
import com.foodapp.model.orderTable;
import com.tap.connects.myConnection;

public class orderHistoryDaoImpl implements orderHistoryDao
{

	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet res;
	int status=0;
	ArrayList<orderHistory> History=new ArrayList<>();
	private static final String  CREATE_ORDERHISTORY="insert into `orderitemhistory` "
			+ "(orderId,userId,totalAmount) values(?,?,?);";
	private static final String GET_ALL_ORDERSHISTORY="select * from `online_food_delivery.orderitemhistory`;";
	private static final String GET_ORDERSHISTORY_BY_USERID="select * from `orderitemhistory` where userId=?;";
	private static final String UPDATE_ORDERSHISTORY_BY_ID="update `online_food_delivery.orderitemhistory`"
			+ " set totalAmount=?, status=? where orderHistoryId=?;";
	private static final String DELETE_ORDERSHISTORY_BY_ID="delete from `online_food_delivery.orderitemhistory` where orderHistoryId=?";

	public orderHistoryDaoImpl() {
		connection=myConnection.Connect();
	}

	@Override
	public int addorderHistory(orderHistory oh) {
		try {
			pstmt=connection.prepareStatement(CREATE_ORDERHISTORY);
			pstmt.setInt(1, oh.getOrderId());
			pstmt.setInt(2,oh.getUserId());
			pstmt.setFloat(3,oh.getTotalAmount());
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<orderHistory> getAllOrderHistory() {
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(GET_ALL_ORDERSHISTORY);
			History=extractingResultSetFromOrderHistory(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return History;
	}

	@Override
	public ArrayList<orderHistory> getOrderHistory(int userId) {
		try {
			pstmt=connection.prepareStatement(GET_ORDERSHISTORY_BY_USERID);
			pstmt.setInt(1,userId);
			res=pstmt.executeQuery();
			History=extractingResultSetFromOrderHistory(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return History;
	}

	@Override
	public int updateOrderHistory(orderHistory oh, int OrderHistoryId) {
		try {
			pstmt=connection.prepareStatement(UPDATE_ORDERSHISTORY_BY_ID);
			pstmt.setFloat(1,oh.getTotalAmount());
			pstmt.setString(2,oh.getStatus());
			pstmt.setInt(3,OrderHistoryId);
			status=pstmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteOrderHistory(int OrderHistoryId) {
		try {
			pstmt=connection.prepareStatement(DELETE_ORDERSHISTORY_BY_ID);
			pstmt.setInt(1, OrderHistoryId);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	ArrayList<orderHistory> extractingResultSetFromOrderHistory(ResultSet res) {
		try {
			while(res.next()) {
				History.add(new orderHistory(res.getInt("orderHistoryId"),res.getInt("orderId"),res.getInt("userId"),
						res.getString("orderDate"),res.getFloat("totalAmount"),res.getString("status")));
			}
	    } 
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
		return History;
	}

}
