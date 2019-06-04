package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
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

	public void confirmar(ActionEvent evt) throws Exception {
		if(cargo.getNomeCargo().isEmpty()) {
			UtilFaces.addMensagemFaces("Os Campos Nome é Salário devem ser informados");
		}
		else if(cargo.getSalario() == null) {
			UtilFaces.addMensagemFaces("Os Campos Nome é Salário devem ser informados");
		}
		else if(cargo.getNomeCargo().length() > 40) {
			UtilFaces.addMensagemFaces("Números de caracteres maximos atingido");
		}
		else if (cargo.getId()== null) {
			cargoDao.incluir(cargo);
			listar(evt);
			cargo = new Cargo();
			UtilFaces.addMensagemFaces("Cargo Salvo com sucesso");
		} else {
			try {
				cargoDao.alterar(cargo);
				UtilFaces.addMensagemFaces("Cargo Salvo com sucesso");
				listar(evt);
				cargo = new Cargo();
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao Alterar o Cargo " + cargo.getId());
			}
		}
		
	}

	public void listar(ActionEvent evt) {
		try {
			cargos = cargoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar os cargos");
		}
	}
	
	public void selecionarCargosParaEdicao(Cargo cargo) {
		try {
			this.cargo = cargoDao.consultar(cargo.getId());
		} catch (Exception e) {
		}
	}
	
	public void excluir(Cargo cargo) {
		try {
			cargoDao.excluirPorId(cargo.getId());
			UtilFaces.addMensagemFaces("Cargo " + cargo.getNomeCargo() + " Deletado");
			cargos = cargoDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao deletar o cargo " + cargo.getNomeCargo());

		}
		
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
