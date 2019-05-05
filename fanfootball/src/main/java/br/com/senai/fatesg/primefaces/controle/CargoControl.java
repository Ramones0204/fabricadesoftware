package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import br.com.senai.fatesg.primefaces.entidade.Cargo;
import br.com.senai.fatesg.primefaces.persistencia.CargoDao;

@Named("CargoControl")
@Scope("conversation")
public class CargoControl {

	private Cargo cargo = new Cargo();

	@Autowired
	private CargoDao cargoDao;

	private List<Cargo> cargos = new ArrayList<Cargo>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		if(cargo.getId() == 0) {
			try {
				cargoDao.incluir(cargo);
				listar(evt);
				cargo = new Cargo();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			cargoDao.alterar(cargo);
			listar(evt);
			cargo = new Cargo();
		}
		
	}

	public void listar(ActionEvent evt) {
		try {
			cargos = cargoDao.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void selecionarCargosParaEdicao(Cargo cargo) {
		try {
			this.cargo = cargoDao.consultar(cargo.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void excluir(Cargo cargo) {
		cargoDao.excluirPorId(cargo.getId());
		cargos = cargoDao.listar();
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

}
