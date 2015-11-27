package utilitario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteGravaSaida {
	
	@Test(expected=RuntimeException.class)
	public void testaCriarSaidaGrafoComErro(){
		
		GravaSaida.gravarSaida("", "c:/saida/arquivoVazio.txt");
			
	}
	
	@Test
	public void testaGravarSaidaEmCaminhoNaoExistente(){
		
		assertEquals(false, GravaSaida.gravarSaida("teste", "M:/caminho/naoExiste.txt"));
	}
}
