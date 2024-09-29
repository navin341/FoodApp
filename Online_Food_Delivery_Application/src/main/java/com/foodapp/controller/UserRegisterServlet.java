package com.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.Dao.userDao;
import com.foodapp.DaoImpl.userDaoImpl;
import com.foodapp.model.Users;

@WebServlet("/registration")
public class UserRegisterServlet extends HttpServlet
{
	PrintWriter pw;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw=resp.getWriter();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		String phoneNumber=req.getParameter("phoneNumber");
		String address=req.getParameter("address");
		userDao userdao=new userDaoImpl();
		if(password.equals(cpassword)&&password!=null) {
			Users u=new Users(name,email,phoneNumber,password,address);
			int x=userdao.addUser(u);
			if(x==0) {
				resp.sendRedirect("failure.jsp");
			}
			else {
				pw.println("Registration Success"+name);
			}
		}
		else {
			pw.println("password correct ga kottu Mr."+name);
		}
		
	}
}
//<style>
//table{
// background-color:rgb(188, 159, 139);
// padding:30px;
//margin:30px;
//}
// body{
//background-color:rgb(181, 207, 183);
//}
//submit{
//color:violet;
//}
//</style>	
