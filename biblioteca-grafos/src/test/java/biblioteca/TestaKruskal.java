package biblioteca;

import org.junit.Before;
import org.junit.Test;

public class TestaKruskal {
	
	private Grafo grafo;
	
	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste();
		grafo = grafoTeste.criaGrafoPonderado();
		
	}
	
	@Test
	public void testeKruskal(){
		String esperado = "";
		esperado = grafo.kruskal();
		System.out.println(esperado);
	}

}
