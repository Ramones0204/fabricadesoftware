package br.com.senai.fatesg.primefaces.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {

	public EmailJava() {

	}

	public void enviarEmail() {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("ramonroliveirafilho@gmail.com", "1104Saopaulo"));
			email.setSSLOnConnect(true);
			email.setFrom("ramonroliveirafilho@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("Seja bem vindo a FanFootball");
			//email.addTo("ramonroliveirafilho@outlook.com");
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
