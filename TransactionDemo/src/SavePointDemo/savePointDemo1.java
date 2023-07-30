/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SavePointDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 *
 * @author adars
 */
public class savePointDemo1 
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","sitaram");
		
		con.setAutoCommit(false);
		
		Statement st=con.createStatement();
		
                st.executeUpdate("insert into items values(101, 'jeans', 299)");
		st.executeUpdate("insert into items values(102, 'top', 399)");
		
		Savepoint sp=con.setSavepoint();
		
		st.executeUpdate("insert into items values(103, 'lower', 599)");
		st.executeUpdate("insert into items values(104, 'tshirt', 799)");
		
		//con.releaseSavepoint(sp);
		
		st.executeUpdate("insert into items values(105, 'shirt', 199)");
		
		con.rollback(sp);
		
		con.commit(); 
               
               
    }             
    
       
}

