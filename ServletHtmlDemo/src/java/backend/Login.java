/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adars
 */
public class Login  extends HttpServlet
{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        
        String email2=req.getParameter("email1");
        String pass2=req.getParameter("pass1");
        
        if(email2.equals("adarsh@gmail.com") && pass2.equals("adarsh123"))
        {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<span style='font-size:20px; color: green'> Login Success </span>");
            out.println("</body>");
            out.println("</html>");
        }
        else
        {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<span style='font-size:20px; color: red'> Login Failed </span>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
