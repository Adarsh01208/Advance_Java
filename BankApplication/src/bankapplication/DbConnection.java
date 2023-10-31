/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author adars
 */
public class DbConnection {
    static Connection con;
    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","sitaram");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    static Connection getconnection()
    {
        return con;
    }
    
           
}
