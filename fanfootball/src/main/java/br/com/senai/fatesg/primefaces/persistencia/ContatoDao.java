package br.com.senai.fatesg.primefaces.persistencia;


import java.util.List;

import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.senai.fatesg.primefaces.entidade.Contato;

public interface ContatoDao extends Persistencia<Contato>{
	
	 List<Contato> consultarNomeOuTelefone(String nomeOuTelefone);
	 public void update(Contato contato);
	
	 

}
