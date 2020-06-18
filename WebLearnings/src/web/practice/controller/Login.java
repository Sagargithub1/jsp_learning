package web.practice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.practice.login.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
//		out.println("welcome");
		
		  String uname=request.getParameter("uname"); 
		  String pass=request.getParameter("pass");
		  UserDao dao=new UserDao();
		  if(dao.checkLogin(uname, pass)) {
			  HttpSession session=request.getSession();
			  session.setAttribute("username", uname);
			  response.sendRedirect("welcome.jsp");
		  }
		  else{ 
			  response.sendRedirect("login.jsp"); 
		  }
			 
		 
	}

}
