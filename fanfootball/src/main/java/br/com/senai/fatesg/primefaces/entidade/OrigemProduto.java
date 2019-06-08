package br.com.senai.fatesg.primefaces.entidade;

public enum OrigemProduto {
	NACIONAL("Nacional"),
	IMPORTADO("Importado");
	
	
	private String label;

	private OrigemProduto(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
