package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.TipoProduto;

@Repository("tipoProdutoDao")
public class TipoProdutoDaoJpa extends PersistenciaJpa<TipoProduto> implements TipoProdutoDao{
	 private static final long serialVersionUID = 1L;

}
