package com.geekster.SpringBootAnnotation.email;

import com.geekster.SpringBootAnnotation.TestConfigurationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Component
public class MailHandler {
    @Autowired
    TestConfigurationAnnotation t1;
    public void sendMail()
    {
        Properties sysProperties = System.getProperties(); //this gives me a hash-map/ hash-table

        System.out.println(sysProperties);

        sysProperties.put("mail.smtp.host",MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty,"true");
        sysProperties.put(MailMetaData.authPerm,"true");


        //create a session using sender-email and password
        Authenticator mailAuthenticator = new CustomizedMailAuthentication();
        Session mailSession = Session.getInstance(sysProperties,mailAuthenticator);

        //mime message build

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
//            TestConfigurationAnnotation t1 = new TestConfigurationAnnotation();
            mailMessage.setFrom(MailMetaData.myUserMail);
            mailMessage.setSubject("Java mail testing");
            mailMessage.setText(t1.s);

            //set the receiver

            Address receiverEmail = new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipient(Message.RecipientType.TO, receiverEmail);

            Transport.send(mailMessage);
        }
        catch(Exception mailException)
        {
            System.out.println(mailException.toString());
        }



    }
}
