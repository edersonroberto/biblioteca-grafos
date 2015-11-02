package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biblioteca.Aresta;
import biblioteca.Grafo;
import biblioteca.Vertice;

public class TestaBuscaPorLargura {
	
	private Grafo grafo;
	private Aresta aresta1, aresta2, aresta3,aresta4;
	private Vertice vertice1, vertice2, vertice3, vertice4 ;
	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;

	@Before
	public void criaGrafo(){
		
		//inicializa os Vertices
		inicializaVertices();
		
		//inicializa a lista de Vertices
		inicializaListaVertices();
		
		//inicializa as Arestas
		inicializaArestas();
		
		//inicializa lista de arestas
		inicializaListaArestas();
		
		
		//Grafo
		grafo = new Grafo(vertices, arestas);
		
	}



	@Test
	public void TesteBuscaPorLargura(){
		String resultado = "";
		String esperado = "A foi visitado.\nB C são vizinhos de A.\nB foi visitado.\nA C são vizinhos de B.\nC foi visitado.\nA B D são vizinhos de C.\nD foi visitado.\nDestino D foi encontrado.";
		
		resultado = grafo.buscaPorLargura(vertice1, vertice4);
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
		vertices.add(vertice5);
		
		Grafo grafo2 = new Grafo(vertices, arestas);
		
		String resultado = "";
		
		resultado = grafo2.buscaPorLargura(vertice1, vertice5);
		//assertEquals(esperado, resultado);
		
	}
	

	@Test
	public void testeBuscaPorProfundidade(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade(vertice1, vertice4);
		System.out.println(resultado);
	}
	
	@Ignore
	@Test
	public void testeBuscaPorProfundidadeOrdemInversa(){
		
		String resultado = "";
		
		resultado = grafo.buscaPorProfundidade(vertice4, vertice1);
		System.out.println(resultado);
	}
	
	
	
	
	private void inicializaArestas() {
		this.aresta1 = new Aresta();
		this.aresta2 = new Aresta();
		this.aresta3 = new Aresta();
		this.aresta4 = new Aresta();
		
		aresta1.setNome("a1");
		aresta1.setVertice1(vertice1);
		aresta1.setVertice2(vertice2);
		aresta1.setPeso("0");
		
		aresta2.setNome("a2");
		aresta2.setVertice1(vertice1);
		aresta2.setVertice2(vertice3);
		aresta2.setPeso("0");
		
		aresta3.setNome("a3");
		aresta3.setVertice1(vertice2);
		aresta3.setVertice2(vertice3);
		aresta3.setPeso("0");
		
		aresta4.setNome("a4");
		aresta4.setVertice1(vertice3);
		aresta4.setVertice2(vertice4);
		aresta4.setPeso("0");
	}
	

	private void inicializaListaArestas() {

		arestas = new ArrayList<Aresta>();
		
		arestas.add(aresta1);
		arestas.add(aresta2);
		arestas.add(aresta3);
		arestas.add(aresta4);
		
	}
	

	private void inicializaVertices() {
		this.vertice1 = new Vertice();
		this.vertice2 = new Vertice();
		this.vertice3 = new Vertice();
		this.vertice4 = new Vertice();
		
		vertice1.setNome("A");
		vertice2.setNome("B");
		vertice3.setNome("C");
		vertice4.setNome("D");
		
		
		
	}
	
	private void inicializaListaVertices() {
		vertices = new ArrayList<Vertice>();
		
		//Adiciona os vertices na lista
		vertices.add(vertice1);
		vertices.add(vertice2);
		vertices.add(vertice3);
		vertices.add(vertice4);
		
	}
}
