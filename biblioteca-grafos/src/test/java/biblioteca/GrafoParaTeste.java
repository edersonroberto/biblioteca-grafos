package biblioteca;

import java.util.ArrayList;

public class GrafoParaTeste {

	private Grafo grafo;
	private String vertice1, vertice2, vertice3, vertice4 ;
	private ArrayList<String> vertices;
	private int matAdj[][];
	
	public GrafoParaTeste(String tipoGrafo) {

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
			  	 		  {1,0,1,1},
			  	 		  {0,0,1,0}};
		return matAdj;
	}

	//retorna o grafo criado no construtor
	public Grafo criaGrafo(){
		return grafo;
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
