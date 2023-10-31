/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobdemo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author adars
 */
public class InsertImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo","root","sitaram");
		
        PreparedStatement ps=con.prepareStatement("insert into blobdemo values(?,?)");
        
        FileInputStream fis = new FileInputStream("D:\\img2.jpg");
                
        ps.setString(1, "adarsh");
        ps.setBinaryStream(2, fis);
        
        int row_count=  ps.executeUpdate();
        if(row_count>0)
        {
            System.out.println("Image Inserted Sucessfully");
        }
        else
        {
            System.out.println("Unsucessfully");
        }
                
                
    }
    
}
