 package com.foodapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.menuDao;
import com.foodapp.Dao.restaurantDao;
import com.foodapp.Dao.userDao;
import com.foodapp.DaoImpl.menuDaoImpl;
import com.foodapp.DaoImpl.restaurantDaoImpl;
import com.foodapp.DaoImpl.userDaoImpl;
import com.foodapp.model.Restaurant;
import com.foodapp.model.Users;
import com.foodapp.model.menu;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet
{
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	         String email=req.getParameter("email");
	         String password=req.getParameter("password");
	         System.out.println("control reached 1");
	         userDao ud=new userDaoImpl();
	         Users user=ud.getUser(email);
	  
	 		if(password.equals(user.getPassword())) {
	 			System.out.println("control reached 2");
	 			HttpSession session=req.getSession();
	 			session.setAttribute("loggedInUser", user);
	 			resp.sendRedirect("home");
	 		}else {
	 			resp.sendRedirect("failure.jsp");
	 		}
	 			
   }
//   value=<%=m.getMenuId() %>
}
//<p><%=r.getCuisinetype() %>-<%=r.getDeliverytime() %>mins</p>
//<a href="menu?restaurantId=<%=r.getRestaurantId()%>">View Menu</a>

