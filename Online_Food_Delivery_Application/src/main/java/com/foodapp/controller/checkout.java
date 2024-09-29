package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.menuDao;
import com.foodapp.Dao.restaurantDao;
import com.foodapp.DaoImpl.menuDaoImpl;
import com.foodapp.DaoImpl.restaurantDaoImpl;
import com.foodapp.model.Restaurant;
import com.foodapp.model.menu;
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menuId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		float subTotal=Float.parseFloat(req.getParameter("subTotal"));
		menuDao md=new menuDaoImpl();
		menu m=md.getRestaurantItemOnID(menuId);
		if(m!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("MenuObject",m);
			int restaurant_Id=m.getRestaurant_Id();
			restaurantDao rd=new restaurantDaoImpl();
			Restaurant rs=rd.getRestaurantById(restaurant_Id);
			if(rs!=null) {
				session.setAttribute("restaurants",rs);
				resp.sendRedirect("checkout.jsp");
			}
		}
		else {
			resp.sendRedirect("failure.jsp");
		}
		
	}

}








//String PaymentMethod=req.getParameter("PaymentMethod");
//HttpSession session=req.getSession();
//Users u=(Users)session.getAttribute("loggedInUser");
//int userId=u.getUserId();
//menuDao md=new menuDaoImpl();
//menu m=md.getRestaurantItemOnID(menuId);
//int restaurant_id=m.getRestaurant_Id();
//orderTable ot=new orderTable(restaurant_id,userId,totalAmount,PaymentMethod);
//orderTableDao otd=new orderTableDaoImpl();
//int status=otd.addOrder(ot);
//if(status==1) {
//	resp.sendRedirect(PaymentMethod);
//}