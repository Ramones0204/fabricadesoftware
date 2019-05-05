package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.senai.fatesg.primefaces.entidade.Marca;
import br.com.senai.fatesg.primefaces.persistencia.MarcaDao;

@Named("MarcaControl")
@Scope("conversation")
public class MarcaControl {
	
	private Marca marca = new Marca();
	@Autowired
	private MarcaDao marcaDao;

	private List<Marca> marcas = new ArrayList<Marca>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		if(marca.getId() == 0) {
			try {
				marcaDao.incluir(marca);
				listar(evt);
				marca = new Marca();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			marcaDao.alterar(marca);
			listar(evt);
			marca = new Marca();
		}
		
	}

	public void listar(ActionEvent evt) {
		try {
			marcas = marcaDao.listar(); 
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void excluir(Marca marca) {
		marcaDao.excluirPorId(marca.getId());
		marcas = marcaDao.listar();

	}

	public void selecionarMarcas(Marca marca) {

		try {
			this.marca = marcaDao.consultar(marca.getId());
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}
	
	
	

}
