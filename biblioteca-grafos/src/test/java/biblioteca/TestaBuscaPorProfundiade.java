package biblioteca;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biblioteca.Aresta;
import biblioteca.Grafo;
import biblioteca.Vertice;

public class TestaBuscaPorProfundiade {
	
	private Grafo grafo;
	private Vertice vertice1, vertice2;

	@Before
	public void criaGrafo(){
		
		GrafoParaTeste grafoTeste = new GrafoParaTeste("simples");
		grafo = grafoTeste.criaGrafo();
		vertice1 = grafoTeste.recuperaVertice(1);
		vertice2 = grafoTeste.recuperaVertice(4);
		
	}



	@Test
	public void TesteBuscaPorLargura(){
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino D foi encontrado.";
		
		resultado = grafo.buscaPorLargura(vertice1, vertice2);
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void TesteBuscaPorLarguraOrigemNaoExisteNoGrafo(){
		
		Vertice vertice5 = new Vertice();
		vertice5.setNome("E");
		
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino não encontrado.";
		
		resultado = grafo.buscaPorLargura(vertice1, vertice5);
		assertEquals(esperado, resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorLarguraGrafoDesconexo(){
		
		Vertice vertice5 = new Vertice();
		vertice5.setNome("E");
		grafo.addVertices(vertice5);
		
		String resultado = "";
		
		//assertEquals(esperado, resultado);
		
	}
	

	@Test
	public void testeBuscaPorProfundidade(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade(vertice1, vertice2);
		System.out.println(resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorProfundidadeOrdemInversa(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade(vertice2, vertice1);
		System.out.println(resultado);
	}
}
