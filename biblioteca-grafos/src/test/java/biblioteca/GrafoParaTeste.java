package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class GrafoParaTeste {

	private Grafo grafo;
	private String vertice1, vertice2, vertice3, vertice4, vertice5 ;
	private List<String> vertices;
	private List<Aresta> arestas;
	private Aresta aresta;
	private int matAdj[][];
	
	public GrafoParaTeste() {
		
	}

	private void inicializaAresta() {

		arestas = new ArrayList<Aresta>();
		
		for (int i=0; i < vertices.size(); i++){
			for(int j=0; j< vertices.size(); j++){
				if(matAdj[i][j] != 0){
					aresta = new Aresta(vertices.get(i), vertices.get(j), matAdj[i][j]);
				
					arestas.add(aresta);
				}
			}
		}
		
	}

	private int[][] montaMatAdj() {
		int matAdj[][] = {{0,1,1,0,0},
			  	 		  {1,0,1,0,0},
			  	 		  {1,1,0,1,0},
			  	 		  {0,0,1,0,1},
			  	 		  {0,0,0,1,0}};
		return matAdj;
	}

	//retorna o grafo criado no construtor
	public Grafo criaGrafoSimples(){
		this.inicializaVertices("0", "1", "2", "3", "4");
		this.inicializaListaVertices();
		this.matAdj = montaMatAdj();
		this.inicializaAresta();
		
		return new Grafo(vertices, matAdj, arestas);
	}
	
	public Grafo criaGrafoDesconexo(){
		this.inicializaVertices("0", "1", "2", "3", "4");
		this.inicializaListaVertices();
		int matAdj[][] ={{0,1,0,1},{1,0,0,1},{0,0,0,0},{1,1,0,0}};
		
		
		Grafo grafoDesconexo = new Grafo(this.vertices, this.matAdj, arestas);
		
		return grafoDesconexo;
	}
	
	public Grafo criaGrafoPonderado(){
		this.inicializaVertices("0", "1", "2", "3", "4");
		this.inicializaListaVertices();
		int matAdjAux[][] ={{0,10,0,12,0},{10,0,0,6,0},{0,0,0,9,15},{12,6,9,0,0},{0,0,15,0,0}}; 
		this.matAdj = matAdjAux;
		
		this.inicializaAresta();
		
		Grafo grafoPonderado = new Grafo(this.vertices, this.matAdj, this.arestas);
		
		return grafoPonderado;
	}

	private void inicializaVertices(String v1, String v2, String v3, String v4, String v5) {
		vertice1 = v1;
		vertice2 = v2;
		vertice3 = v3;
		vertice4 = v4;
		vertice5 = v5;
	
	}
	
	private void inicializaListaVertices() {
		vertices = new ArrayList<String>();
		
		//Adiciona os vertices na lista
		vertices.add(vertice1);
		vertices.add(vertice2);
		vertices.add(vertice3);
		vertices.add(vertice4);
		vertices.add(vertice5);
		
	}

	public Grafo criaGrafoRotulado() {

		this.inicializaVertices("A", "B", "C", "D", "E");
		this.inicializaListaVertices();
		this.matAdj = montaMatAdj();
		this.inicializaAresta();
		grafo = new Grafo(vertices, matAdj, arestas);
		
		return grafo;
	}

	
}
