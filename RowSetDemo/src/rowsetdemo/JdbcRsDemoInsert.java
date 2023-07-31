/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowsetdemo;

import com.sun.rowset.JdbcRowSetImpl;

/**
 *
 * @author Deepak
 */
public class JdbcRsDemoInsert
{
    public static void main(String[] args) throws Exception
    {
        JdbcRowSetImpl rs=new JdbcRowSetImpl();
        
        rs.setUrl("jdbc:mysql://localhost:3306/gmail");
        rs.setUsername("root");
        rs.setPassword("sitaram");
        
        rs.setCommand("select * from items");
        rs.execute();
        
        rs.moveToInsertRow();
        
        int id=103;
        String itemname="lower";
        int price=588;
        
        rs.updateInt(1, id);
        rs.updateString(2, itemname);
        rs.updateInt(3, price);
        
        rs.insertRow();
        System.out.println("Values inserted successfully");
    }
}
