package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.orderItemDao;
import com.foodapp.model.orderItem;
import com.foodapp.model.orderTable;
import com.tap.connects.myConnection;

public class orderItemDaoImpl implements orderItemDao
{
    private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet res;
	int status=0;
	ArrayList<orderItem> Items=new ArrayList<>();
	private static final String  CREATE_ORDER_ITEMS="insert into `orderitem`"
			+ "(orderId,menuId,quantity,subTotal) values(?,?,?,?);";
	private static final String GET_ALL_ORDER_ITEMS="select * from `orderitem`;";
	private static final String GET_ORDER_ITEMS_BY_ID="SELECT * FROM `orderitem` WHERE `orderItemId` = (SELECT MAX(orderItemId) "
			+ "FROM orderitem)";
	private static final String UPDATE_ORDER_ITEMS_BY_ID="update `orderitem`"
			+ " set quantity=?,subTotal=? where orderId=?;";
	private static final String DELETE_ORDER_ITEMS_BY_ID="delete from `orderitem` where orderItemId=?";
	private static final String GET_SPECIFIC_ORDERITEMS_BY_ID="select from `orderitem` where `orderId`=?;";
	public orderItemDaoImpl() {
		connection=myConnection.Connect();
	}
	@Override
	public int addItem(orderItem oi) {
		try {
			pstmt=connection.prepareStatement(CREATE_ORDER_ITEMS);
			pstmt.setInt(1, oi.getOrderId());
			pstmt.setInt(2, oi.getMenuId());;
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setFloat(4, oi.getSubTotal());
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<orderItem> getAllItems() {
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(GET_ALL_ORDER_ITEMS);
			Items=extractingResultSetFromOrderItems(res);
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}
		return Items;
	}

	@Override
	public ArrayList<orderItem> getItem() {
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(GET_ORDER_ITEMS_BY_ID);
			Items=extractingResultSetFromOrderItems(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	@Override
	public ArrayList<orderItem> getSpecificItem(int orderId){
		try {
			pstmt=connection.prepareStatement(GET_SPECIFIC_ORDERITEMS_BY_ID);
			pstmt.setInt(1,orderId);
			res=pstmt.executeQuery();
			Items=extractingResultSetFromOrderItems(res);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}

	@Override
	public int updateItem(orderItem oi, int orderItemId) {
		try {
			pstmt=connection.prepareStatement(UPDATE_ORDER_ITEMS_BY_ID);
			pstmt.setInt(1, oi.getQuantity());
			pstmt.setFloat(2,oi.getSubTotal());
			pstmt.setInt(3,orderItemId);
			status=pstmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteItem(int orderItemId) {
		try {
			pstmt=connection.prepareStatement(DELETE_ORDER_ITEMS_BY_ID);
			pstmt.setInt(1,orderItemId);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	ArrayList<orderItem> extractingResultSetFromOrderItems(ResultSet res) {
		try {
			while(res.next()) {
				Items.add(new orderItem(res.getInt("orderId"),
						res.getInt("menuId"),
						res.getInt("quantity"),
						res.getFloat("subTotal")));
			}
	    } 
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
		return Items;
	}

}
