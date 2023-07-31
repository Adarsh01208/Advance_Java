/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailsenddemo;

/**
 *
 * @author adars
 */
public class MailSendDemo
{
    public static void main(String[] args) {
         try
        {
            TestSendMail.sendMail("to_email_id@gmail.com");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
    

