package br.com.senai.fatesg.primefaces.testecontrole;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.senai.fatesg.primefaces.controle.CargoControl;
import junit.framework.TestCase;

public class TestCargoControl extends TestCase {
	private CargoControl car;
	protected void setUp() throws Exception {
		super.setUp();
		car = new CargoControl();
		car.getCargo().setId(5);
		
	}

	@Test
	public void testConfirmar() {
		assertNotNull(car);
	}
	
	@Test
	public void testListar() {
		assertNotNull(car);
	}

	@Test
	public void testSelecionarCargosParaEdicao() {
		assertNotEquals(car.getCargo().getId(), 7);
	}

	@Test
	public void testExcluir() {
		assertNotEquals(car.getCargo().getId(), 5 );
	}

}
