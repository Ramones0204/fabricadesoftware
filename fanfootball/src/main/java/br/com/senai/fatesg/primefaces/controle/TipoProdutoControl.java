package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import br.com.senai.fatesg.primefaces.entidade.TipoProduto;
import br.com.senai.fatesg.primefaces.persistencia.TipoProdutoDao;

@Named("TipoProdutoControl")
@Scope("conversation")
public class TipoProdutoControl {
	private TipoProduto tipoProduto = new TipoProduto();

	@Autowired
	private TipoProdutoDao tipoProdutoDao;

	private List<TipoProduto> tiposProdutos = new ArrayList<TipoProduto>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		if (tipoProduto.getId() == 0) {
			try {
				tipoProdutoDao.incluir(tipoProduto);
				listar(evt);
				tipoProduto = new TipoProduto();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			tipoProdutoDao.alterar(tipoProduto);
			listar(evt);
			tipoProduto = new TipoProduto();
		}

	}

	public void listar(ActionEvent evt) {
		try {
			tiposProdutos = tipoProdutoDao.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void excluir(TipoProduto tipoProduto) {
		try {
			tipoProdutoDao.excluirPorId(tipoProduto.getId());
			tiposProdutos = tipoProdutoDao.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void selecionarTipoProduto(TipoProduto tipoProduto) {
		try {
			this.tipoProduto = tipoProdutoDao.consultar(tipoProduto.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<TipoProduto> getTiposProdutos() {
		return tiposProdutos;
	}

}
