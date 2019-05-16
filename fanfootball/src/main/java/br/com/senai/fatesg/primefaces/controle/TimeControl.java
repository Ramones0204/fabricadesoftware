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
import br.com.senai.fatesg.primefaces.entidade.Time;
import br.com.senai.fatesg.primefaces.persistencia.LigaDao;
import br.com.senai.fatesg.primefaces.persistencia.TimeDao;


@Named("TimeControl")
@Scope("conversation")
public class TimeControl {

	private Time time = new Time();
	@Autowired
	private TimeDao timeDao;
	@Autowired
	private LigaDao ligaDao;
	private List<Time> times = new ArrayList<Time>();
	private List<Liga> ligas = new ArrayList<Liga>();
	private Liga liga = new Liga();

	@PostConstruct
	public void init() {
		listar(null);
		listarLiga();
	}

	public void confirmar(ActionEvent evt) {
		if(time.getNomeTime().isEmpty()) {
			UtilFaces.addMensagemFaces("Favor informar o nome do time");
		}
		if(time.getId() == 0) {
			try {
				time.setLiga(liga);
				timeDao.incluir(time);
				listar(evt);
				time = new Time();
			} catch (Exception e) {
			}
		} else {
			time.setLiga(liga);
			timeDao.alterar(time);
			listar(evt);
			time = new Time();
		}
		
	}

	public void listar(ActionEvent evt) {
		try {
			
			times = timeDao.listar(); 
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listarLiga() {
		try {
			ligas = ligaDao.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void excluir(Time time) {
		timeDao.excluirPorId(time.getId());
		times = timeDao.listar();

	}

	public void selecionarTimes(Time time) {
		
		try {
			this.time = timeDao.consultar(time.getId());

		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Time> getTimes() {
		return times;
	}

	public List<Liga> getLigas() {
		return ligas;
	}

	public void setLigas(List<Liga> ligas) {
		this.ligas = ligas;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
	
	
}
