package br.com.senai.fatesg.primefaces.util;

import org.hibernate.validator.constraints.Email;

public class EnviarEmail {
	
	public EnviarEmail() {
		
	}
	/*
	public void enviarEmail() {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("username", "password"));
			email.setSSLOnConnect(true);
			email.setFrom("user@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("foo@bar.com");
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
*/
}
