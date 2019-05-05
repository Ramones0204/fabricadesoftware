package br.com.senai.fatesg.primefaces.persistencia;




import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Liga;

@Repository("ligaDao")

public class LigaDaoJpa extends PersistenciaJpa<Liga> implements LigaDao {
	 private static final long serialVersionUID = 1L;
	 
	
}
