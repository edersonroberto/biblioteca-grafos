package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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
		String esperado = "Menor Caminho 0 4:\n"
				+"0 3 2 4\n12";
		assertEquals(esperado, grafo.Dijkstra("0", "4"));
		
	}
	
	@Ignore
	@Test
	public void testeMenorCaminhoOrdemInversa(){
		String esperado = "Menor Caminho 3 2:\n"
						  + "3 2\n9";
		assertEquals(esperado, grafo.Dijkstra("3", "2"));
	
	}
	@Ignore
	@Test
	public void testeMenorCaminhoDestinoInesistente(){
		String esperado = "3 2 0 1 \nCaminho não encontrado!";
		assertEquals(esperado, grafo.Dijkstra("3", "7"));
	
	}
	
}
