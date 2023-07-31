/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowsetdemo;

import com.sun.rowset.JdbcRowSetImpl;

/**
 *
 * @author adars
 */
public class JdbcRsDemo {
    public static void main(String[] args) throws Exception {
        
         JdbcRowSetImpl rs=new JdbcRowSetImpl();
         
          rs.setUrl("jdbc:mysql://localhost:3306/gmail");
        rs.setUsername("root");
        rs.setPassword("sitaram");
        
        rs.setCommand("select * from register");
        
        rs.execute();
        
        while(rs.next())
        {
            System.out.println(rs.getString(1)+","+ rs.getString(2));
        }
    }
}
