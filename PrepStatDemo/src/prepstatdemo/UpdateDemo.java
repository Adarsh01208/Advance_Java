/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepstatdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class UpdateDemo 
{
    public static void main(String[] args) throws Exception
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
        
        PreparedStatement ps=con.prepareStatement("update register set phone_no=? where name=?");
		
		Scanner s=new Scanner(System.in);
		
                System.out.println("Enter Phone No : ");
		String phno=s.next();
                
		System.out.println("Enter Name : ");
		String name=s.next();
		
		
		
		
		ps.setString(1, phno);
		ps.setString(2, name);
		
		int rowCount=ps.executeUpdate();
		if(rowCount>0)
		{
			System.out.println("row updated successfully");
		}
		else
		{
			System.out.println("updation failed");
		}
    }
}
