package com.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.orderHistoryDao;
import com.foodapp.Dao.orderItemDao;
import com.foodapp.Dao.orderTableDao;
import com.foodapp.DaoImpl.orderHistoryDaoImpl;
import com.foodapp.DaoImpl.orderItemDaoImpl;
import com.foodapp.DaoImpl.orderTableDaoImpl;
import com.foodapp.model.Users;
import com.foodapp.model.cart;
import com.foodapp.model.cartItem;
import com.foodapp.model.orderHistory;
import com.foodapp.model.orderItem;
import com.foodapp.model.orderTable;
@WebServlet("/checkout12")
public class TablesDataServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		String address=req.getParameter("address");
		String PaymentMethod=req.getParameter("PaymentMethod");
		float total=Float.parseFloat(req.getParameter("total"));
		HttpSession session=req.getSession();
		cart ca=(cart)session.getAttribute("cart");
		Users u=(Users)session.getAttribute("loggedInUser");
		int restaurantId=(int) session.getAttribute("restaurantId");
		orderTable ot=new orderTable(restaurantId,u.getUserId(),total,PaymentMethod);
		orderTableDao otd=new orderTableDaoImpl();
		int status=otd.addOrder(ot);
		if(status==1) {
			ot=otd.getSpecificOrder();
			int orderId=ot.getOrderId();
			for(cartItem cit:ca.getAllItems().values()) {
				int menuId=cit.getItemId();		
				int quantity=cit.getQuantity();
				float subTotal=cit.getSubTotal();
				float price=cit.getPrice();
				orderItemDao oid=new orderItemDaoImpl();
				orderItem oye=new orderItem(orderId,menuId,quantity,subTotal);
				status=oid.addItem(oye);
				if(status==1) {
					ArrayList<orderItem>al=oid.getItem();
					for(orderItem oi:al) {
						int orderItemId=oye.getOrderId();
						orderHistoryDao ohd=new orderHistoryDaoImpl();
						orderHistory oh=new orderHistory(orderItemId,u.getUserId(),total);
						status=ohd.addorderHistory(oh);
						if(status==1) {
							resp.sendRedirect("navin.jsp");
						}
						else {
							resp.sendRedirect("failure.jsp");
						}
					}
				}

			}
		}else {
			pw.println("order not placed");
		}
	}

}
