/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callstedemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class SecondDemo {
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail", "root", "sitaram");
		
		CallableStatement cs=con.prepareCall("{call getEmpData(?)}");
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter ID : ");
		int empid=s.nextInt();
		
		cs.setInt(1, empid);
		ResultSet rs=cs.executeQuery();
		System.out.println("-----------------------------------");
		while(rs.next())
		{
			System.out.println("Name : "+rs.getString(1));
			System.out.println("Email : "+rs.getString(2));
			System.out.println("Phone No : "+rs.getString(3));
		}
		
		con.close();
    }
}
