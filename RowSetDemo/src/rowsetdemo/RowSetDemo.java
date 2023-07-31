/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowsetdemo;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author adars
 */
public class RowSetDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // TODO code application logic here
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        RowSet rs =RowSetProvider.newFactory().createJdbcRowSet();
        
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
