package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoProduto {
	@Id
	@GeneratedValue(generator = "tipoProduto_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "tipoProduto_seq", sequenceName = "tipoProduto_seq", allocationSize = 1, initialValue = 1)
	private int id;
	private String descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
