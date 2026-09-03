package com.jcboe.home.instruction.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

class AESTest {

	// 16-byte AES key
	private static final String SALT = "1234567890123456";

	@Test
	void testEncryptAndDecryptString() {

		String plainText = "Hello World";

		String encrypted = AES.encrypt(plainText, SALT);

		assertNotNull(encrypted);
		assertNotEquals(plainText, encrypted);

		String decrypted = AES.decryptToString(encrypted, SALT);

		assertEquals(plainText, decrypted);
	}

	@Test
	void testEncryptAndDecryptLong() {

		String value = "123456";

		String encrypted = AES.encrypt(value, SALT);

		assertNotNull(encrypted);

		Long decrypted = AES.decrypt(encrypted, SALT);

		assertEquals(Long.valueOf(123456L), decrypted);
	}

	@Test
	void testEncryptWithEmptyString() {

		assertEquals("", AES.encrypt("", SALT));
		assertEquals("", AES.encrypt(null, SALT));
	}

	@Test
	void testDecryptToStringInvalidCipher() {

		assertNull(AES.decryptToString("invalidCipher", SALT));
	}

	@Test
	void testDecryptInvalidCipher() {

		assertNull(AES.decrypt("invalidCipher", SALT));
	}

	@Test
	void testEncryptInvalidKeyLength() {

		// Invalid AES key length
		String invalidSalt = "123";

		assertNull(AES.encrypt("Hello", invalidSalt));
	}

	@Test
	void testPrivateConstructor() throws Exception {

		Constructor<AES> constructor = AES.class.getDeclaredConstructor();
		constructor.setAccessible(true);

		AES aes = constructor.newInstance();

		assertNotNull(aes);
	}
}