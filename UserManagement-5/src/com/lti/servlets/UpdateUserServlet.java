package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.Users;
import com.lti.service.UserServiceImpl;


public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String mobilenumber = request.getParameter("mobilenumber");
		UserServiceImpl service = new UserServiceImpl();
		
		Users user =new Users(username,null,firstname,lastname,mobilenumber);
		
		boolean result = service.updateUser(user);
		
		PrintWriter out = response.getWriter();
		
		if(result)
		{
			out.println("User with username "+username+" updated");
			response.sendRedirect("showUsers.view");
		}
		
		
	}

	

}
