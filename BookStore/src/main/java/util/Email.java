package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	// nttudocs@gmail.com
	// 123456789
	// lebbvrdsirmaoepg

	public static void sendEmail(String from, String password, String to, String subject, String content) {
		// Props
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587"); // TLS: 587, SSL: 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Create Authenticator
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}

		};

		// Session
		Session session = Session.getInstance(props, auth);

		// Send email

		MimeMessage msg = new MimeMessage(session);

		try {
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.setFrom(from);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			// Gửi email from, nhưng muốn người khác reply tới from2
//			msg.setReplyTo(InternetAddress.parse(from2, false));
			msg.setContent(content, "text/HTML; charset=UTF-8");
			Transport.send(msg);

			System.out.println("Đã gửi mail từ " + from + " đến " + to);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String from = "nttudocs@gmail.com";
		String password = "lebbvrdsirmaoepg";
		String to = "nttudocs@gmail.com";
		String subject = "Test gửi mail";

		String content = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n" + "  </head>\r\n" + "  <body>\r\n"
				+ "    <h1>Vé xem phim của bạn</h1>\r\n" + "\r\n"
				+ "  <img src=\"https://cdn-www.vinid.net/81717785-cach-san-voucher-ve-xem-phim.jpg\" alt=\"\">\r\n"
				+ "  </body>\r\n" + "</html>";

		sendEmail(from, password, to, subject, content);
	}
}
