package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestaControladorPrincipal {
	
	@Test
	public void testeControladorPrincipal(){
		ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
		assertEquals(true, controladorPrincipal.controlaFluxo("arquivo.txt"));
		
	}

}
