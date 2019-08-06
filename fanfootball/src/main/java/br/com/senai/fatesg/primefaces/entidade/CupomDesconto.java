package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class CupomDesconto {
	@Id
	@GeneratedValue(generator = "cupom_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cupom_seq", sequenceName = "cupom_seq", allocationSize = 1, initialValue = 1)
	private int id;
	private String nomeCupom;
	private Double valorDesconto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCupom() {
		return nomeCupom;
	}
	public void setNomeCupom(String nomeCupom) {
		this.nomeCupom = nomeCupom;
	}
	public Double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
	
}
