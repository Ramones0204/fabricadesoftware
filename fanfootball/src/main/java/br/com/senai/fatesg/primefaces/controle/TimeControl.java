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
		if (time.getNomeTime().isEmpty()) {
			UtilFaces.addMensagemFaces("Favor informar o nome do time");
		}
		if (time.getTipoTime().equals("Clube")) {
			if (time.getRegiao().isEmpty()) {
				UtilFaces.addMensagemFaces("Favor informar a Região do time");
			} else if (time.getEstado().isEmpty()) {
				UtilFaces.addMensagemFaces("Favor informar a estado do time");
			} else if (!time.getPais().equals("Brasil")) {
				UtilFaces.addMensagemFaces("Para o tipo clube deve ser informado o pais Brasil");
			}

			else if (time.getId() == 0) {
				try {
					time.setLiga(liga);
					timeDao.incluir(time);
					UtilFaces.addMensagemFaces("Time salvo com sucesso");
					listar(evt);
					time = new Time();
				} catch (Exception e) {
					UtilFaces.addMensagemFaces(e.getMessage() + "Erro ao salvar o time");
				}
			} else {
				time.setLiga(liga);
				timeDao.alterar(time);
				listar(evt);
				time = new Time();
			}
		}

		else if (time.getTipoTime().equals("Seleção")) {
			if (time.getPais().equals("")) {
				UtilFaces.addMensagemFaces("Favor informar o pais da seleção");
			} else if (!time.getRegiao().equals("")) {
				UtilFaces.addMensagemFaces("não pode ser informado a região para o tipo seleção");
			} else if (!time.getEstado().equals("")) {
				UtilFaces.addMensagemFaces("não pode ser informado o estado para o tipo seleção");
			}

			else if (time.getId() == 0) {
				try {
					time.setLiga(liga);
					timeDao.incluir(time);
					UtilFaces.addMensagemFaces("Seleção salva com sucesso");
					listar(evt);
					time = new Time();
				} catch (Exception e) {
					UtilFaces.addMensagemFaces("Erro ao salvar a seleção");
				}
			} else {
				time.setLiga(liga);
				timeDao.alterar(time);
				listar(evt);
				time = new Time();
			}
		} else if (time.getTipoTime().equals("Internacional")) {
			if (time.getPais().equals("")) {
				UtilFaces.addMensagemFaces("Favor informar o pais da time");
			} else if (!time.getRegiao().equals("")) {
				UtilFaces.addMensagemFaces("não pode ser informado a região para o tipo internacional");
			} else if (!time.getEstado().equals("")) {
				UtilFaces.addMensagemFaces("não pode ser informado o estado para o tipo internacional");
			} else if (time.getPais().equals("Brasil")) {
				UtilFaces.addMensagemFaces("O pais não pode ser o Brasil");
			}

			else if (time.getId() == 0) {
				try {
					time.setLiga(liga);
					timeDao.incluir(time);
					UtilFaces.addMensagemFaces("Time salvo com sucesso");
					listar(evt);
					time = new Time();
				} catch (Exception e) {
					UtilFaces.addMensagemFaces("Erro ao salvar");
				}
			} else {
				time.setLiga(liga);
				timeDao.alterar(time);
				listar(evt);
				time = new Time();
			}
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
			ligas = new ArrayList<Liga>();
			ligas = ligaDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e.getMessage());
		}
	}

	public void excluir(Time time) {
		timeDao.excluirPorId(time.getId());
		times = timeDao.listar();

	}

	public void selecionarTimes(Time time) {

		try {
			this.time = timeDao.consultar(time.getId());
			// this.time.getLiga().getNomeLiga();

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
