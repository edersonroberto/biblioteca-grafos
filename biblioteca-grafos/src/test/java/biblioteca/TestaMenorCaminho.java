package biblioteca;

import org.junit.Before;
import org.junit.Test;

public class TestaMenorCaminho {
	
	private Grafo grafo;
	private Vertice origem, destino;
	
	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste("direcionado");
		grafo = grafoTeste.criaGrafo();
		
	}
	
	@Test
	public void testeMenorCaminho(){
		String retorno;
		retorno = grafo.Dijkstra("A", "B");
		System.out.println(retorno);
	}
}
