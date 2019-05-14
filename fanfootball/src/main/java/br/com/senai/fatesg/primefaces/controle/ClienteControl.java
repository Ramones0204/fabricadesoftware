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
import br.com.senai.fatesg.primefaces.entidade.Contato;
import br.com.senai.fatesg.primefaces.persistencia.ClienteDao;
import br.com.senai.fatesg.primefaces.util.ValidaCPF;

@Named("ClienteControl")
@Scope("conversation")
public class ClienteControl {
	private Cliente cliente = new Cliente();
	private Contato contato = new Contato();
	@Autowired
	private ClienteDao clienteDao;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	ValidaCPF cpf = new ValidaCPF();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		cliente.setContato(contato);
		cpf.isCPF(cliente.getCpf());
		if(cliente.getNome().isEmpty() & cliente.getNomeSocial().isEmpty())  {
			UtilFaces.addMensagemFaces("O Campo Nome e Nome Social devem ser informados");
		}
		if(cliente.getContato().getEmail().isEmpty()) {
			UtilFaces.addMensagemFaces("O email deve ser informado");
		}
		if(cliente.getCpf().isEmpty()) {
			UtilFaces.addMensagemFaces("O CPF deve ser informado");
		}
		else if (cliente.getId() == 0) {
			try {
				clienteDao.incluir(cliente);
				listar(evt);
				cliente = new Cliente();
				UtilFaces.addMensagemFaces("Cliente Salvo com sucesso");
			} catch (Exception e) {
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
			UtilFaces.addMensagemFaces("Erro ao listar os clientes");
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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
