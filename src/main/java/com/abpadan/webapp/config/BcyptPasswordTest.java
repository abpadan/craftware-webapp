package com.abpadan.webapp.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcyptPasswordTest {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		String encodedValue = bCryptPasswordEncoder.encode("password");
		System.out.println(encodedValue);
	}

}
