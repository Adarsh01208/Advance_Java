/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class ExecuteDemo {
    public static void main(String[] args) throws Exception
    {
                Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
		
		Statement st=con.createStatement();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter SQL Query :");
		String sql_query=s.nextLine();
		
		boolean b=st.execute(sql_query);
		if(b)
		{
			ResultSet rs=st.getResultSet();
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print(", "+rs.getString(2));
				System.out.print(", "+rs.getString(3));
				System.out.print(", "+rs.getString(4));
				System.out.print(", "+rs.getString(5));
				System.out.println();
			}
		}
		else
		{
			int rowCount=st.getUpdateCount();
			if(rowCount==0)
			{
				System.out.println("failed");
			}
			else
			{
				System.out.println("success");
			}
		}
    }
}
