/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.nio.file.FileVisitResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author adars
 */
public class BankApplication
{
     Scanner s ;
     
    public static void main(String[] args)
    {
        
    
         BankApplication ba=new BankApplication();
         ba.startBankApp();
    }
         
        void startBankApp()
        {
                System.out.println("\n================================");
		System.out.println("1. Add Account");
		System.out.println("2. Fund Transfer");
		System.out.println("3. Mini Statement");
		System.out.println("4. Exit");
		
                System.out.println("\n================================");
                getUserInput();
        }
        
         void getUserInput()
        {
            s =new Scanner(System.in);
            int user_input=s.nextInt();
         
            if(user_input==1)
            {
            // System.out.println("Add account");
             addAccount();
            }
            else if(user_input==2)
            {
               fundTransfer();
            }
            else if(user_input==3)
            {
               miniStatement();
            }
            else
            {
               System.out.println("Bank App Closed");
               System.exit(0);
            }  
        }
        
        void addAccount()
        {
            s=new Scanner(System.in);
            System.out.println("Enter ID :");
            int id=s.nextInt();
            
            System.out.println("Enter Name :");
            String name= s.next();
            
            System.out.println("Enter Email :");
            String email=s.next();
            
            System.out.println("Enter phone_no :");
            String phno=s.next();
                    
            System.out.println("Enter Account No :");     
            int accno=s.nextInt();
            
            Connection con=null;
            try
            {
                 con= DbConnection.getconnection();
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","sitaram");
                PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?)");
                
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.setString(4, phno);
                ps.setInt(5, accno);
                
                int row_count =ps.executeUpdate();
                if(row_count>0)
                {
                    System.out.println("Account Created Sucessfully");
                }
                else
                {
                    System.out.println("Account Not Created Due To Some Error");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            startBankApp();
        }
        void fundTransfer()
	{
		System.out.println("fund transfer");
                
		startBankApp();
	}
	void miniStatement()
	{
		System.out.println("mini statement");
                
		startBankApp();
	}
        
}
    

    

