package br.com.senai.fatesg.primefaces.testecontrole;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.com.senai.fatesg.primefaces.controle.CargoControl;
import br.com.senai.fatesg.primefaces.controle.FuncionarioControl;
import junit.framework.TestCase;

public class TestFuncionarioControl extends TestCase{
	private FuncionarioControl funcion, delfun;

	protected void setUp() throws Exception {
		super.setUp();
		funcion = new FuncionarioControl();
		delfun = new FuncionarioControl();
		funcion.getFuncionario().setNome("Matheus");
		funcion.getCargo().setId(5);
		funcion.getCargos();
		
	}

	@Test
	public void testConfirmar() {
		assertNotNull(funcion);
	}

	@Test
	public void testListar() {
		assertEquals("Matheus", funcion.getFuncionario().getNome());
	}

	@Test
	public void testListarCargos() {
		assertNotEquals(5, funcion.getCargo().getId());
	}

	@Test
	public void testExcluir() {
		assertNotNull(funcion);
	}

	@Test
	public void testSelecionarFuncinarioParaEdicao() {
		assertNotNull(funcion);
	}

	@Test
	public void testLimpar() {
		assertNotNull(funcion);
	}

}
