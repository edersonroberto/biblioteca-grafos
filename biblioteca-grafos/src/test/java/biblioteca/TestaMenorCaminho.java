package biblioteca;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestaMenorCaminho {
	
	private Grafo grafo;
	
	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste();
		grafo = grafoTeste.criaGrafoSimples();
		
	}
	
	@Test
	public void testeMenorCaminho(){
		String esperado = "0 1 2 3 \n2";
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
