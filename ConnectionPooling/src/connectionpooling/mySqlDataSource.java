/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionpooling;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author adars
 */
public class mySqlDataSource {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
        
//         Class.forName("com.mysql.jdbc.Driver");
//         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","root");
           
        MysqlDataSource ms=new MysqlDataSource();
        
        ms.setURL("jdbc:mysql://localhost:3306/gmail");
        ms.setUser("root");
        ms.setPassword("sitaram");
        
        Connection con = ms.getConnection();
        
        PreparedStatement ps=con.prepareStatement("select * from items");
         ResultSet rs=ps.executeQuery();
         
         while(rs.next())
         {
             System.out.println(rs.getString(1)+","+ rs.getString(2));
         }
         
       con.close();
    }
    
}
