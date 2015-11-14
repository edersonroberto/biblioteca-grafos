package biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestaBuscaPorLargura {
	
	private Grafo grafo;
	private Busca busca;
	@Before
	public void criaGrafo(){
		
		grafo = GrafoParaTeste.criaGrafoRotulado();
		busca = new Busca();
	}

	@Test
	public void TesteBuscaPorLargura(){
		String resultado = "";
		String esperado = "Largura A D:\n"
				+ "A foi visitado.\nB C são vizinhos de A.\n"
				+ "B foi visitado.\nA C são vizinhos de B.\n"
				+ "C foi visitado.\nA B D são vizinhos de C.\n"
				+ "D foi visitado.\nDestino D foi encontrado.\n";
		
		resultado = busca.buscaPorLargura(grafo, "A", "D");
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void TesteBuscaPorLarguraOrigemNaoExisteNoGrafo(){
				
		String resultado = "";
		String esperado = "Largura F A:\n"
						+ "Não foi possivél executar operação.\n"
						+ "Origem não existe no grafo.\n";
				
		resultado = busca.buscaPorLargura(grafo, "F", "A");
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void TesteBuscaPorLarguraDestinoNaoExisteNoGrafo(){
				
		String resultado = "";
		String esperado = "Largura A F:\n"
						+ "Não foi possivél executar operação.\n"
						+ "Destino não existe no grafo.\n";
				
		resultado = busca.buscaPorLargura(grafo, "A", "F");
		assertEquals(esperado, resultado);
	}
	
	
	@Test
	public void testeBuscaPorProfundidadeOrdemInversa(){
		
		String esperado = "Largura D A:\n"
				+ "D foi visitado.\nC E são vizinhos de D.\n"
				+ "C foi visitado.\nA B D são vizinhos de C.\n"
				+ "E foi visitado.\nD é vizinho de E.\n"
				+ "A foi visitado.\nDestino A foi encontrado.\n";
		
		String resultado = busca.buscaPorLargura(grafo, "D", "A");
		assertEquals(esperado, resultado);
		
	}
	
}
