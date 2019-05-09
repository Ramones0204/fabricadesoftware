package br.com.senai.fatesg.primefaces.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.ambientinformatica.util.Entidade;


@Entity
public class Liga extends Entidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorLiga")
	@SequenceGenerator(name = "geradorLiga", sequenceName = "geradorLiga", allocationSize = 1)
	private long id;
	private String nomeLiga;
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="liga")
	private List<Time> times;


	public Object getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeLiga() {
		return nomeLiga;
	}

	public void setNomeLiga(String nomeLiga) {
		this.nomeLiga = nomeLiga;
	}
	
	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return getId() + " - " + getNomeLiga();
	}

}
