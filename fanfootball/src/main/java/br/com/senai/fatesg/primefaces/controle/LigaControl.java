package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

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
		if(liga.getId() == 0) {
			try {
				ligaDao.incluir(liga);
				listar(evt);
				liga = new Liga();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			ligaDao.alterar(liga);
			listar(evt);
			liga = new Liga();
		}
		
	}

	public void listar(ActionEvent evt) {
		try {
			ligas = ligaDao.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void excluir(Liga liga) {
		ligaDao.excluirPorId(liga.getId());
		ligas = ligaDao.listar();

	}

	public void alterar(Liga liga) {
		try {
			ligaDao.alterar(liga);
			liga = new Liga();
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
