package com.jcboe.home.instruction.config;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class PropertyPrinterTest {

	@Test
	void testPrintProperties() throws Exception {

		PropertyPrinter propertyPrinter = new PropertyPrinter();

		ReflectionTestUtils.setField(propertyPrinter, "dbUrl", "jdbc:postgresql://localhost:5432/testdb");

		ReflectionTestUtils.setField(propertyPrinter, "apiVersion", "v1");

		Method method = PropertyPrinter.class.getDeclaredMethod("printProperties");
		method.setAccessible(true);

		assertDoesNotThrow(() -> method.invoke(propertyPrinter));
	}

	@Test
	void testConstructor() {
		assertDoesNotThrow(() -> new PropertyPrinter());
	}
}