/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowsetdemo;

import com.sun.rowset.JdbcRowSetImpl;
import java.util.Scanner;

/**
 *
 * @author Deepak
 */
public class JdbcRsDemoUpdate
{
    public static void main(String[] args) throws Exception
    {
        JdbcRowSetImpl rs=new JdbcRowSetImpl();
        
        rs.setUrl("jdbc:mysql://localhost:3306/gmail");
        rs.setUsername("root");
        rs.setPassword("sitaram");
        
        rs.setCommand("select * from items");
        rs.execute();
        
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the value");
        int price =s.nextInt();
        
        rs.absolute(2);
        
        rs.updateInt(3, price);
        rs.updateRow();
    }
}
