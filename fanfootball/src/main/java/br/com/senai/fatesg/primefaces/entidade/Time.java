package br.com.senai.fatesg.primefaces.entidade;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Time  {
	
	@Id
	@GeneratedValue(generator = "time_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "time_seq", sequenceName = "time_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "id_time")
	private int id;
	private String nomeTime;
	private String tipoTime;
	private String pais;
	private String regiao;
	private String estado;
	@ManyToOne
	private Liga liga;
	@JoinColumn(name = "id_liga")
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	public String getTipoTime() {
		return tipoTime;
	}
	public void setTipoTime(String tipoTime) {
		this.tipoTime = tipoTime;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Liga getLiga() {
		return liga;
	}
	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
}
