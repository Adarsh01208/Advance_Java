/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batch_updation_sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 *
 * @author adars
 */
public class StatementDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","sitaram");
		
		Statement st=con.createStatement();
		
		st.addBatch("insert into items values(101, 'jeans', 699)");
		st.addBatch("insert into items values(102, 'top', 699)");
		st.addBatch("insert into items values(103, 'shirt', 399)");
		st.addBatch("insert into items values(104, 'lower', 299)");
		
		int[] rowCount=st.executeBatch();
		for(int i:rowCount)
		{
			System.out.println(i+" row manipulated");
		}
		
		con.close();
    }
    
}
