package br.com.senai.fatesg.primefaces.entidade;

public enum Tamanho {
	P("P"), M("M"), G("G"), GG("GG"), XLG("XLG");

	private String label;

	Tamanho(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
