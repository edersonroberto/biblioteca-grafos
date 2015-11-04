package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
		
	private List<String> vertices;
	private int matAdj[][];

	public Grafo(List<String> vertices, int matAdj[][]) {
		this.vertices = vertices;
		this.matAdj = matAdj;
	}
	
	
	public String buscaPorProfundidade(String origem, String alvo){
		
		String verticeAtual = null;
		List<String> lista = new ArrayList<String>();
		String caminho = "";
		Set<String> verticesVisitados = new HashSet<String>();
		int cont = 1;
		
		lista.add(origem);
		verticeAtual = origem;
		
		while(!verticeAtual.equals(alvo)){
			verticesVisitados.add(verticeAtual);
			caminho+= verticeAtual + " foi visitado.\n";
			
			for (int i = 0; i < vertices.size(); i++){
				if(verticeAtual.equals(vertices.get(i))){
					for(int j=0; j < vertices.size(); j++){
						if(matAdj[i][j] == 1){
							caminho += vertices.get(j);
							if(!lista.contains(vertices.get(j)))
								lista.add(vertices.get(j));
						}
					}
				}
			}
			
			if(cont >= vertices.size())
				break;
			verticeAtual = lista.get(cont);
			cont ++;
		}
		
		for (String string : lista) {
			System.out.println(string);
		}
		return caminho;

	}

	public String buscaPorLargura(String origem, String alvo){
		
		String verticeAtual = null;
		List<String> lista = new ArrayList<String>();
		String caminho = "";
		Set<String> verticesVisitados = new HashSet<String>();
		int cont = 1;
		
		lista.add(origem);
		verticeAtual = origem;
		
		while(!verticeAtual.equals(alvo)){
			verticesVisitados.add(verticeAtual);
			caminho+= verticeAtual + " foi visitado.\n";
			
			for (int i = 0; i < vertices.size(); i++){
				if(verticeAtual.equals(vertices.get(i))){
					for(int j=0; j < vertices.size(); i++){
						if(matAdj[i][j] == 1){
							if(!lista.contains(vertices.get(j)))
								lista.add(vertices.get(j));
						}
					}
				}
			}
			
			verticeAtual = lista.get(cont);
			cont ++;
		}
		
		for (String string : lista) {
			System.out.println(string);
		}
		return caminho;

	}

	public String Dijkstra(String origem, String destino){

		String verticeAtual = null;
		String maisProxVerticeAtual = null;
		List<String> naoVisitados = new ArrayList<String>();
		HashMap<String, Integer> distancias = new HashMap<String, Integer>();
		HashMap<String, String> anteriores = new HashMap<String, String>();
		int distancia = 0 ;
		String retorno = "";
		
		//Percorre o vertice, coloca o na tabela de distancias e adiciona o vertice na lista de não visitados
		for (String vertice : vertices) {
			distancias.put(vertice, 2147483647);
			naoVisitados.add(vertice);
			anteriores.put(vertice, null);
		}
		
		verticeAtual = origem;
		maisProxVerticeAtual = origem;
		distancias.replace(verticeAtual, 0);
		
		//Faz um loop até que a lista de não visitados esteja vazia
		while(!naoVisitados.isEmpty()){
			
			naoVisitados.remove(verticeAtual);
			
			for (int i=0; i < vertices.size(); i++){
				
				
				
			}
			verticeAtual = maisProxVerticeAtual;
			
		}
	
		return retorno;
	}

}
