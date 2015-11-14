package biblioteca;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestaPrim {
	
	@Test
	public void testePrimGrafoDesconexo(){
		
		String esperado = "Não é possivel realizar operação!\nGrafo não é conexo.\n";
		Grafo grafo = GrafoParaTeste.criaGrafoDesconexo();
		Prim prim = new Prim();
		
		assertEquals(esperado, prim.arvoreGeradoraMinima(grafo, "1"));
		
	}
	

	@Test
	public void testePrimGrafoConexoSimples(){
		
		String esperado = "Prim 1:\n"
				+ "1 0 1,\n"
				+ "1 2 1,\n"
				+ "2 3 1,\n"
				+ "3 4 1,\n"
				+ "4\n";
		Grafo grafo = GrafoParaTeste.criaGrafoSimples();
		Prim prim = new Prim();
		
		assertEquals(esperado, prim.arvoreGeradoraMinima(grafo, "1"));
	}

	@Test
	public void testePrimGrafoConexoPonderado(){
		
		String esperado = "Prim 0:\n"
				+ "0 1 10,\n"
				+ "1 3 6,\n"
				+ "3 2 9,\n"
				+ "2 4 15,\n"
				+ "40\n";
		Grafo grafo = GrafoParaTeste.criaGrafoPonderado();
		Prim prim = new Prim();
		assertEquals(esperado, prim.arvoreGeradoraMinima(grafo, "0"));
		
	}
}
