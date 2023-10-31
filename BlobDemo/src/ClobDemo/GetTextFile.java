/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClobDemo;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author adars
 */
public class GetTextFile {
    public static void main(String[] args) throws Exception
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lobdemo","root","sitaram");
		
        PreparedStatement ps=con.prepareStatement("select * from clobdemo");
        
         ResultSet rs=ps.executeQuery();
         rs.next();
         
         System.out.println(rs.getString(1));
         
         Reader re=rs.getCharacterStream(2);
         FileWriter fw=new FileWriter("e:\\img\\cc.txt");
         
         int i=0;
		while((i=re.read()) != -1)
		{
			//System.out.print((char)i);
			fw.write((char)i);
		}
		fw.close();
    }
}
