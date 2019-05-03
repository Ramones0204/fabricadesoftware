package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;

@Entity
public class Cargo {
	@Id
	@GeneratedValue(generator = "cargo_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cargo_seq", sequenceName = "contato_seq", allocationSize = 1, initialValue = 1)

	private int id;
	private String nomeCargo;
	private Double salario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
