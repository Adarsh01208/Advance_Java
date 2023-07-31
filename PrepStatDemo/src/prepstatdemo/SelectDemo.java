/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepstatdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author adarss
 * 
 */
public class SelectDemo {
    public static void main(String[] args) throws Exception
    { 
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
        PreparedStatement ps=con.prepareStatement("select * from register where name=?");
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name=s.next();
		
		ps.setString(1, name);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("name : "+rs.getString(1));
			System.out.println("email : "+rs.getString(2));
			System.out.println("password : "+rs.getString(3));
			System.out.println("Gender : "+rs.getString(4));
			System.out.println("Phone no : "+rs.getString(5));
                        System.out.println("Module : "+rs.getString(6));
		}
    }
}
