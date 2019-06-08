package br.com.senai.fatesg.primefaces.persistencia;



import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Produto;

@Repository("produtoDao")
public class ProdutoDaoJpa extends PersistenciaJpa<Produto> implements ProdutoDao{
	 private static final long serialVersionUID = 1L;
	 
}
