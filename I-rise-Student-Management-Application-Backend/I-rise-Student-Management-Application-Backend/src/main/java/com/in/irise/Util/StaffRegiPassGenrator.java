package com.in.irise.Util;

import java.security.SecureRandom;
import org.springframework.stereotype.Component;
@Component
public class StaffRegiPassGenrator {
	
	public static String generatePassword(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder password = new StringBuilder();
		 SecureRandom random = new SecureRandom();
		for (int i = 0; i < length; i++) {
			password.append(chars.charAt(random.nextInt(chars.length())));
		}

		return password.toString();
	}

}
