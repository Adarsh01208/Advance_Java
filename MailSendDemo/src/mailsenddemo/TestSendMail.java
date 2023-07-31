/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailsenddemo;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author adars
 */
public class TestSendMail 
{
      public static void sendMail(String to_email) throws Exception
    {
         Properties prop = new Properties();
         prop.put("mail.smtp.host", "smtp.gmail.com");
         prop.put("mail.smtp.port", "587");
         prop.put("mail.smtp.auth", "true");
         prop.put("mail.smtp.starttls.enable", "true");
         
         String from_email="from_email_id@gmail.com";
         String from_email_pass="from_email_pass";
         
         
         
         
        Session session=Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("from_email, from_email_pass");
            }    
           
});
          
          //compose message 
          MimeMessage message=new MimeMessage(session);
          message.setFrom(new InternetAddress(from_email));
          message.setRecipient(Message.RecipientType.TO, new  InternetAddress(to_email));
          message.setSubject("hello\\");
          message.setText("this is my First mail through Java Mail Api");
          
          //send the message
          Transport.send(message);
          System.out.println("message Sended Sucessfully");
    } 
}
