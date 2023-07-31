/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metadatademo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author adars
 */
public class RsMetaData {
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail","root","sitaram");
		
		PreparedStatement ps=con.prepareStatement("select * from items");
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData md=rs.getMetaData();
		
		int no_of_column=md.getColumnCount();
		
//		for(int i=1; i<=no_of_column; i++)
//		{
//			System.out.print(md.getColumnName(i)+"\t");
//			System.out.print(md.getColumnTypeName(i)+"\t");
//			System.out.println(md.getColumnDisplaySize(i));
//		}
		
		for(int i=1; i<=no_of_column; i++)
		{
			System.out.print(md.getColumnName(i)+"\t");
		}
		System.out.println();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
    }
}
