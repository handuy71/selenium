/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selenium;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 * @author handu
 */
public class input {

    public static void text(WebElement b, String a) {
        b.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        b.sendKeys(a);
    }

    public static String findSixDigitString(String input) {
        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }

    }

    public static String getOTP() {
        String result = "";
        try {
            String host = "imap.gmail.com";
            String user = "email@gmail.com";
            String password = "apppassword";
            // create properties
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            // retrieve the messages from the folder in an array and print it
            Message[] messages = new Message[9999];
            messages = inbox.search(new SubjectTerm("*OTP*"));
            Arrays.sort(messages, (m1, m2) -> {
                try {
                    return m2.getSentDate().compareTo(m1.getSentDate());
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            });
            if (messages.length > 1) {
                messages[1].setFlag(Flags.Flag.DELETED, true);
            }
            // Process only the latest email
            if (messages.length > 0) {
                Message message = messages[0];
//                messages[1].setFlag(Flags.Flag.DELETED, true);//xoá cả mail trước vì lỗi gửi 2 mail
                
                OutputStream out = new ByteArrayOutputStream();
                message.writeTo(out);
                result = findSixDigitString(out.toString());
                message.setFlag(Flags.Flag.DELETED, true);
            }
            inbox.expunge();
            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
        } catch (MessagingException | IOException e) {
        }
        return result;
    }
}
