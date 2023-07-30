/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adarsh.as;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adars
 */
public class Login extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String uemail=req.getParameter("email1");
		String upass=req.getParameter("pass1");
		
		if(uemail.equals("adarsh@gmail.com") && upass.equals("adarsh123"))
		{
			HttpSession session=req.getSession();
			//get name from database
			String name="adarsh";
			
			//set name in session object
			session.setAttribute("session_name", name);
			
			resp.sendRedirect("Profile");
		}
		else
		{
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<span style='font-size:20px; color: red;'> Login error </span>");
			out.println("</body>");
			out.println("</html>");
		}
    }

    
  

  
}
