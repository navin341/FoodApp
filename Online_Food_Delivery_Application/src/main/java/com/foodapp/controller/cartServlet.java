package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.menuDao;
import com.foodapp.DaoImpl.menuDaoImpl;
import com.foodapp.model.cart;
import com.foodapp.model.cartItem;
import com.foodapp.model.menu;
@WebServlet("/cart")
public class cartServlet extends HttpServlet
{
	cartItem cit=null;
	HashMap<Integer,cartItem>map=new HashMap<>();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
	    HttpSession session=req.getSession();
		cart ca=(cart)session.getAttribute("cart");
		System.out.println("control reached to cart");
		if(ca==null) {
			ca=new cart();
//			session.setAttribute("cart",ca);
		}
		if(action.equals("add")) {
			addItemss(req,ca);
		}
		else if(action.equals("update")) {
			updatingItems(req,ca);
		}
		else if(action.equals("remove")) {
			removingItems(req,ca);
		}
//		session.setAttribute("cart",ca);
//		System.out.println("control reached to cart 3");
		resp.sendRedirect("cart.jsp");
	}

	private void addItemss(HttpServletRequest req,cart ca) {
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		HttpSession session=req.getSession();
		menuDao md=new menuDaoImpl();
		menu menuItem=md.getRestaurantItemOnID(itemId);
		session.setAttribute("restaurantId", menuItem.getRestaurant_Id());
		if(menuItem==null) {
		   System.out.println("arraylist empty mowa");
		}
		else {
				cit=new cartItem(menuItem.getMenuId(),menuItem.getRestaurant_Id(),
						menuItem.getMenuName(),
						menuItem.getPrice(),quantity,quantity*menuItem.getPrice());
				ca.addItems(cit);
				req.getSession().setAttribute("cart", ca);
		}
		
	}
	private void updatingItems(HttpServletRequest req,cart ca){
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		 ca.updateItems(itemId, quantity);
		 ca.calculateSubTotal(itemId);
		 req.getSession().setAttribute("cart", ca);
		 System.out.println("Items got updated");
	}
	private void removingItems(HttpServletRequest req, cart ca) {
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		ca.removeItem(itemId);
		req.getSession().setAttribute("cart", ca);
		
	}

}
