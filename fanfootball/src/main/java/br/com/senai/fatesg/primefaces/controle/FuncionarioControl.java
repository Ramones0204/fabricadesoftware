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
import br.com.senai.fatesg.primefaces.entidade.Contato;
import br.com.senai.fatesg.primefaces.entidade.Funcionario;
import br.com.senai.fatesg.primefaces.persistencia.CargoDao;
import br.com.senai.fatesg.primefaces.persistencia.FuncionarioDao;

@Named("FuncionarioControl")
@Scope("conversation")
public class FuncionarioControl {
	private Funcionario funcionario = new Funcionario();
	private Contato contato = new Contato();
	@Autowired
	private FuncionarioDao funcionarioDao;
	private List<Funcionario> funcionarios= new ArrayList<Funcionario>();
	private Cargo cargo = new Cargo();
	private List<Cargo> cargos;
	@Autowired
	private CargoDao cargoDao ;
	@PostConstruct
	public void init() {
		listar(null);
		listarCargos();
		this.funcionario.setContato(contato);
	}
	
	public void confirmar(ActionEvent evt) {
		funcionario.setCargo(cargo);
	
		if(funcionario.getNome().isEmpty())  {
			UtilFaces.addMensagemFaces("O Campo Nome devem ser informados");
		}
		if(funcionario.getContato().getEmail().isEmpty()) {
			UtilFaces.addMensagemFaces("O email deve ser informado");
		}
		if(funcionario.getCpf().isEmpty()) {
			UtilFaces.addMensagemFaces("O CPF deve ser informado");
		}
		else if (funcionario.getMatricula()== 0) {
			try {
				funcionarioDao.incluir(funcionario);
				listar(evt);
				//funcionario = new Funcionario();
				UtilFaces.addMensagemFaces("funcionario Salvo com sucesso");
			} catch (Exception e) {
				UtilFaces.addMensagemFaces("Erro ao inserir o funcionario");
			}
		} else {
			try {
				funcionarioDao.alterar(funcionario);
				UtilFaces.addMensagemFaces("funcionario" + funcionario.getNome() + " Alterado com sucesso");
				listar(evt);
				//funcionario = new Funcionario();
			} catch (Exception e) {
				UtilFaces.addMensagemFaces("Erro ao Deletar o funcionario " + funcionario.getMatricula());
			}
		}
	}
	public void listar(ActionEvent evt) {
		try {
			funcionarios = funcionarioDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Erro ao listar os funcionarios");
		}
	}
	
	public void listarCargos() {
		try {
			cargos = cargoDao.listar();
		} catch (Exception e) {
			// TODO: handle exception
			UtilFaces.addMensagemFaces("Erro ao listar os Cargos");
		}
	}
	
	public void excluir(Funcionario funcionario) {
		try {
			funcionarioDao.excluirPorId(funcionario.getMatricula());
			UtilFaces.addMensagemFaces("funcionario " + funcionario.getNome() + "Excluido com sucesso");
			funcionarios = funcionarioDao.listar();
		} catch (Exception e) {
			
		}
		
	}

	public void selecionarFuncinarioParaEdicao(Funcionario funcionario) {
		try {
			this.funcionario = funcionarioDao.consultar(funcionario.getMatricula());
			System.out.println(this.funcionario.getContato().getEmail());
			System.out.println(this.funcionario.getContato().getTelefoneCelular());
			System.out.println(this.funcionario.getContato().getTelefoneFixo());
		
		} catch (Exception e) {
			// TODO: handle exception
			UtilFaces.addMensagemFaces("Erro ao Consultar CLiente"	);
		}
	
	}
	
	public String limpar() {
		funcionario.setMatricula(0);
		funcionario.setNome("");
		funcionario.setCpf("");
		funcionario.setDataNascimento("");
		funcionario.setSenha("");
		funcionario.getContato().setEmail("");
		funcionario.getContato().setTelefoneCelular("");
		funcionario.getContato().setTelefoneFixo("");
		return "";
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
}