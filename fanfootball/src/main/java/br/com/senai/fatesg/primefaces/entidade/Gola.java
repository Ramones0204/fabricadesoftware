package br.com.senai.fatesg.primefaces.entidade;

public enum Gola {
	GOLAV("Gola V"),
	GOLAPOLO("Gola Polo"),
	GolaCaraca("Gola Careca");
	
	private String label;

	private Gola(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
