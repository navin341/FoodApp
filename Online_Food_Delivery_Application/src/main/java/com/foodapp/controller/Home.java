package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.restaurantDao;
import com.foodapp.DaoImpl.restaurantDaoImpl;
import com.foodapp.model.Restaurant;

@WebServlet("/home")
public class Home extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		restaurantDao rd=new restaurantDaoImpl();
		ArrayList<Restaurant>al=rd.getAllRestaurants();
		HttpSession session=req.getSession();
		session.setAttribute("allRestaurants", al);
		resp.sendRedirect("Home.jsp");
		}

}
