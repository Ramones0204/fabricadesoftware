package br.com.senai.fatesg.primefaces.entidade;

public enum Manga {
	LONGA("Longa"),
	CURTA("Curta");
	
	private String label;
	
	Manga(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
