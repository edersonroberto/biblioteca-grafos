package biblioteca;

import java.util.ArrayList;

public class GrafoParaTeste {

	private Grafo grafo;
	private String vertice1, vertice2, vertice3, vertice4 ;
	private ArrayList<String> vertices;
	private int matAdj[][];
	
	public GrafoParaTeste() {

		// inicializa os Vertices
		inicializaVertices();

		// inicializa a lista de Vertices
		inicializaListaVertices();

		// inicializa as Arestas
		//matAdj = new int [3][3];
		matAdj = montaMatAdj(); 

		// Grafo
		grafo = new Grafo(vertices, matAdj);

	}

	private int[][] montaMatAdj() {
		int matAdj[][] = {{0,1,1,0},
			  	 		  {1,0,1,0},
			  	 		  {1,1,0,1},
			  	 		  {0,0,1,0}};
		return matAdj;
	}

	//retorna o grafo criado no construtor
	public Grafo criaGrafoSimples(){
		return grafo;
	}
	
	public Grafo criaGrafoDesconexo(){
		this.inicializaVertices();
		this.inicializaListaVertices();
		int matAdj[][] ={{0,1,0,1},{1,0,0,1},{0,0,0,0},{1,1,0,0}}; 
		
		Grafo grafoDesconexo = new Grafo(this.vertices, matAdj);
		
		return grafoDesconexo;
	}
	
	public Grafo criaGrafoPonderado(){
		this.inicializaVertices();
		this.inicializaListaVertices();
		int matAdj[][] ={{0,10,0,12},{10,0,0,6},{0,0,0,9},{12,6,9,0}}; 
		
		Grafo grafoPonderado = new Grafo(this.vertices, matAdj);
		
		return grafoPonderado;
	}

	private void inicializaVertices() {
		vertice1 = "0";
		vertice2 = "1";
		vertice3 = "2";
		vertice4 = "3";
	
		
	}
	
	private void inicializaListaVertices() {
		vertices = new ArrayList<String>();
		
		//Adiciona os vertices na lista
		vertices.add(vertice1);
		vertices.add(vertice2);
		vertices.add(vertice3);
		vertices.add(vertice4);
		
	}

	
}
