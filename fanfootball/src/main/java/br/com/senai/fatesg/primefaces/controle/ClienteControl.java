package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Cliente;
import br.com.senai.fatesg.primefaces.entidade.Contato;
import br.com.senai.fatesg.primefaces.persistencia.ClienteDao;
import br.com.senai.fatesg.primefaces.util.SendEmail;

@Named("ClienteControl")
@Scope("conversation")
public class ClienteControl  {

	private Cliente cliente = new Cliente();
	private Contato contato = new Contato();
	@Autowired
	private ClienteDao clienteDao;
	private List<Cliente> clientes = new ArrayList<Cliente>();

	@PostConstruct
	public void init() {
		listar(null);
		cliente.setContato(contato);
	}

	public void confirmar(ActionEvent evt) {

		if (cliente.getNome().isEmpty() || cliente.getNomeSocial().isEmpty()) {
			UtilFaces.addMensagemFaces("O Campo Nome e Nome Social devem ser informados");
		}
		if (cliente.getNome().length() > 45) {
			UtilFaces.addMensagemFaces("Tamanho invalido");
		}
		if (cliente.getContato().getEmail().length() > 80) {
			UtilFaces.addMensagemFaces("Tamanho invalido");

		}
		if (cliente.getNomeSocial().length() > 45) {
			UtilFaces.addMensagemFaces("Tamanho invalido");
		}
		if (cliente.getContato().getEmail().isEmpty()) {
			UtilFaces.addMensagemFaces("O email deve ser informado");
		}
		if (cliente.getCpf().isEmpty()) {
			UtilFaces.addMensagemFaces("O CPF deve ser informado");
		}
		if (!cliente.getCpf().isEmpty()) {
			if (cliente.getCpf().equals("00000000000") || cliente.getCpf().equals("11111111111")
					|| cliente.getCpf().equals("2222222222") || cliente.getCpf().equals("3333333333")
					|| cliente.getCpf().equals("4444444444") || cliente.getCpf().equals("5555555555")
					|| cliente.getCpf().equals("6666666666") || cliente.getCpf().equals("7777777777")
					|| cliente.getCpf().equals("8888888888") || cliente.getCpf().equals("9999999999")) {
				UtilFaces.addMensagemFaces("CPF invalido");
			} else if (cliente.getId() == 0) {
				try {
					clienteDao.incluir(cliente);
					SendEmail s = new SendEmail(cliente.getContato().getEmail());
					s.start();
					UtilFaces.addMensagemFaces("Cliente Salvo com sucesso");
					listar(evt);
					//cliente = new Cliente();
				} catch (Exception e) {
					UtilFaces.addMensagemFaces("Erro ao inserir o cliente");
					UtilFaces.addMensagemFaces("CPF ou Email já cadastrado" );
					UtilFaces.addMensagemFaces(e.getMessage());
					
				}
			} else {
				try {
					clienteDao.alterar(cliente);
					UtilFaces.addMensagemFaces("Cliente" + cliente.getNome() + " Alterado com sucesso");
					listar(evt);
					// cliente = new Cliente();
				} catch (Exception e) {
					UtilFaces.addMensagemFaces("Erro ao Deletar o Cliente " + cliente.getId());
				}
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

	public void excluir(Cliente cliente) {
		try {
			clienteDao.excluirPorId(cliente.getId());
			UtilFaces.addMensagemFaces("Cliente " + cliente.getNome() + "Excluido com sucesso");
			clientes = clienteDao.listar();
		} catch (Exception e) {

		}

	}

	public void selecionarClienteParaEdicao(Cliente cliente) {
		try {
			this.cliente = clienteDao.consultar(cliente.getId());
		} catch (Exception e) {
			// TODO: handle exception
			UtilFaces.addMensagemFaces("Erro ao Consultar CLiente");
		}

	}

	public void enviarEmail(Cliente cliente)  {
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("fanfootballads@gmail.com", "futebol.10"));
			email.setSSLOnConnect(true);
			email.setFrom("fanfootballads@gmail.com");
			email.setSubject("Email de confirmação");
			email.setMsg("Seja Bem Vindo a fanfootball");
			email.addTo(cliente.getContato().getEmail());
			email.send();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public String limpar() {
		cliente.setId(0);
		cliente.setNome("");
		cliente.setNomeSocial("");
		cliente.setGenero("");
		cliente.setCpf("");
		cliente.setDataNascimento("");
		cliente.setSenha("");
		cliente.getContato().setEmail("");
		cliente.getContato().setTelefoneCelular("");
		cliente.getContato().setTelefoneFixo("");
		cliente.setSexo("");
		return "";
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
