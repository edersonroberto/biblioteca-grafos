package biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestaBuscaPorProfundiade {
	
	private Grafo grafo;
	private Vertice vertice1, vertice2;

	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste("simples");
		grafo = grafoTeste.criaGrafo();
		
	}


	@Ignore
	@Test
	public void TesteBuscaPorProfundidade(){
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino D foi encontrado.";
		
		resultado = grafo.buscaPorProfundidade("A", "B");
		assertEquals(esperado, resultado);
	}

	@Test
	public void TesteBuscaPorProfundidadeDestinoNaoExisteNoGrafo(){
		
		String resultado = "";
		String esperado = "0 foi visitado.\n1 2 são vizinhos de 0.\n1 foi visitado.\n"
						+ "2 é vizinho de 1.\n2 foi visitado.\n"
						+ "3 é vizinho de 2.\n"
						+ "3 foi visitado.\n2 é vizinho de 3."
						+ "\nDestino não encontrado.";
		
		resultado = grafo.buscaPorProfundidade("0", "4");
		assertEquals(esperado, resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorProfundidadeGrafoDesconexo(){
		
		//Vertice vertice5 = new Vertice();
		//vertice5.setNome("E");
		//grafo.addVertices(vertice5);
		
		String resultado = "";
		
		//assertEquals(esperado, resultado);
		
	}
	

	@Test
	public void testeBuscaPorProfundidade(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade("0", "3");
		System.out.println(resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorProfundidadeOrdemInversa(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade("3", "0");
		System.out.println(resultado);
	}
}
