package br.com.senai.fatesg.primefaces.entidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum TipoManga {
	CURTA("CURTA","Manga Curta"),
	LONGA("LONGA","Manga Longa");
	
	private String valor = "";
	private String desc = "";
	
	private TipoManga(String valor, String desc) {
		this.valor = valor;
		this.desc = desc;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDesc();
	}
	
	public static List<TipoManga> getListTipoManga(){
		List<TipoManga> mangas = new ArrayList<TipoManga>();
		for(TipoManga manga:TipoManga.values()) {
			mangas.add(manga);
		}
		Collections.sort(mangas, new Comparator<TipoManga>(){

			@Override
			public int compare(TipoManga o1, TipoManga o2) {
				// TODO Auto-generated method stub
				return new Integer(o1.ordinal()).compareTo(new Integer(o2.ordinal()));
			}
			
		});
		return mangas;
		
	}
}
