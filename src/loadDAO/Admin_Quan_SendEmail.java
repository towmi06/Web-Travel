package loadDAO;

import entity.Admin_Quan_MailConfig;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Admin_Quan_SendEmail {

    public static int sendEmailTo(String recipientEmail) {
        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", Admin_Quan_MailConfig.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", Admin_Quan_MailConfig.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", Admin_Quan_MailConfig.SSL_PORT);

        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Admin_Quan_MailConfig.APP_EMAIL, Admin_Quan_MailConfig.APP_PASSWORD);
            }
        });

        try {
            // Compose message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Admin_Quan_MailConfig.APP_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Cảm ơn bạn đã gửi thông tin hợp tác");
            message.setText("Chúng tối đã tiếp nhận thông tin, đội ngũ quản trị sẽ liên hệ đến bạn trong vài ngày tới");

            // Send message
            Transport.send(message);

            System.out.println("Message sent successfully to " + recipientEmail);
            return 10;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String recipientEmail = Admin_Quan_MailConfig.RECEIVE_EMAIL;
        sendEmailTo(recipientEmail);
    }
}
