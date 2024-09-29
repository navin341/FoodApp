package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.lookup.ExtraCompilerModifiers;

import com.foodapp.Dao.orderTableDao;
import com.foodapp.model.Restaurant;
import com.foodapp.model.orderTable;
import com.tap.connects.myConnection;

public class orderTableDaoImpl implements orderTableDao
{
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet res;
	int status=0;
	private orderTable ott;
	ArrayList<orderTable> ordersList=new ArrayList<>();
	private static final String  CREATE_ORDER="insert into `ordertable` "
			+ "(restaurant_Id,userId,totalAmount,paymentMode) values(?,?,?,?);";
	private static final String GET_ALL_ORDERS="select * from `ordertable`;";
	private static final String GET_ORDERS_BY_ID="select * from `orderTable` where orderId=?;";
	private static final String UPDATE_ORDERS_BY_ID="update `orderTable`"
			+ " set totalAmount=?, status=? where orderId=?;";
	private static final String DELETE_ORDERS_BY_ID="delete from `orderTable` where orderId=?";
	private static final String GET_ORDER_TABLE_BY_ID="SELECT * FROM `ordertable` WHERE `orderId` = (SELECT MAX(orderId) "
			+ "FROM ordertable)";

	public orderTableDaoImpl() {
		connection=myConnection.Connect();
	}
	@Override
	public int addOrder(orderTable ot) {
		try {
			pstmt=connection.prepareStatement(CREATE_ORDER);
			pstmt.setInt(1, ot.getRestaurantId());
			pstmt.setInt(2, ot.getUserId());
			pstmt.setFloat(3, ot.getTotalAmount());
			pstmt.setString(4, ot.getPaymentMode());
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<orderTable> getAllOrders() {
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(GET_ALL_ORDERS);
			ordersList=extractingResultSetFromOrderTable(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ordersList;
	}

	@Override
	public ArrayList<orderTable> getOrder(int orderId) {
		try {
			pstmt=connection.prepareStatement(GET_ORDERS_BY_ID);
			res=pstmt.executeQuery();
			ordersList=extractingResultSetFromOrderTable(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	@Override
	public int updateUser(orderTable ot, int orderId) {
		try {
			pstmt=connection.prepareStatement(UPDATE_ORDERS_BY_ID);
			status=pstmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteOrder(int orderId) {
		try {
			pstmt=connection.prepareStatement(DELETE_ORDERS_BY_ID);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	@Override
	public orderTable getSpecificOrder() {
		try {
			pstmt=connection.prepareStatement(GET_ORDER_TABLE_BY_ID);
			res=pstmt.executeQuery();
			ordersList=extractingResultSetFromOrderTable(res);
			ott=ordersList.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ott;
	}
	
	ArrayList<orderTable> extractingResultSetFromOrderTable(ResultSet res) {
		try {
			while(res.next()) {
				ott=new orderTable(res.getInt("orderId"),res.getInt("restaurant_Id")
						,res.getInt("userId"),
						res.getString("orderDate"),res.getFloat("totalAmount"),
						res.getString("status"),res.getString("paymentMode"));
				ordersList.add(ott);
			}
	    } 
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
		return ordersList;
	}

}
