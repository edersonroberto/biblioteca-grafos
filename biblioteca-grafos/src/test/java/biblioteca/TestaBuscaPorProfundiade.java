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
	public void TesteBuscaPorLargura(){
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino D foi encontrado.";
		
		resultado = grafo.buscaPorLargura("A", "B");
		assertEquals(esperado, resultado);
	}
	@Ignore
	@Test
	public void TesteBuscaPorLarguraOrigemNaoExisteNoGrafo(){
		
		Vertice vertice5 = new Vertice();
		vertice5.setNome("E");
		
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino não encontrado.";
		
		resultado = grafo.buscaPorLargura("A", "E");
		assertEquals(esperado, resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorLarguraGrafoDesconexo(){
		
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
