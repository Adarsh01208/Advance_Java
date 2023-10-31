/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClobDemo;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author adars
 */
public class InsertTxtFile {
    
    public static void main(String[] args) throws Exception
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo","root","sitaram");
		
        PreparedStatement ps=con.prepareStatement("insert into clobdemo values(?,?)");
        
        ps.setString(1, "adarsh");
        FileReader fr =new FileReader("E:\\tc.txt");
        ps.setCharacterStream(2, fr);
        
        int row_count =ps.executeUpdate();
        if(row_count>0)
        {
            System.out.println("FIle Inserted Sucessfully");
        }
        else
        {
            System.out.println("Unsucessfully");;
        }
        
    }
 
        
}
