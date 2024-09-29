package com.foodapp.Dao;

import java.util.ArrayList;

import com.foodapp.model.Restaurant;

public interface restaurantDao {
	int createRestaurant(Restaurant r);
	ArrayList<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int restaurant_Id);
	int updateRestaurant(Restaurant r, int Adminuser_id);
	int deleteRestaurant(int Adminuser_id);
	
}
