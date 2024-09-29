package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.userDao;
import com.foodapp.model.Users;
import com.tap.connects.myConnection;

public class userDaoImpl implements userDao {
	private myConnection mycon;
	private Connection connection;
	private ResultSet res;
	private PreparedStatement pstmt;
	private Statement stmt;
	Users user;
	int status=0;
	ArrayList<Users> userList=new ArrayList<>();
	private static final String ADD_USER="insert into `users`(userName,email,phoneNumber,password,address) values(?,?,?,?,?);";
	private static final String SELECT_ALL="select * from `users`;";
	private static final String SELECT_On_EMAIL="select * from `users` where email=?;";
	private static final String UPDATEUSER_On_EMAIL="update `users` set userName=?,email=?,phoneNumber=?,password=? where userId=?;";
	private static final String DELETE_On_EMAIL="delete from `users` where `email`=?;";
	public userDaoImpl() {
		connection=myConnection.Connect();
	}

	@Override
	public int addUser(Users u) {
		try {
			pstmt=connection.prepareStatement(ADD_USER);
			pstmt.setString(1,u.getUserName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3,u.getPhoneNumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getAddress());
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public ArrayList<Users> getAllUsers() {
		// TODO Auto-generated method stub
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(SELECT_ALL);
			userList=extractResultSetFromUsers(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	@Override
	public Users getUser(String email) {
		try {
			pstmt=connection.prepareStatement(SELECT_On_EMAIL);
			pstmt.setString(1,email);
			res=pstmt.executeQuery();
			userList=extractResultSetFromUsers(res);
			user=userList.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	@Override
	public int updateUser(Users u, int userId) {
		try {
			pstmt=connection.prepareStatement(UPDATEUSER_On_EMAIL);
			pstmt.setString(1,u.getUserName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3,u.getPhoneNumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setInt(5, userId);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public int deleteUser(String email) {
		try {
			pstmt=connection.prepareStatement(DELETE_On_EMAIL);
			pstmt.setString(1, email);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
	ArrayList<Users> extractResultSetFromUsers(ResultSet res) {
		try {
			while(res.next()) {
				user=new Users(res.getInt("userId"),res.getString("userName"),
						res.getString("email"),
						res.getString("phoneNumber"),res.getString("password"),res.getString("address"));
				userList.add(user);
			}
	    } 
		catch (SQLException e) {
		    e.printStackTrace();
	    }
		return userList;
	}


}
