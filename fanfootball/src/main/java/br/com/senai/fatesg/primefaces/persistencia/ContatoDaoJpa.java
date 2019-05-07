 package br.com.senai.fatesg.primefaces.persistencia;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Contato;

@Repository("contatoDao")
public class ContatoDaoJpa extends PersistenciaJpa<Contato> implements ContatoDao {

	private static final long serialVersionUID = 1L;

	
	   @Override
	   @SuppressWarnings("unchecked")
	   public List<Contato> consultarNomeOuTelefone(String nomeOuTelefone) {
	   	Query query = em.createQuery("select c from Contato c where UPPER(c.nome) LIKE :nome OR UPPER(c.telefone) LIKE :telefone");
	   	query.setParameter("nome", nomeOuTelefone.toUpperCase()+ "%");
	   	query.setParameter("telefone", nomeOuTelefone.toUpperCase()+ "%");
	   	return query.getResultList();
	   }

	@Transactional
	public void update(Contato contato) {
		
		em.merge(contato);
	}
  
	

	
	




}
