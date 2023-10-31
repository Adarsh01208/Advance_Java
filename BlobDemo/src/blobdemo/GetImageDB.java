/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobdemo;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author adars
 */
public class GetImageDB 
{
    public static void main(String[] args) throws Exception
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo","root","sitaram");
		
        PreparedStatement ps=con.prepareStatement("select * from blobdemo");
        
        ResultSet rs =ps.executeQuery();
        
        
       while (rs.next())
       {
            System.out.println(rs.getString(1));
        
            FileOutputStream fos=new FileOutputStream("E:\\img\\abc.jpg");
            
            InputStream is = rs.getBinaryStream(2);
            int val=0;
            while((val=is.read()) != -1)
            {
                fos.write(val);
            }
            System.out.println("Image saved sucessfully");
       }
        
        
    }
}
