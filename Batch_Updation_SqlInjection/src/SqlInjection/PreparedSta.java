/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class PreparedSta 
{
    
	public static void main(String[] args) throws Exception
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter email id : ");
		String email1=s.nextLine();
		System.out.println("Enter Password : "); 
  		String pass1=s.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail", "root", "sitaram");
		
		PreparedStatement ps=con.prepareStatement("select name from login where email=? AND password=?");
		
		ps.setString(1, email1);
		ps.setString(2, pass1);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println("============================");
			System.out.println("Hi : "+rs.getString(1));
		}
		else
		{
			System.out.println("Email ID & Password Didnt Matched");
		}
	}
        
}
