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
		origem = grafoTeste.recuperaVertice(0);
		destino = grafoTeste.recuperaVertice(3);
		
	}
	
	@Test
	public void testeMenorCaminho(){
		String retorno;
		retorno = grafo.Dijkstra(origem, destino);
		System.out.println(retorno);
	}
}
