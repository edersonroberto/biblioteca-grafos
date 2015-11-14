package biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestaDistancia {
	
	private Grafo grafo;
	private Distancia distancia;
	
	@Before
	public void criaGrafo(){
		
		grafo = GrafoParaTeste.criaGrafoPonderado();
		distancia = new Distancia();
	}
	
	@Test
	public void testeCalculoDistancia(){
		String caminho[] = {"Distancia", "0", "1", "3"};
		String esperado = "Distancia 0 1 3:\n16\n";
		
		assertEquals(esperado, distancia.calculaDistancia(grafo, caminho));
	}
	

	@Test
	public void testeCalculoDistancia4Vertices(){
		String caminho[] = {"Distancia", "0", "1", "3","2"};
		String esperado = "Distancia 0 1 3 2:\n25\n";
		assertEquals(esperado, distancia.calculaDistancia(grafo, caminho));
		
	}

}
