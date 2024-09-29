package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.menuDao;
import com.foodapp.model.menu;
import com.foodapp.model.orderHistory;
import com.tap.connects.myConnection;

public class menuDaoImpl implements menuDao
{
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet res;
	int status=0;
	private menu m=null;
	ArrayList<menu> menuItems=new ArrayList<>();
	private static final String GET_RESTAURANT_ITEMS_BY_ID="select * from `menu` where menuId=?;";
	private static final String  CREATE_MENU_ITEMS="insert into `menu` "
			+ "(menuName,price,description,isAvailable) values(?,?,?,?);";
	private static final String GET_ALL_MENU_ITEMS="select * from `menu`;";
	private static final String GET_MENU_ITEMS_BY_ID="select * from `menu` where restaurant_Id=?;";
	private static final String UPDATE_MENU_ITEMS_BY_ID="update `menu`"
			+ " set menuName=?,price=?,description=?,isAvailable=? where menuId=?;";
	private static final String DELETE_MENU_ITEMS_BY_ID="delete from `menu` where menuId=?";


	public menuDaoImpl() {
		connection=myConnection.Connect();
	}
	@Override
	public int addMenuItems(menu m) {
		try {
			pstmt=connection.prepareStatement(CREATE_MENU_ITEMS);
			pstmt.setString(1,m.getMenuName());
			pstmt.setFloat(2,m.getPrice());
			pstmt.setString(3,m.getDescription());
			pstmt.setBoolean(4,m.isAvailable());
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<menu> getAllMenuItems() {
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(GET_ALL_MENU_ITEMS);
			menuItems=extractingResultSetFromMenu(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menuItems;
	}

	@Override
	public ArrayList<menu> getMenuItemOnID(int restaurant_Id) {
		try {
			pstmt=connection.prepareStatement(GET_MENU_ITEMS_BY_ID);
			pstmt.setInt(1,restaurant_Id);
			res=pstmt.executeQuery();
			menuItems=extractingResultSetFromMenu(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuItems;
	}
	@Override
	public menu getRestaurantItemOnID(int itemId) {
		try {
			pstmt=connection.prepareStatement(GET_RESTAURANT_ITEMS_BY_ID);
			pstmt.setInt(1,itemId);
			res=pstmt.executeQuery();
			menuItems=extractingResultSetFromMenu(res);
			m=menuItems.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int updateMenu(menu m, int menuId) {
		try {
			pstmt=connection.prepareStatement(UPDATE_MENU_ITEMS_BY_ID);
			pstmt.setString(1,m.getMenuName());
			pstmt.setFloat(2,m.getPrice());
			pstmt.setString(3,m.getDescription());
			pstmt.setBoolean(4,m.isAvailable());
			pstmt.setInt(5,menuId);
			status=pstmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteMenu(int menuId) {
		try {
			pstmt=connection.prepareStatement(DELETE_MENU_ITEMS_BY_ID);
			pstmt.setInt(1, menuId);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	ArrayList<menu> extractingResultSetFromMenu(ResultSet res) {
		try {
			while(res.next()) {
				m=new menu(res.getInt("menuId"),res.getInt("restaurant_Id"),
						res.getString("menuName"),
						res.getFloat("price"),
						res.getString("description"),res.getBoolean(6),res.getString(7));
				menuItems.add(m);
				
			}
	    } 
		catch (SQLException e) {
		e.printStackTrace();
	    }
		System.out.println("menuitems got created");
		return menuItems;
		
	}

}
