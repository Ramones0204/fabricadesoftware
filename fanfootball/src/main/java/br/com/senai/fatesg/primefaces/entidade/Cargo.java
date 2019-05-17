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
public class Cargo extends Entidade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "cargo_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cargo_seq", sequenceName = "contato_seq", allocationSize = 1, initialValue = 1)
	private long id;
	private String nomeCargo;
	private Double salario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="cargo")
	private List<Funcionario> funcionarios;
	
	
	public Object getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
