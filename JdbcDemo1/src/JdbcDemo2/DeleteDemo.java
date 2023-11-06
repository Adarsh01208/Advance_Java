/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcDemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author adars
 */
public class DeleteDemo {
    public static void main(String[] args) throws Exception
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","sitaram");
        Statement st=con.createStatement();
        
//        Scanner sc =new  Scanner(System.in);
//        System.out.println("Enter the query");
//        String sql_query=sc.nextLine();
        
        int i= st.executeUpdate("Delete from register where name='anup'");
       
       if(i>0)
       {
           System.out.println("Deleted Succesfully");
       }
       else
       {
           System.out.println("UnSucessfully");
       }
    }
    
}
