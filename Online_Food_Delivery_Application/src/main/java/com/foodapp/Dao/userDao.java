package com.foodapp.Dao;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.Users;

public interface userDao {

int addUser(Users u);
ArrayList<Users> getAllUsers();
Users getUser(String email);
int deleteUser(String email);
int updateUser(Users u, int userId);
}
