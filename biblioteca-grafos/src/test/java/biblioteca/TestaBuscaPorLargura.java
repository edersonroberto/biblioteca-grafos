package biblioteca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestaBuscaPorLargura {
	
	private Grafo grafo;

	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste();
		grafo = grafoTeste.criaGrafoSimples();

	}

	@Test
	public void TesteBuscaPorLargura(){
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino D foi encontrado.";
		
		resultado = grafo.buscaPorLargura("A", "D");
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void TesteBuscaPorLarguraOrigemNaoExisteNoGrafo(){
		
		

		
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino não encontrado.";
		
		resultado = grafo.buscaPorLargura("A", "E");
		assertEquals(esperado, resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorLarguraGrafoDesconexo(){
		
	
	
		//grafo.addVertices(vertice5);
		
		//String resultado = "";
		
		//assertEquals(esperado, resultado);
		
	}
	

	@Test
	public void testeBuscaPorProfundidade(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade("A", "B");
		System.out.println(resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorProfundidadeOrdemInversa(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade("D", "A");
		System.out.println(resultado);
	}
	
}
