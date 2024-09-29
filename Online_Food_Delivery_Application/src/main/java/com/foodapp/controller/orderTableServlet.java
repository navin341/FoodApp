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

import com.foodapp.Dao.orderItemDao;
import com.foodapp.DaoImpl.orderItemDaoImpl;
import com.foodapp.model.orderItem;

@WebServlet("/orderNumber")
public class orderTableServlet extends HttpServlet {
	PrintWriter pw;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderId=Integer.parseInt(req.getParameter("orderId"));
		pw=resp.getWriter();
		orderItemDao oid=new orderItemDaoImpl();
		ArrayList<orderItem>al=oid.getSpecificItem(orderId);
		if(al!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("OrderItems", al);
			System.out.println("items added properly");
			resp.sendRedirect("OrderTable.jsp");
			
		}
		else {
			pw.println("arraylist is empty");
		}
	}

}
