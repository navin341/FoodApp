package com.foodapp.DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.restaurantDao;
import com.foodapp.model.Restaurant;
import com.tap.connects.myConnection;
public class restaurantDaoImpl implements restaurantDao
{
	private static final String CREATE_RESTAURANT="insert into `restaurant`"
			+ "(restaurantName,cuisinetype,deliverytime"
			+ ",address,Adminuser_id,rating,isActive,imgpath) values(?,?,?,?,?,?);";
	private static final String GET_ALL_RESTAURANTS="select * from `restaurant`;";
	private static final String GET_RESTAURANTS_BY_ID="select * from `restaurant` where restaurant_Id=?;";
	private static final String UPDATE_RESTAURANTS_BY_ID="update `restaurant`"
			+ " set rating=?,isActive=? where Adminuser_id=?;";
	private static final String DELETE_RESTAURANTS_BY_ID="delete from `restaurant` where Adminuser_id=?";
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet res;
	private Restaurant rs;
	int status=0;
	ArrayList<Restaurant> restaurantList=new ArrayList<>();
	public restaurantDaoImpl() {
		connection=myConnection.Connect();
	}


	@Override
	public int createRestaurant(Restaurant r) {
		try {
			pstmt=connection.prepareStatement(CREATE_RESTAURANT);
			pstmt.setString(1,r.getRestaurantName());
			pstmt.setString(2,r.getCuisinetype());
			pstmt.setInt(3,r.getDeliverytime());
			pstmt.setString(4,r.getAddress());
			pstmt.setInt(5,r.getAdminId());
			pstmt.setDouble(6,r.getRating());
			pstmt.setBoolean(7,r.isActive());
			pstmt.setString(8,r.getImgPath());
			
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Restaurant> getAllRestaurants() {
	        try {
	        	 stmt = connection.createStatement();
	             res = stmt.executeQuery(GET_ALL_RESTAURANTS);
	             restaurantList=extractingResultSetFromRestaurants(res);
	        } catch (SQLException e) {
	            e.printStackTrace();	        }
	        return restaurantList;
	}

	@Override
	public Restaurant getRestaurantById(int restaurant_Id) {
		try {
			pstmt=connection.prepareStatement(GET_RESTAURANTS_BY_ID);
			pstmt.setInt(1, restaurant_Id);
			res=pstmt.executeQuery();
			restaurantList=extractingResultSetFromRestaurants(res);
			rs=restaurantList.get(0);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int updateRestaurant(Restaurant r,int Adminuser_id) {
		try {
			pstmt=connection.prepareStatement(UPDATE_RESTAURANTS_BY_ID);
			pstmt.setDouble(1,r.getRating());
			pstmt.setBoolean(2, r.isActive());
			pstmt.setInt(3, Adminuser_id);
			status=pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteRestaurant(int Adminuser_id) {
		try {
			pstmt=connection.prepareStatement(DELETE_RESTAURANTS_BY_ID);
			pstmt.setInt(1, Adminuser_id);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	ArrayList<Restaurant> extractingResultSetFromRestaurants(ResultSet res) {
		try {
			while(res.next()) {
				Restaurant r=new Restaurant(res.getInt("restaurant_Id"),res.getString("restaurantName"),
						res.getString("cuisineType"),res.getInt("deliverytime"),
						res.getString("address"),res.getInt("adminId"),
						res.getDouble("rating"),res.getBoolean("isActive"),res.getString("imgPath"));
				restaurantList.add(r);
			}
	    } 
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
		return restaurantList;
	}
	

}
