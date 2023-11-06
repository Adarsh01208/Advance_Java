/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author adars
 */
public class SelectDemo {
    public static void main(String[] args)  throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
        Statement st=con.createStatement();
        
//        Scanner sc =new  Scanner(System.in);
//        System.out.println("Enter the query");
//        String sql_query=sc.nextLine();
        
          ResultSet rs=st.executeQuery("Select * from register");
        while(rs.next())
        {
            System.out.print(rs.getString(1));
            System.out.print(" ,  "+rs.getString(2));
            System.out.print(" ,  "+rs.getString(3));
            System.out.print(" ,  "+rs.getString(4));
            System.out.print(" ,  "+rs.getString(5));
            System.out.print(" ,  "+rs.getString(6));
            
            
            System.out.println();
        }
    }
}
