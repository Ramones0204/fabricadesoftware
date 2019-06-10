package br.com.senai.fatesg.primefaces.testecontrole;

import org.junit.Test;

import br.com.senai.fatesg.primefaces.controle.ClienteControl;
import junit.framework.TestCase;

public class TestClienteControl extends TestCase  {
	private ClienteControl client;
	protected void setup()throws Exception {
		super.setUp();
		client = new ClienteControl();
		client.getCliente().setId(9);
		
	}

	@Test
	public void testConfirmar() {
		assertNull(client);
	}

	@Test
	public void testListar() {
		assertNull(client);
	}

	@Test
	public void testExcluir() {
		assertNull(client);
	}

	@Test
	public void testSelecionarClienteParaEdicao() {
		assertNull(client);
	}

	@Test
	public void testLimpar() {
		assertNull(client);
	}

}
