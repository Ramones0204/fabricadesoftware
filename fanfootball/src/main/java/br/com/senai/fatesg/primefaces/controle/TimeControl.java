package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;

import br.com.senai.fatesg.primefaces.entidade.Time;
import br.com.senai.fatesg.primefaces.persistencia.TimeDao;


@Named("TimeControl")
@Scope("conversation")
public class TimeControl {

	private Time time = new Time();
	@Autowired
	private TimeDao timeDao;

	private List<Time> times = new ArrayList<Time>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		
		if(time.getId() == 0) {
			try {
				timeDao.incluir(time);
				listar(evt);
				time = new Time();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
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
	
	
}
