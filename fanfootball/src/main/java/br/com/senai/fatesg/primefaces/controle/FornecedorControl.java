package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Contato;
import br.com.senai.fatesg.primefaces.entidade.Endereco;
import br.com.senai.fatesg.primefaces.entidade.Fornecedor;
import br.com.senai.fatesg.primefaces.persistencia.FornecedorDao;

@Named("FornecedorControl")
@Scope("conversation")
public class FornecedorControl {
	
	@Autowired
	private FornecedorDao fornecedorDao;
	private Endereco endereco= new Endereco();
	private Fornecedor fornecedor = new Fornecedor();
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	@PostConstruct
	public void init() {
		listar(null);
		fornecedor.setEndereco(endereco);
	}
	
	public void confirmar(ActionEvent evt) throws Exception {
		if(fornecedor.getRazao().isEmpty()) {
			UtilFaces.addMensagemFaces("Os Campos Razão devem ser informados");
		}
		else if(fornecedor.getNomeFantasia().isEmpty()) {
			UtilFaces.addMensagemFaces("Os Campos Nome Fantasia devem ser informados");
		}
		else if(fornecedor.getCnpj().isEmpty()) {
			UtilFaces.addMensagemFaces("O CNPJ deve ser informado");
		}
		else if (fornecedor.getId()== 0) {
			fornecedorDao.incluir(fornecedor);
			listar(evt);
			fornecedor = new Fornecedor();
			UtilFaces.addMensagemFaces("Fornecedor Salvo com sucesso");
		} else { 
			try {
				fornecedorDao.alterar(fornecedor);
				UtilFaces.addMensagemFaces("Fornecedor Salvo com sucesso");
				listar(evt);
				fornecedor = new Fornecedor();
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao Alterar o Fornecedor " + fornecedor.getId());
			}
		}
		
	}
	
	public void listar(ActionEvent evt) {
		try {
			fornecedores = fornecedorDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar os Fornecedores");
		}
	}
	
	public void selecionarFornecedoresParaEdicao(Fornecedor fornecedor) {
		try {
			this.fornecedor = fornecedorDao.consultar(fornecedor.getId());
		} catch (Exception e) {
		}
	}
	
	public void excluir(Fornecedor fornecedor) {
		try {
			fornecedorDao.excluirPorId(fornecedor.getId());
			UtilFaces.addMensagemFaces("Fornecedor " +  fornecedor.getNomeFantasia() + " Deletado");
			fornecedores = fornecedorDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao deletar o Fornecedor " +fornecedor.getNomeFantasia());

		}
		
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
