package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
public class Pessoa {
	@Id
	private int id_pessoa;
	private String nome;
	@Column(insertable = false, updatable = false)
	private String tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/*
	 * private String cpf; private Date dataNascimento; private Contato contato;
	 * public String getNome() { return nome; } public void setNome(String nome) {
	 * this.nome = nome; } public String getCpf() { return cpf; } public void
	 * setCpf(String cpf) { this.cpf = cpf; } public Date getDataNascimento() {
	 * return dataNascimento; } public void setDataNascimento(Date dataNascimento) {
	 * this.dataNascimento = dataNascimento; } public Contato getContato() { return
	 * contato; } public void setContato(Contato contato) { this.contato = contato;
	 * }
	 */

}
