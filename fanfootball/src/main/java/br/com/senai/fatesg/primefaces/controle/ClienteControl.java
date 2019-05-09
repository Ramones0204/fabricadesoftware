package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Cliente;
import br.com.senai.fatesg.primefaces.persistencia.ClienteDao;

@Named("ClienteControl")
@Scope("conversation")
public class ClienteControl {
	private Cliente cliente = new Cliente();

	@Autowired
	private ClienteDao clienteDao;

	private List<Cliente> clientes = new ArrayList<Cliente>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		if(cliente.getNome().isEmpty()) {
			UtilFaces.addMensagemFaces("Os Campos Nome deve ser informado");
		}
		else if (cliente.getId() == 0) {
			try {
				clienteDao.incluir(cliente);
				listar(evt);
				cliente = new Cliente();
				UtilFaces.addMensagemFaces("Cliente Salvo com sucesso");
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao inserir o cliente");
			}
		} else {
			try {
				clienteDao.alterar(cliente);
				UtilFaces.addMensagemFaces("Cliente" + cliente.getNome() + " Alterado com sucesso");
				listar(evt);
				cliente = new Cliente();
			} catch (Exception e) {
				// TODO: handle exception
				UtilFaces.addMensagemFaces("Erro ao Deletar o Cliente " + cliente.getId());
			}
		}
		
	}
	public void listar(ActionEvent evt) {
		try {
			clientes = clienteDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar os cargos");
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
