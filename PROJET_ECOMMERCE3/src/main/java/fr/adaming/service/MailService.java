package fr.adaming.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("conceptEmail")
public class MailService {

	private MailSender conceptMail;

	public void conceptReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

		fromAddress = "conceptStore@gmail.com";
		SimpleMailMessage conceptMsg = new SimpleMailMessage();
		conceptMsg.setFrom(fromAddress);
		conceptMsg.setTo(toAddress);
		conceptMsg.setSubject(subject);
		conceptMsg.setText(msgBody);
		conceptMail.send(conceptMsg);
	}

}
