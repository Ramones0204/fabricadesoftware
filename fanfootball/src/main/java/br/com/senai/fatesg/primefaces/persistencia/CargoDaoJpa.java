package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Cargo;

@Repository("cargoDao")
public class CargoDaoJpa extends PersistenciaJpa<Cargo> implements CargoDao {
	 private static final long serialVersionUID = 1L;
}
