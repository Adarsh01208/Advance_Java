/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callstedemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class ThirdDemo {
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail", "root", "sitaram");
		
		CallableStatement cs=con.prepareCall("{call getEmpName(?,?)}");
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter ID : ");
		int empid=s.nextInt();
		
		cs.setInt(1, empid);
		
		System.out.println("----------------------");
		
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		System.out.println("Name : "+cs.getString(2));
		
		con.close();
		
    }
}
