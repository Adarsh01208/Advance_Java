/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metadatademo;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author adars
 */
public class DbMetaData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws Exception
    {
        // TODO code application logic here
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","sitaram");
		
		DatabaseMetaData md=(DatabaseMetaData) con.getMetaData();
		System.out.println(md.getDatabaseProductName());
		System.out.println(md.getDatabaseProductVersion());
		System.out.println(md.getDatabaseMinorVersion());
		System.out.println(md.getDatabaseMajorVersion());
		System.out.println(md.getSQLKeywords());
		System.out.println(md.supportsBatchUpdates());
		System.out.println(md.supportsStoredProcedures());
		System.out.println(md.getStringFunctions());
		System.out.println(md.getNumericFunctions());
    }
    
}
