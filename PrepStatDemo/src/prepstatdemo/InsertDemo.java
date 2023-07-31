/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepstatdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author adars
 */
public class InsertDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws Exception
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
        
        PreparedStatement ps = con.prepareStatement("Insert into register values(?,?,?,?,?,?)");
        
        ps.setString(1,"anup");
        ps.setString(2, "anup@gmail.com");
        ps.setString(3, "anup123");
        ps.setString(4, "M");
        ps.setString(5, "1234567878");
        ps.setString(6, "customer");
        
        int row_count= ps.executeUpdate();
        
        if(row_count>0)
        {
            System.out.println("Inserted Successfully");
        }
        else 
        {
            System.out.println("Unsucessfully");
        }
    }
    
}
