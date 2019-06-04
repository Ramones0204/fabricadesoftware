package br.com.senai.fatesg.primefaces.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail extends Thread {
	String email;

	public SendEmail(String email) {
		this.email = email;
	}

	public void run() {
		try {
			Email envioemail = new SimpleEmail();
			envioemail.setHostName("smtp.googlemail.com");
			envioemail.setSmtpPort(465);
			envioemail.setAuthenticator(new DefaultAuthenticator("fanfootballads@gmail.com", "futebol.10"));
			envioemail.setSSLOnConnect(true);
			envioemail.setFrom("fanfootballads@gmail.com");
			envioemail.setSubject("Email de confirmação");
			envioemail.setMsg("Seja Bem Vindo a fanfootball");
			envioemail.addTo(this.email);
			envioemail.send();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
