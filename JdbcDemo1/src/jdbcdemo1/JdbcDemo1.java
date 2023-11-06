/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class JdbcDemo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
        
        Statement st=con.createStatement();
        
        Scanner sc =new  Scanner(System.in);
        
        
        System.out.println("Enter the query");
        String sql_query=sc.nextLine();

//       int i= st.executeUpdate("insert into register values('anup','anup@gmail.com','anup123','M','9878789899','Customer')");
//       
//       if(i>0)
//       {
//           System.out.println("Inserted Succesfully");
//       }
//       else
//       {
//           System.out.println("UnSucessfully");
//       }
        
        ResultSet rs=st.executeQuery(sql_query);
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
