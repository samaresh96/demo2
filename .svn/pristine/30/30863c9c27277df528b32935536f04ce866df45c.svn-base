package com.jcboe.home.instruction.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ConstantTest {

	@Test
	void testSenderMailGetterSetter() {

		Constant.setSenderMail("test@test.com");

		assertEquals("test@test.com", Constant.getSenderMail());
	}

	@Test
	void testMessageMapGetterSetter() {

		Map<String, String> map = new HashMap<>();
		map.put("KEY", "VALUE");

		Constant.setMessageMap(map);

		Map<String, String> result = Constant.getMessageMap();

		assertEquals("VALUE", result.get("KEY"));
		assertSame(map, result);
	}

	@Test
	void testDefaultMessageMap() {

		Constant.setMessageMap(new HashMap<>());

		Map<String, String> result = Constant.getMessageMap();

		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	void testConstants() {

		assertEquals("WhsyhWoVw3nVNx3G", Constant.SALT_AES);
		assertEquals("Plikster$Faptzel", Constant.ZIP_ENCRYPTION_PSWRD);
		assertEquals("PARNT", Constant.LOG_PA);
		assertEquals("PAPW", Constant.LOG_PAPW);
		assertEquals("APP", Constant.APP_CONFIG_API_REF);
		assertEquals("ELA", Constant.ELA_API_REF);
		assertEquals("ADM", Constant.LOG_AD);
		assertEquals("FUA", Constant.FUA_API);
	}

	@Test
	void testPrivateConstructor() throws Exception {

		Constructor<Constant> constructor = Constant.class.getDeclaredConstructor();
		constructor.setAccessible(true);

		Constant constant = constructor.newInstance();

		assertNotNull(constant);
	}
}