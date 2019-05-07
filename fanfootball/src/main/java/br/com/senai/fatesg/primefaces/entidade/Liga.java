package br.com.senai.fatesg.primefaces.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Liga {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorLiga")
	@SequenceGenerator(name = "geradorLiga", sequenceName = "geradorLiga", allocationSize = 1)
	@Column(name = "id_liga")
	private int id;
	private String nomeLiga;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="liga")
	
	private List<Time> times;

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
	
	@Override
	public String toString() {
		return getId() + " - " + getNomeLiga();
	}

}
