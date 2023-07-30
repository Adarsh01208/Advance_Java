/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adarsh.as;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adars
 */
public class Login extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String email2= req.getParameter("email1");
        String pass2=req.getParameter("pass1");
        String remember2=req.getParameter("remember1");
        
        if(email2.equals("adarsh@gmail.com")&& pass2.equals("adarsh123"))
        {
            if(compare(remember2, "selected"))
			{
				Cookie ck1=new Cookie("username", email2);
				ck1.setMaxAge(60*60*24*365);
				resp.addCookie(ck1);
				
				Cookie ck2=new Cookie("status", "true");
				ck2.setMaxAge(60*60*24*365);
				resp.addCookie(ck2);
			}
			resp.sendRedirect("profile");
        }
        else
        {
            out.println("Email ID And Password Didnt Matched");
            RequestDispatcher rd=req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
    }
    public static boolean compare(String str1, String str2)
	{
		return (str1==null ? str2==null : str1.equals(str2));
	}
    
}
