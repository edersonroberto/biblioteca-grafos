package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestaDistancia {
	
	private Grafo grafo;
	
	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste();
		grafo = grafoTeste.criaGrafoPonderado();
		
	}
	
	@Test
	public void testeCalculoDistancia(){
		String caminho[] = {"0", "1", "3"};
		String esperado = "Distancia 0 1 3:\n16";
		assertEquals(esperado, grafo.distancia(caminho));
	}
	
	@Test
	public void testeCalculoDistancia4Vertices(){
		String caminho[] = {"0", "1", "3","2"};
		String esperado = "Distancia 0 1 3 2:\n25";
		assertEquals(esperado, grafo.distancia(caminho));
		
	}

}
