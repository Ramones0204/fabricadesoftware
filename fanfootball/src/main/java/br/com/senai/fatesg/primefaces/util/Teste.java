package br.com.senai.fatesg.primefaces.util;

import br.com.senai.fatesg.primefaces.entidade.Liga;
import br.com.senai.fatesg.primefaces.persistencia.LigaDaoJpa;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Liga liga = new Liga();
		
		LigaDaoJpa dao = new LigaDaoJpa();
		
		liga.setNomeLiga("Brasil");
		
		dao.incluir(liga);
		
		
	}

}
