package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Cliente;

@Repository("clienteDao")

public class ClienteDaoJpa extends PersistenciaJpa<Cliente> implements ClienteDao {
	 private static final long serialVersionUID = 1L;


}
