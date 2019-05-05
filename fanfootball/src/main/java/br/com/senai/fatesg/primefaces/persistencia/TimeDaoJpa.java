package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Time;

@Repository("timeDao")
public class TimeDaoJpa  extends PersistenciaJpa<Time> implements TimeDao{
	private static final long serialVersionUID = 1L;
}
