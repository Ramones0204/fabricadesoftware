package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.CupomDesconto;
import br.com.senai.fatesg.primefaces.persistencia.CupomDescontoDao;

@Named("CupomDescontoControl")
@Scope("conversation")
public class CupomDescontoControl {

	private CupomDesconto cupomDesconto = new CupomDesconto();

	@Autowired
	private CupomDescontoDao cupomDao;

	private List<CupomDesconto> cupons = new ArrayList<CupomDesconto>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) throws Exception {
		if(cupomDesconto.getNomeCupom().isEmpty()) {
			UtilFaces.addMensagemFaces("Os Campos Nome devem ser informados");
		}
		else if(cupomDesconto.getValorDesconto() == null) {
			UtilFaces.addMensagemFaces("Os Campos Valor devem ser informados");
		}
		else if(cupomDesconto.getNomeCupom().length() > 40) {
			UtilFaces.addMensagemFaces("Números de caracteres maximos atingido");
		}
		else if (cupomDesconto.getId()== 0) {
			cupomDao.incluir(cupomDesconto);
			listar(evt);
			cupomDesconto = new CupomDesconto();
			UtilFaces.addMensagemFaces("Cupom Salvo com sucesso");
		} else {
			try {
				cupomDao.alterar(cupomDesconto);
				UtilFaces.addMensagemFaces("Cupom Salvo com sucesso");
				listar(evt);
				cupomDesconto = new CupomDesconto();
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao Alterar o Cargo " + cupomDesconto.getId());
			}
		}
		
	}

	public void listar(ActionEvent evt) {
		try {
			cupons = cupomDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar os cupons");
		}
	}
	
	public void selecionarCupomParaEdicao(CupomDesconto cupomDesconto) {
		try {
			this.cupomDesconto= cupomDao.consultar(cupomDesconto.getId());
		} catch (Exception e) {
		}
	}
	
	public void excluir(CupomDesconto cupomDesconto) {
		try {
			cupomDao.excluirPorId(cupomDesconto.getId());
			UtilFaces.addMensagemFaces("Cargo " + cupomDesconto.getNomeCupom()+ " Deletado");
			cupons = cupomDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao deletar o cargo " + cupomDesconto.getNomeCupom());

		}
		
	}

	public CupomDesconto getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDesconto cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public CupomDescontoDao getCupomDao() {
		return cupomDao;
	}

	public void setCupomDao(CupomDescontoDao cupomDao) {
		this.cupomDao = cupomDao;
	}

	public List<CupomDesconto> getCupons() {
		return cupons;
	}

	public void setCupons(List<CupomDesconto> cupons) {
		this.cupons = cupons;
	}
	
	

}
