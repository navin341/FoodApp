package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.menuDao;
import com.foodapp.DaoImpl.menuDaoImpl;
import com.foodapp.model.menu;
@WebServlet("/menu")
public class fetchingMenu extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid=Integer.parseInt(req.getParameter("restaurantId"));
		String RestaurantName=req.getParameter("RestaurantName");
		menuDao md=new menuDaoImpl();
		HttpSession session=req.getSession();
		session.setAttribute("restaurantId", rid);
		ArrayList<menu>al=md.getMenuItemOnID(rid);
		if(al!=null) {
			session.setAttribute("RestaurantName",RestaurantName);
			session.setAttribute("menu",al);
			System.out.println("menu object added in session");
			resp.sendRedirect("menu.jsp");
		}
	}

}
