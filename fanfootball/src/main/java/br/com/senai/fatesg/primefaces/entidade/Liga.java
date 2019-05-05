package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Liga {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorLiga")
	@SequenceGenerator(name = "geradorLiga", sequenceName = "geradorLiga",allocationSize=1)
	@Column(name = "id_liga")
	private int id;
	private String nomeLiga;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeLiga() {
		return nomeLiga;
	}
	public void setNomeLiga(String nomeLiga) {
		this.nomeLiga = nomeLiga;
	}
	
	
	
}
