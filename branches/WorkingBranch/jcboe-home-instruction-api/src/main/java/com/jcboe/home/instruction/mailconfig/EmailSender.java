/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.mailconfig;

import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.jcboe.home.instruction.utilities.Constant;

@Component
public class EmailSender {
	/**
	 * <p>
	 * This method is responsible to configure e-mail properties
	 * </p>
	 * 
	 * @return Object of <b>{@code JavaMailSender}</b> which belongs to
	 *         <b>{@code "org.springframework.mail.javamail"}</b> package
	 * @param senderMailHost     Host name of the sender e-mail
	 * @param senderMailPort     Port of the sender e-mail. Must be integer
	 * @param senderEmail        E-mail id from where e-mail is sent
	 * @param senderMailPassword Password of sender e-mail. Pass <b>{@code null}</b>
	 *                           if <b>auth</b> is <b>false</b>
	 * @param auth               Value either <b>true</b> or <b>false</b>
	 * 
	 * @Example {@code EmailSender emailSender = new EmailSender(); }<br>
	 *          {@code JavaMailSender config =
	 *          emailSender.configureMailProperties("smtp.host.com", 000,
	 *          "demo@example.com", "password", true);}
	 * 
	 *
	 */
	public JavaMailSenderImpl configureMailProperties(String senderMailHost, int senderMailPort, String senderEmail,
			String senderMailPassword, boolean auth) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(senderMailHost);
		mailSender.setPort(senderMailPort);
		mailSender.setUsername(senderEmail);
		Constant.setSenderMail(senderEmail);

		Properties props = mailSender.getJavaMailProperties();
		if (!auth) {
			props.setProperty("mail.smtp.ssl.enable", "false");
			props.put("mail.smtp.auth", "false");
			props.put("mail.smtp.starttls.enable", "false");
		} else {
			mailSender.setPassword(senderMailPassword);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.starttls.required", "true");
		    props.put("mail.smtp.ssl.trust", senderMailHost);
		    props.put("mail.debug", "true");
		}

		return mailSender;
	}

	/**
	 * @param configuration     Instance of {@code JavaMailSender} which contains
	 *                          the properties of e-mail
	 * @param recipientMail     Array of recipient e-mail address
	 * @param ccRecipient       Array of cc recipient e-mail address
	 * @param bccRecipient      Array of Bcc recipient e-mail address
	 * @param mailSubject       Subject of e-mail
	 * @param replacers         {@code key} , {@code value} pair where <b>key</b>
	 *                          contains the replacer key and <b>value</b> contains
	 *                          the respective value of replacer
	 * @param emailTemplatePath File path where email template is present
	 * @throws MessagingException
	 * 
	 * @Example {@code EmailSender emailSender = new EmailSender(); }<br>
	 *          {@code emailSender.sendMail(sender,
	 *          {"demo1@example.com","demo2@example.com"},
	 *          {"ccdemo1@example.com","ccdemo2@example.com"},{"bccdemo1@example.com","bccdemo2@example.com"},"Subject",
	 *          replacers, "<Relative or absolute path of template file>");
	 */
	public void sendMail(JavaMailSender configuration, String[] recipientMail, String[] ccRecipient,
			String[] bccRecipient, String mailSubject, Map<String, String> replacers, String emailTemplatePath)
			throws Exception {
		TemplateUtil templateUtil = new TemplateUtil();

		String mailBody = templateUtil.getEmailBody(replacers, emailTemplatePath);

		MimeMessage message = configuration.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, false);

		helper.setFrom(Constant.getSenderMail());
		helper.setTo(recipientMail);
		helper.setCc(ccRecipient);
		helper.setBcc(bccRecipient);
		helper.setSubject(mailSubject);
		helper.setText(mailBody, true);
		configuration.send(message);
		System.out.println(mailBody);// NOSONAR
	}
}
