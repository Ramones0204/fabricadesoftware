package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.senai.fatesg.primefaces.entidade.Liga;
import br.com.senai.fatesg.primefaces.persistencia.LigaDao;

@Named("LigaControl")
@Scope("conversation")
public class LigaControl {
	
	private Liga liga = new Liga();
	@Autowired
	private LigaDao ligaDao;

	private List<Liga> ligas = new ArrayList<Liga>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		if(liga.getNomeLiga().isEmpty()) {
			UtilFaces.addMensagemFaces("Favor informar o nome da Liga");
		}
		if(liga.getNomeLiga().length() > 40) {
			UtilFaces.addMensagemFaces("Números de caracteres maximos atingido");
		}
		else if(liga.getId() == null) {
			try {
				ligaDao.incluir(liga);
				listar(evt);
				liga = new Liga();
				UtilFaces.addMensagemFaces("Liga Salva com Sucesso");
			} catch (Exception e) {
				UtilFaces.addMensagemFaces("Erro ao incluir a Liga");
			}
		} else {
			ligaDao.alterar(liga);
			listar(evt);
			liga = new Liga();
			UtilFaces.addMensagemFaces("Liga alterada com Sucesso");
		}
		
	}

	public void listar(ActionEvent evt) {
		try {
			ligas = ligaDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar as ligas");

		}
	}
	
	public void excluir(Liga liga) {
		try {
			ligaDao.excluirPorId(liga.getId());
			UtilFaces.addMensagemFaces("Liga " + liga.getNomeLiga() + "Excluida com sucesso");
			ligas = ligaDao.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void selecionarLigaParaEdicao(Liga liga) {

		try {
			this.liga = ligaDao.consultar(liga.getId());
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public List<Liga> getLigas() {
		return ligas;
	}

}
