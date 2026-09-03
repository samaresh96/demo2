/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.utilities;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * 
 * Date: 30-July-2026
 * Class: AES.java
 * Purpose: AES class use for encrypt decrypt a text.
 *
 */
public class AES {
	private static final Logger logger = LogManager.getLogger(AES.class);

	private AES() {
	}

	private static final String ALGO = "AES/GCM/NoPadding";
	private static String algoTemp = StringUtils.substringBefore(ALGO, "/");

	/*
	 * Date: 06-Dec-2022 Method: encrypt Purpose: encrypt method use for encrypt a
	 * text using a secret key.
	 */
	public static String encrypt(String plainText, String salt) {
		try {
			if (StringUtils.isEmpty(plainText)) {
				return "";
			}

			Key key = generateKey(salt);
			Cipher c = Cipher.getInstance(algoTemp);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(plainText.getBytes());
			return Base64.getEncoder().encodeToString(encVal);
		} catch (Exception e) {
			logger.error("An error occurred: {} ", e.getMessage());
			return null;
		}
	}

	/*
	 * Date: 30-July-2026 Method: generateKey Purpose: generateKey method use for
	 * generates secret key.
	 */
	private static Key generateKey(String salt) {

		byte[] keyValue = salt.getBytes();

		return new SecretKeySpec(keyValue, algoTemp);
	}

	/*
	 * Date: 30-July-2026 Method: decryptToString Purpose: decryptToString method use
	 * for decrypt a text using a secret key in String format.
	 */
	public static String decryptToString(String cipherText, String salt) {
		try {
			Key key = generateKey(salt);
			Cipher cipher = Cipher.getInstance(algoTemp);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
			return new String(plainText);

		} catch (Exception e) {
			logger.error("An error occurred: {} ", e.getMessage());
			return null;
		}

	}

	/*
	 * Date: 30-July-2026 Method: decryptToString Purpose: decrypt method use for
	 * decrypt a text using a secret key in long format.
	 */
	public static Long decrypt(String cipherText, String salt) {
		try {
			Key key = generateKey(salt);
			Cipher cipher;
			cipher = Cipher.getInstance(algoTemp);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText;
			plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
			String strVal = new String(plainText);
			return Long.parseLong(strVal);

		}

		catch (Exception e) {
			logger.error("An error occurred: {} ", e.getMessage());
			return null;
		}

	}

}
