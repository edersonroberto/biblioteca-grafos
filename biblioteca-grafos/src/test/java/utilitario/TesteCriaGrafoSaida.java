package utilitario;

import org.junit.Test;

import biblioteca.Grafo;
import biblioteca.GrafoParaTeste;

public class TesteCriaGrafoSaida {

	@Test
	public void testaCriarJson(){
		
		Grafo grafo = GrafoParaTeste.criaGrafoRotulado();
	
		CriaGrafoSaida.CriarSaidaGrafo(grafo, "principal");
		
	}
}
