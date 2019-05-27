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
		if (marca.getNomeMarca().isEmpty()) {
			UtilFaces.addMensagemFaces("Favor informar o Nome Da Marca");
		}
		if (marca.getNomeMarca().length() > 40) {
			UtilFaces.addMensagemFaces("Números de caracteres maximos atingido");
		} else if (marca.getId() == 0) {
			try {
				marcaDao.incluir(marca);
				listar(evt);
				marca = new Marca();
				UtilFaces.addMensagemFaces("Marca salva com Sucesso ");
			} catch (Exception e) {
				UtilFaces.addMensagemFaces("Erro ao Incluir a Marca");
			}
		} else {
			try {
				marcaDao.alterar(marca);
				UtilFaces.addMensagemFaces("Marca alterada com Sucesso");
				listar(evt);
				marca = new Marca();
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao Altar a Marca");
			}
		}

	}

	public void listar(ActionEvent evt) {
		try {
			marcas = marcaDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar as marcas ");
		}
	}

	public void excluir(Marca marca) {
		try {
			marcaDao.excluirPorId(marca.getId());


			UtilFaces.addMensagemFaces("Marca " + marca.getNomeMarca() + " Excluida com sucesso");
			marcas = marcaDao.listar();
		} catch (Exception e) {
			// TODO: handle exception
			UtilFaces.addMensagemFaces("Erro ao Excluir a Marca");
		}
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
