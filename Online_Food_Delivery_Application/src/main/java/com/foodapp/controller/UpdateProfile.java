package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.Dao.userDao;
import com.foodapp.DaoImpl.userDaoImpl;
import com.foodapp.model.Users;
@WebServlet("/profile")
public class UpdateProfile extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("control reached to profile");
		HttpSession session=req.getSession();
		Users user=(Users)session.getAttribute("loggedInUser");
		int userId=user.getUserId();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String PhoneNumber=req.getParameter("PhoneNumber");
		String password=req.getParameter("password");
		Users u=new Users(name,email,PhoneNumber,password);
		userDao ud=new userDaoImpl();
		System.out.println("control reached to profile");
		int status=ud.updateUser(u,userId);
		if(status==1) {
			resp.sendRedirect("home");
		}
		else {
			resp.sendRedirect("failure.jsp");
		}
	}

}
