package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Cargo;
import br.com.senai.fatesg.primefaces.entidade.CupomDesconto;

@Repository("cupomDescontoDao")
public class CupomDescontoDaoJpa extends PersistenciaJpa<CupomDesconto> implements CupomDescontoDao {
	 private static final long serialVersionUID = 1L;
}
