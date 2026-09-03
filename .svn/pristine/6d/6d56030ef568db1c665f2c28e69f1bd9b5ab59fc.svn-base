package com.jcboe.home.instruction.mailconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

class TemplateUtilTest {

	private final TemplateUtil templateUtil = new TemplateUtil();

	@Test
	void testGetEmailBodyWithValidTemplate() throws Exception {
		File templateFile = File.createTempFile("email-template", ".html");
		try {
			String templateContent = "Hello ${name}, welcome to ${company}.";
			FileUtils.writeStringToFile(templateFile, templateContent, StandardCharsets.UTF_8);
			Map<String, String> replacers = new HashMap<String, String>();
			replacers.put("${name}", "John");
			replacers.put("${company}", "JCBOE");
			String result = templateUtil.getEmailBody(replacers, templateFile.getAbsolutePath());
			assertEquals("Hello John, welcome to JCBOE.", result);
		} finally {
			templateFile.delete();
		}
	}

	@Test
	void testGetEmailBodyWithMultipleReplacements() throws Exception {
		File templateFile = File.createTempFile("email-template", ".html");
		try {
			String templateContent = "Dear ${name}, your application ${applicationId} " + "has been ${status}.";
			FileUtils.writeStringToFile(templateFile, templateContent, StandardCharsets.UTF_8);
			Map<String, String> replacers = new HashMap<String, String>();
			replacers.put("${name}", "John");
			replacers.put("${applicationId}", "APP123");
			replacers.put("${status}", "approved");
			String result = templateUtil.getEmailBody(replacers, templateFile.getAbsolutePath());
			assertEquals("Dear John, your application APP123 has been approved.", result);
		} finally {
			templateFile.delete();
		}
	}

	@Test
	void testGetEmailBodyWithEmptyReplacers() throws Exception {
		File templateFile = File.createTempFile("email-template", ".html");
		try {
			String templateContent = "Hello ${name}.";
			FileUtils.writeStringToFile(templateFile, templateContent, StandardCharsets.UTF_8);
			Map<String, String> replacers = new HashMap<String, String>();
			String result = templateUtil.getEmailBody(replacers, templateFile.getAbsolutePath());
			assertEquals("Hello ${name}.", result);
		} finally {
			templateFile.delete();
		}
	}

	@Test
	void testGetEmailBodyWhenTemplateDoesNotExist() {
		String invalidPath = "src/test/resources/template-does-not-exist.html";
		Exception exception = assertThrows(Exception.class,
				() -> templateUtil.getEmailBody(new HashMap<String, String>(), invalidPath));
		assertEquals("Template File not found in specified path: " + new File(invalidPath).getAbsolutePath(),
				exception.getMessage());
	}

}
