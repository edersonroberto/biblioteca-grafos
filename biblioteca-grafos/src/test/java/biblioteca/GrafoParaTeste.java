package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class GrafoParaTeste {

	private static String vertice1 ;
	private static String vertice2;
	private static String vertice3;
	private static String vertice4;
	private static String vertice5;
	private static List<String> vertices;
	private static List<Aresta> arestas;
	private static Aresta aresta;
	private static int matAdj[][];
	
	public GrafoParaTeste() {
		
	}

	private static void inicializaAresta() {

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

	private static int[][] montaMatAdj() {
		int matAdj[][] = {{0,1,1,0,0},
			  	 		  {1,0,1,0,0},
			  	 		  {1,1,0,1,0},
			  	 		  {0,0,1,0,1},
			  	 		  {0,0,0,1,0}};
		return matAdj;
	}

	//retorna o grafo criado no construtor
	public static Grafo criaGrafoSimples(){
		inicializaVertices("0", "1", "2", "3", "4");
		inicializaListaVertices();
		matAdj = montaMatAdj();
		inicializaAresta();
		
		return new Grafo(vertices, matAdj, arestas, true, false, false);
	}
	
	public static Grafo criaGrafoDesconexo(){
		inicializaVertices("0", "1", "2", "3", "4");
		inicializaListaVertices();
		int matAdj[][] ={{0,1,0,1},{1,0,0,1},{0,0,0,0},{1,1,0,0}};
		
		
		Grafo grafoDesconexo = new Grafo(vertices, matAdj, arestas, false, false,false);
		
		return grafoDesconexo;
	}
	
	public static Grafo criaGrafoPonderado(){
		inicializaVertices("0", "1", "2", "3", "4");
		inicializaListaVertices();
		int matAdjAux[][] ={{0,10,0,12,0},{10,0,0,6,0},{0,0,0,9,15},{12,6,9,0,0},{0,0,15,0,0}}; 
		matAdj = matAdjAux;
		
		inicializaAresta();
		
		Grafo grafoPonderado = new Grafo(vertices, matAdj, arestas, true, true, false);
		
		return grafoPonderado;
	}

	private static void inicializaVertices(String v1, String v2, String v3, String v4, String v5) {
		vertice1 = v1;
		vertice2 = v2;
		vertice3 = v3;
		vertice4 = v4;
		vertice5 = v5;
	
	}
	
	private static void inicializaListaVertices() {
		vertices = new ArrayList<String>();
		
		//Adiciona os vertices na lista
		vertices.add(vertice1);
		vertices.add(vertice2);
		vertices.add(vertice3);
		vertices.add(vertice4);
		vertices.add(vertice5);
		
	}

	public static Grafo criaGrafoRotulado() {

		inicializaVertices("A", "B", "C", "D", "E");
		inicializaListaVertices();
		matAdj = montaMatAdj();
		inicializaAresta();
		Grafo grafoRotulado = new Grafo(vertices, matAdj, arestas, true, false, false);
		
		return grafoRotulado;
	}

	
}
