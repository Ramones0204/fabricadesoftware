package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
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
		if(tipoProduto.getDescricao().isEmpty()) {
			UtilFaces.addMensagemFaces("Favor Informar a Descrição do Tipo Produto");
		}
		else if (tipoProduto.getId() == 0) {
			try {
				tipoProdutoDao.incluir(tipoProduto);
				listar(evt);
				tipoProduto = new TipoProduto();
				UtilFaces.addMensagemFaces("Tipo de Produto Salvo com Sucesso");
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao inserir o Tipo de Produto");
			}
		} else {
			try {
				tipoProdutoDao.alterar(tipoProduto);
				listar(evt);
				tipoProduto = new TipoProduto();
				UtilFaces.addMensagemFaces("Tipo De Produto Alterado com Sucesso");

			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao alterar o tipo produto");

			}
	
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
			UtilFaces.addMensagemFaces("Tipo de Produto " + tipoProduto.getDescricao() + "Excluido com Sucesso");
			tiposProdutos = tipoProdutoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao Excluir o Tipo de Produto");

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
