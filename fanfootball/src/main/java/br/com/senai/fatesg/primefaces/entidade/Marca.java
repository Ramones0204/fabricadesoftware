package br.com.senai.fatesg.primefaces.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Marca implements Serializable {
	@Id
	@GeneratedValue(generator = "marca_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "marca_seq", sequenceName = "contato_seq", allocationSize = 1, initialValue = 1)
	private int id;
	private String nomeMarca;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	
	

}
