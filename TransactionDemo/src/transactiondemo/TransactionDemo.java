/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactiondemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adars
 */
public class TransactionDemo {

    public static void main(String[] args) 
    { 
        Connection con=null;
        
        try
        {
               Class.forName("com.mysql.cj.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","sitaram");
		con.setAutoCommit(false);
               Statement s= con.createStatement();
		
		int rowCount1=s.executeUpdate("insert into items values(101, 'tshirt', 1000)");
		int rowCount2=s.executeUpdate("insert into items values(102, 'jeans', 599)");
		int rowCount3=s.executeUpdate("insert into items values(103, 299, 'top')");
		int rowCount4=s.executeUpdate("insert into items values(104, 'pent', 999)");
		
		if(rowCount1>0 && rowCount2>0 && rowCount3>0 && rowCount4>0)
		{
                        con.commit();
			System.out.println("items added successfully");
		}
		else
		{        con.rollback();
			System.out.println("items insertion failed");
		}
        }
        catch(Exception e)
        {
            try{
                con.rollback();
            }
            catch(SQLException ee)
            {
                System.out.println(ee);
            }
            System.out.println(e);
        }
        
    }
    
}
