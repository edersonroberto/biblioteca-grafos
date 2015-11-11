package biblioteca;

import static org.junit.Assert.assertEquals;

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
		String esperado = "Menor Caminho 0 4:\n"
				+"0 3 2 4\n36";
		assertEquals(esperado, grafo.Dijkstra("0", "4"));
		
	}

	@Test
	public void testeMenorCaminhoOrdemInversa(){
		String esperado = "Menor Caminho 4 0:\n"
						  + "4 2 3 0\n36";
		assertEquals(esperado, grafo.Dijkstra("4", "0"));
	
	}

	@Test
	public void testeMenorCaminhoDestinoInesistente(){
		String esperado = "Menor Caminho 3 7:\n"
				+ "Não foi possivél realizar operação.\n"
				+ "Destino não existe no grafo.\n";
		assertEquals(esperado, grafo.Dijkstra("3", "7"));
	
	}
	
	@Test
	public void testeMenorCaminhoOrigemInesistente(){
		String esperado = "Menor Caminho 7 2:\n"
				+ "Não foi possivél realizar operação.\n"
				+ "Origem não existe no grafo.\n";
		assertEquals(esperado, grafo.Dijkstra("7", "2"));
	
	}
}
