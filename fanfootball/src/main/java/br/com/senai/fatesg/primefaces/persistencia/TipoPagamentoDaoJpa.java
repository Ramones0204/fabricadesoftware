package br.com.senai.fatesg.primefaces.persistencia;



import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.TipoPagamento;
import br.com.senai.fatesg.primefaces.entidade.TipoProduto;

@Repository("tipoPagamentoDao")
public class TipoPagamentoDaoJpa extends PersistenciaJpa<TipoPagamento> implements TipoPagamentoDao{
	 private static final long serialVersionUID = 1L;
	 
}
