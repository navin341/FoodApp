package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.orderHistoryDao;
import com.foodapp.DaoImpl.orderHistoryDaoImpl;
import com.foodapp.model.orderHistory;
@WebServlet("/oh")
public class orderHistoryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_Id=Integer.parseInt(req.getParameter("user_Id"));
		orderHistoryDao ohd=new orderHistoryDaoImpl();
		ArrayList<orderHistory>al=ohd.getOrderHistory(user_Id);
		if(al!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("OrderHistory", al);
			resp.sendRedirect("OrderHistory.jsp");
		}
	}

}
