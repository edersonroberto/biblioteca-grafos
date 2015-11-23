package utilitario;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import biblioteca.Grafo;
import biblioteca.GrafoParaTeste;

public class TesteCriaGrafoSaida {

	@Test
	public void testaCriarSaidaGrafo(){
		
		Grafo grafo = GrafoParaTeste.criaGrafoRotulado();
		String diretorio = "C:/saida/";
		CriaGrafoSaida.CriarSaidaGrafo(grafo,diretorio, "principal", null);
		
	}
	
	@Test
	public void testaCriarSaidaGrafoComErro(){
		
		assertEquals(false, GravaSaida.gravarSaida("vazio", "teste"));
		
		
	}
}
