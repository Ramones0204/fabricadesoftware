package br.com.senai.fatesg.primefaces.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Email;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Embeddable
public class Contato extends Entidade implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false )
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
	
	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
