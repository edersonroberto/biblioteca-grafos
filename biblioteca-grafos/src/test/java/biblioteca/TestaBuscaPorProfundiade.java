package biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestaBuscaPorProfundiade {
	
	private Grafo grafo;
	private GrafoParaTeste grafoTeste;

	@Before
	public void criaGrafo(){
		
		grafoTeste = new GrafoParaTeste();
		grafo = grafoTeste.criaGrafoSimples();
		
	}

	@Test
	public void TesteBuscaPorProfundidade(){
		grafo = grafoTeste.criaGrafoRotulado();
		String resultado = "";
		String esperado = "Profundidade A B:\n"
							+ "A foi visitado.\nB C são vizinhos de A.\n"
							+ "B foi visitado.\nDestino B foi encontrado.\n";
		
		resultado = grafo.buscaPorProfundidade("A", "B");
		assertEquals(esperado, resultado);
	}

	@Test
	public void TesteBuscaPorProfundidadeDestinoNaoExisteNoGrafo(){
		
		String resultado = "";
		String esperado = "Profundidade 0 4:\n"
						+ "0 foi visitado.\n1 2 são vizinhos de 0.\n1 foi visitado.\n"
						+ "0 2 são vizinhos de 1.\n2 foi visitado.\n"
						+ "0 1 3 são vizinhos de 2.\n"
						+ "3 foi visitado.\n2 4 são vizinhos de 3.\n"
						+"4 foi visitado.\nDestino 4 foi encontrado.\n";
		
		resultado = grafo.buscaPorProfundidade("0", "4");
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeBuscaPorProfundidadeOrdemInversa(){
		
		String esperado =  "Profundidade 4 0:\n"
				+ "4 foi visitado.\n3 é vizinho de 4.\n3 foi visitado.\n"
				+ "2 4 são vizinhos de 3.\n2 foi visitado.\n"
				+ "0 1 3 são vizinhos de 2.\n"
				+"0 foi visitado.\nDestino 0 foi encontrado.\n";
		
		assertEquals(esperado, grafo.buscaPorProfundidade("4", "0"));
		
		
	}
}
