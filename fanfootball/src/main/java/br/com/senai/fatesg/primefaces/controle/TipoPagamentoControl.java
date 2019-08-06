package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.TipoPagamento;
import br.com.senai.fatesg.primefaces.persistencia.TipoPagamentoDao;

@Named("TipoPagamentoControl")
@Scope("conversation")
public class TipoPagamentoControl {
	private TipoPagamento TipoPagamento = new TipoPagamento();

	@Autowired
	private TipoPagamentoDao TipoPagamentoDao;

	private List<TipoPagamento> tiposPagamentos = new ArrayList<TipoPagamento>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		if(TipoPagamento.getDescricao().isEmpty()) {
			UtilFaces.addMensagemFaces("Favor Informar a Descrição do Tipo Pagamento");
		}
		else if(TipoPagamento.getDescricao().length() > 40) {
			UtilFaces.addMensagemFaces("Números de caracteres maximos atingido");

		}
		else if (TipoPagamento.getId() == 0) {
			try {
				TipoPagamentoDao.incluir(TipoPagamento);
				listar(evt);
				TipoPagamento = new TipoPagamento();
				UtilFaces.addMensagemFaces("Tipo de Pagemento Salvo com Sucesso");
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao inserir o Tipo de Pagamento");
			}
		} else {
			try {
				TipoPagamentoDao.alterar(TipoPagamento);
				listar(evt);
				TipoPagamento = new TipoPagamento();
				UtilFaces.addMensagemFaces("Tipo De Pagemento Alterado com Sucesso");

			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao alterar o tipo Pagamento");

			}
	
		}

	}

	public void listar(ActionEvent evt) {
		try {
			tiposPagamentos = TipoPagamentoDao.listar();
		
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	

	public void excluir(TipoPagamento TipoPagamento) {
		try {
			TipoPagamentoDao.excluirPorId(TipoPagamento.getId());
			UtilFaces.addMensagemFaces("Tipo de Pagemento " + TipoPagamento.getDescricao() + "Excluido com Sucesso");
			tiposPagamentos = TipoPagamentoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao Excluir o Tipo de Pagamento");

		}
	}

	public void selecionarTipoPagamento(TipoPagamento TipoPagamento) {
		try {
			this.TipoPagamento = TipoPagamentoDao.consultar(TipoPagamento.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

	public TipoPagamento getTipoPagamento() {
		return TipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento TipoPagamento) {
		this.TipoPagamento = TipoPagamento;
	}

	public List<TipoPagamento> gettiposPagamentos() {
		return tiposPagamentos;
	}

}
