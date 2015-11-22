package utilitario;

import org.junit.Test;

import biblioteca.Grafo;
import biblioteca.GrafoParaTeste;

public class TesteCriaGrafoSaida {

	@Test
	public void testaCriarJson(){
		
		Grafo grafo = GrafoParaTeste.criaGrafoRotulado();
		String diretorio = "C:/saida/";
		CriaGrafoSaida.CriarSaidaGrafo(grafo,diretorio, "principal", null);
		
	}
}
