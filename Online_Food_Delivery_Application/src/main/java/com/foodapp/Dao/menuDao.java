package com.foodapp.Dao;

import java.util.ArrayList;
import com.foodapp.model.menu;

public interface menuDao {

	int addMenuItems(menu m);
	ArrayList<menu> getAllMenuItems();
	ArrayList<menu> getMenuItemOnID(int restaurantId);
	int updateMenu(menu m,int menuId);
	int deleteMenu(int menuId);
	menu getRestaurantItemOnID(int itemId);
}
//<!-- <div class="restaurant">
//<img src="<%=r.getImgPath() %>" width="100" height="100">
//<strong><%=r.getRestaurantName() %></strong>
//<p><strong>ID:</strong><%=r.getRestaurantId() %></p>
//<p><strong>Cuisine Type:</strong><%=r.getCuisinetype() %></p>
//<p><strong>Rating:</strong><%=r.getRating() %>*</p>
//<p><strong>Delivery Time:</strong><%=r.getDeliverytime() %> minutes</p>
//<a href="menu?restaurantId=<%=r.getRestaurantId() %>">View Menu</a>
//<input type="hidden" name="RestaurantName" value=<%=r.getRestaurantName() %>>