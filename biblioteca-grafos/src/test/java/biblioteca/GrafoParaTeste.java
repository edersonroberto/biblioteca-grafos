package biblioteca;

import java.util.ArrayList;

public class GrafoParaTeste {

	private Grafo grafo;
	private Aresta aresta1, aresta2, aresta3,aresta4;
	private Vertice vertice1, vertice2, vertice3, vertice4 ;
	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	
	public GrafoParaTeste(String tipoGrafo) {

		// inicializa os Vertices
		inicializaVertices();

		// inicializa a lista de Vertices
		inicializaListaVertices();

		// inicializa as Arestas
		inicializaArestas();

		// inicializa lista de arestas
		inicializaListaArestas();

		// Grafo
		grafo = new Grafo(vertices, arestas);
		
		if (tipoGrafo.equals("direcionado")){
			setaPesoArestas();
		}

	}


	private void setaPesoArestas() {
		aresta1.setPeso(10);
		aresta2.setPeso(14);
		aresta3.setPeso(16);
		aresta4.setPeso(11);
		
	}


	//retorna o grafo criado no construtor
	public Grafo criaGrafo(){
		return grafo;
	}
	
	
	private void inicializaArestas() {
		this.aresta1 = new Aresta();
		this.aresta2 = new Aresta();
		this.aresta3 = new Aresta();
		this.aresta4 = new Aresta();
		
		aresta1.setNome("a1");
		aresta1.setVertice1(vertice1);
		aresta1.setVertice2(vertice2);
		aresta1.setPeso(0);
		
		aresta2.setNome("a2");
		aresta2.setVertice1(vertice1);
		aresta2.setVertice2(vertice3);
		aresta2.setPeso(0);
		
		aresta3.setNome("a3");
		aresta3.setVertice1(vertice2);
		aresta3.setVertice2(vertice3);
		aresta3.setPeso(0);
		
		aresta4.setNome("a4");
		aresta4.setVertice1(vertice3);
		aresta4.setVertice2(vertice4);
		aresta4.setPeso(0);
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

	public Vertice recuperaVertice(int i) {
		
		return vertices.get(i);
	}
	
}
