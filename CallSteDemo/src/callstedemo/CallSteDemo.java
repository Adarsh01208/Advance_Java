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

/**
 *
 * @author adars
 */
public class CallSteDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
        Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail", "root", "sitaram");
		
		CallableStatement cs=con.prepareCall("{call getAllEmpData()}");
		ResultSet rs=cs.executeQuery();
		while(rs.next())
		{
			System.out.println("ID : "+rs.getInt(1));
			System.out.println("Name : "+rs.getString(2));
			System.out.println("Email : "+rs.getString(3));
			System.out.println("Password : "+rs.getString(4));
			System.out.println("Phone No : "+rs.getString(5));
			System.out.println("------------------------------------------------");
		}
		
		con.close();
    }
    
}
