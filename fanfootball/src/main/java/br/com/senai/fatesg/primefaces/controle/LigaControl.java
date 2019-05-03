package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
		try {
			ligaDao.alterar(liga);
			listar(evt);
			liga = new Liga();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void listar(ActionEvent evt) {
		try {
			ligas = ligaDao.listar();
		} catch (Exception e) {
			e.getMessage();
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
