package utilitario;

import static org.junit.Assert.*;

import org.junit.Test;

import biblioteca.Grafo;
import biblioteca.GrafoParaTeste;

public class TesteCriaGrafoSaida {

	@Test
	public void testaCriarSaidaGrafo(){
		
		Grafo grafo = GrafoParaTeste.criaGrafoRotulado();
		String diretorio = "C:/saida/";
		assertEquals(true, CriaGrafoSaida.CriarSaidaGrafo(grafo,diretorio, "principal", null));
		
	}
	
	@Test
	public void testaCriarSaidaGrafoComArquivoSemDados(){
		
		Grafo grafo = GrafoParaTeste.criaGrafoSimples();
		String diretorio = "G:/naoExistte/";
		assertEquals(false, CriaGrafoSaida.CriarSaidaGrafo(grafo, diretorio, "Vazio", null));
	}
	

}
