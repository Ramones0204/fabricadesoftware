package br.com.senai.fatesg.primefaces.entidade;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Contato implements Serializable {
    
	private String email;
	private String telefoneFixo;
	private String telefoneCelular;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	
	
}
