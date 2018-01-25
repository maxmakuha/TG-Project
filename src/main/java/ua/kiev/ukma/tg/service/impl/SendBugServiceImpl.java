package ua.kiev.ukma.tg.service.impl;

import java.security.Principal;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.model.Bug;
import ua.kiev.ukma.tg.service.SendBugService;

@Service
@Transactional(readOnly = true)
public class SendBugServiceImpl implements SendBugService {

	@Override
	public void sendBug(Bug bug, Principal user) {

		final String username = "timetable.generator.project@gmail.com";
		final String password = "finukma2017";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("maxmakuha@gmail.com"));
			message.setSubject("TG-Project Bug Report");
			message.setText("TITLE: " + bug.getTitle() + "\n" + "DESCRIPTION: " + bug.getBody() + "\n" + "FROM: " + user.getName());
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
