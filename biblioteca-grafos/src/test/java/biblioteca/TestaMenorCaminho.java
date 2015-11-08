package biblioteca;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestaMenorCaminho {
	
	private Grafo grafo;
	
	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste();
		grafo = grafoTeste.criaGrafoPonderado();
		
	}
	
	@Test
	public void testeMenorCaminho(){
		String esperado = "Menor Caminho 0 3:\n"
				+"0 1 3 \n16";
		assertEquals(esperado, grafo.Dijkstra("0", "3"));
		
	}
	
	@Test
	public void testeMenorCaminhoOrdemInversa(){
		String esperado = "3 2 0 1 \n2";
		assertEquals(esperado, grafo.Dijkstra("3", "0"));
	
	}
	@Test
	public void testeMenorCaminhoDestinoInesistente(){
		String esperado = "3 2 0 1 \nCaminho não encontrado!";
		assertEquals(esperado, grafo.Dijkstra("3", "7"));
	
	}
	
}
