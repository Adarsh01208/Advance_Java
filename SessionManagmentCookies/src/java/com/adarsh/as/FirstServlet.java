/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adarsh.as;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adars
 */
public class FirstServlet  extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       PrintWriter out=resp.getWriter();
       int val=0;
       Cookie ck[]=req.getCookies();
       for(Cookie c:ck)
       {  
           out.println(c.getName()+" : "+c.getValue());
           if(c.getName().equals("status"))
			{
				val=1;
			}
       }
       if(val==1)
       {
           resp.sendRedirect("profile");
       }
       else
       {
           resp.sendRedirect("index.html");
       }
       
    }
    
}
