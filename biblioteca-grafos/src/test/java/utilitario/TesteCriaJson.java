package utilitario;

import org.junit.Test;

import biblioteca.Grafo;
import biblioteca.GrafoParaTeste;

public class TesteCriaJson {

	@Test
	public void testaCriarJson(){
		
		Grafo grafo = GrafoParaTeste.criaGrafoRotulado();
		
		CriaJson criaJson = new CriaJson();
		criaJson.CriarJon(grafo);
		
	}
}
