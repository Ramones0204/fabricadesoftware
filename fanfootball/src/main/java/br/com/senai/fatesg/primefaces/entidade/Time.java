package br.com.senai.fatesg.primefaces.entidade;

public class Time {
	private int id;
	private String nomeTime;
	private String tipoTime;
	private String pais;
	private String região;
	private Liga liga;
	
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
	public String getRegião() {
		return região;
	}
	public void setRegião(String região) {
		this.região = região;
	}
	public Liga getLiga() {
		return liga;
	}
	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
	
}
