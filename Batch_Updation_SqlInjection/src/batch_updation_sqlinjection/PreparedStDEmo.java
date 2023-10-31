/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batch_updation_sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author adars
 */
public class PreparedStDEmo 
{
    public static void main(String[] args) throws Exception
    
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","root");
		
		PreparedStatement ps=con.prepareStatement("insert into items values(?,?,?)");
		
		ps.setInt(1, 101);
		ps.setString(2, "jeans");
		ps.setInt(3, 399);
		ps.addBatch();
		
		ps.setInt(1, 102);
		ps.setString(2, "lower");
		ps.setInt(3, 499);
		ps.addBatch();
		
		ps.setInt(1, 103);
		ps.setString(2, "top");
		ps.setInt(3, 599);
		ps.addBatch();
		
		ps.setInt(1, 104);
		ps.setString(2, "aa");
		ps.setInt(3, 499);
		ps.addBatch();
		
		int[] rowCount=ps.executeBatch();
		for(int i:rowCount)
		{
			System.out.println(i+" row manipulated");
		}
    }
}
