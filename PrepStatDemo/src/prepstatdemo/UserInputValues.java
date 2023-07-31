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
public class UserInputValues
{
    public static void main(String[] args) throws Exception
    {
           Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
        
        PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?)");
		
		Scanner s=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Name : ");
			String name = s.next();
		
			System.out.println("Enter Email : ");
			String email=s.next();
			
			System.out.println("Enter Password : ");
			String pass=s.next();
			
			System.out.println("Enter Gender : ");
			String gen=s.next();
			
			System.out.println("Enter Phone No : ");
			String phno=s.next();
                        
                        System.out.println("Enter Module : ");
			String Module=s.next();
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, gen);
			ps.setString(5, phno);
                        ps.setString(6, Module);
			
			int rowCount=ps.executeUpdate();
			if(rowCount>0)
			{
				System.out.println("values inserted successfully");
			}
			else
			{
				System.out.println("values insertion failed");
			}
			
			System.out.println("-------------------------------------------");
			
			System.out.println("Do you want to insert another values ? (y,n)");
			String yn=s.next();
			if(yn.equals("y"))
			{
				continue;
			}
			else
			{
				break;
			}
		}
    }
}
