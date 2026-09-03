package com.jcboe.home.instruction.mailconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.jcboe.home.instruction.utilities.Constant;

class EmailSenderTest {

	private EmailSender emailSender;

	@BeforeEach
	void setUp() {
		emailSender = new EmailSender();
	}

	@AfterEach
	void tearDown() {
		Constant.setSenderMail(null);
	}

	@Test
	void testConfigureMailPropertiesWithoutAuth() {
		String host = "smtp.test.com";
		int port = 25;
		String email = "test@test.com";
		JavaMailSenderImpl result = emailSender.configureMailProperties(host, port, email, null, false);
		assertNotNull(result);
		assertEquals(host, result.getHost());
		assertEquals(port, result.getPort());
		assertEquals(email, result.getUsername());
		assertEquals(email, Constant.getSenderMail());
		Properties props = result.getJavaMailProperties();
		assertEquals("false", props.getProperty("mail.smtp.ssl.enable"));
		assertEquals("false", props.getProperty("mail.smtp.auth"));
		assertEquals("false", props.getProperty("mail.smtp.starttls.enable"));
	}

	@Test
	void testConfigureMailPropertiesWithAuth() {
		String host = "smtp.test.com";
		int port = 587;
		String email = "test@test.com";
		String password = "password123";
		JavaMailSenderImpl result = emailSender.configureMailProperties(host, port, email, password, true);
		assertNotNull(result);
		assertEquals(host, result.getHost());
		assertEquals(port, result.getPort());
		assertEquals(email, result.getUsername());
		assertEquals(password, result.getPassword());
		assertEquals(email, Constant.getSenderMail());
		Properties props = result.getJavaMailProperties();
		assertEquals("true", props.getProperty("mail.smtp.auth"));
		assertEquals("true", props.getProperty("mail.smtp.starttls.enable"));
		assertEquals("true", props.getProperty("mail.smtp.starttls.required"));
		assertEquals(host, props.getProperty("mail.smtp.ssl.trust"));
		assertEquals("true", props.getProperty("mail.debug"));
	}

	@Test
	void testSendMail() throws Exception {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Constant.setSenderMail("sender@test.com");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		JavaMailSenderImpl sender = org.mockito.Mockito.spy(mailSender);
		org.mockito.Mockito.doReturn(mimeMessage).when(sender).createMimeMessage();
		org.mockito.Mockito.doNothing().when(sender).send(org.mockito.Mockito.any(MimeMessage.class));
		File templateFile = File.createTempFile("email-template", ".html");
		try {
			FileWriter writer = new FileWriter(templateFile);
			writer.write("Hello ${name}");
			writer.close();
			Map<String, String> replacers = new HashMap<String, String>();
			replacers.put("name", "John");
			String[] recipients = new String[] { "recipient@test.com" };
			String[] ccRecipients = new String[] { "cc@test.com" };
			String[] bccRecipients = new String[] { "bcc@test.com" };
			emailSender.sendMail(sender, recipients, ccRecipients, bccRecipients, "Test Subject", replacers,
					templateFile.getAbsolutePath());
			org.mockito.Mockito.verify(sender, org.mockito.Mockito.times(1))
					.send(org.mockito.Mockito.any(MimeMessage.class));
		} finally {
			templateFile.delete();
		}
	}

	@Test
	void testSendMailWithEmptyRecipients() throws Exception {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Constant.setSenderMail("sender@test.com");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		JavaMailSenderImpl sender = org.mockito.Mockito.spy(mailSender);
		org.mockito.Mockito.doReturn(mimeMessage).when(sender).createMimeMessage();
		org.mockito.Mockito.doNothing().when(sender).send(org.mockito.Mockito.any(MimeMessage.class));
		File templateFile = File.createTempFile("email-template", ".html");
		try {
			FileWriter writer = new FileWriter(templateFile);
			writer.write("Test email body");
			writer.close();
			Map<String, String> replacers = new HashMap<String, String>();
			emailSender.sendMail(sender, new String[] { "recipient@test.com" }, new String[] {}, new String[] {},
					"Test Subject", replacers, templateFile.getAbsolutePath());
			org.mockito.Mockito.verify(sender, org.mockito.Mockito.times(1))
					.send(org.mockito.Mockito.any(MimeMessage.class));
		} finally {
			templateFile.delete();
		}
	}
}
