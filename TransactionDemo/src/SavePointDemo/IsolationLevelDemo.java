/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SavePointDemo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author adars
 */
public class IsolationLevelDemo {
    public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","sitaram");
		
		System.out.println(con.getTransactionIsolation());
		
		con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		System.out.println(con.getTransactionIsolation());
	}
}
