package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Fornecedor;


@Repository("fornecedorDao")
public class FornecedorDaoJpa extends PersistenciaJpa<Fornecedor> implements FornecedorDao{
	 private static final long serialVersionUID = 1L;
}
