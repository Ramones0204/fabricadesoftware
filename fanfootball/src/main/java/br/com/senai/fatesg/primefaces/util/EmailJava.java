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
			email.setAuthenticator(new DefaultAuthenticator("fanfootballads@gmail.com", "futebol.10"));
			email.setSSLOnConnect(true);
			email.setFrom("fanfootballads@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("Deu certo o envio :-)");
			email.addTo("maxwell201414@gmail.com");
			email.setMsg("Seja bem vindo a FanFootball");
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
