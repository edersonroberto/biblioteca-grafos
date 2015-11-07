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
	
	public String distancia(String[] caminho){
		
		for (int i = 0; i< vertices.size(); i++){
			if(caminho[0] == vertices.get(i)){
				//for()
			}
		}
		
		
		return null;
	}
	
	public String buscaPorProfundidade(String origem, String destino) {

		String verticeAtual = null;
		List<String> lista = new ArrayList<String>();
		String caminho = "Profundidade " + origem + " " + destino + ":\n" ;
		Set<String> verticesVisitados = new HashSet<String>();
		int cont = 1, qtdVerticesVizinhos = 0, qtdVerticesVizinhosAddLista = 0;

		lista.add(origem);
		verticeAtual = origem;

		while (!verticeAtual.equals(destino)) {
			verticesVisitados.add(verticeAtual);
			caminho += verticeAtual + " foi visitado.\n";

			for (int i = 0; i < vertices.size(); i++) {
				if (verticeAtual.equals(vertices.get(i))) {
					for (int j = 0; j < vertices.size(); j++) {
						if (matAdj[i][j] != 0) {
							caminho += vertices.get(j) + " ";
							qtdVerticesVizinhos++;
							if (!lista.contains(vertices.get(j))) {
								qtdVerticesVizinhosAddLista++;
								if (qtdVerticesVizinhosAddLista > 1)
									lista.add(cont + 1, vertices.get(j));
								else
									lista.add(cont, vertices.get(j));
							}
						}
					}
				}
			}
			if (qtdVerticesVizinhos == 1) {
				caminho += "é vizinho de " + verticeAtual + ".\n";
			} else if (qtdVerticesVizinhos > 1) {
				caminho += "são vizinhos de " + verticeAtual + ".\n";
			}

			if (cont >= vertices.size())
				break;

			qtdVerticesVizinhos = 0;
			qtdVerticesVizinhosAddLista = 0;
			verticeAtual = lista.get(cont);
			cont++;
		}

		if (verticeAtual.equals(destino)) {
			caminho += verticeAtual + " foi visitado.";
			caminho += "Destino " + verticeAtual + " foi encontrado.\n";
		} else {
			caminho += "Destino não encontrado.";
		}
		return caminho;

	}

	public String buscaPorLargura(String origem, String alvo) {

		String verticeAtual = null;
		List<String> lista = new ArrayList<String>();
		String caminho = "Largura " + origem + " " + alvo + ":\n";
		Set<String> verticesVisitados = new HashSet<String>();
		int cont = 1, qtdVerticesVizinhos = 0;

		lista.add(origem);
		verticeAtual = origem;

		while (!verticeAtual.equals(alvo)) {
			verticesVisitados.add(verticeAtual);
			caminho += verticeAtual + " foi visitado.\n";

			for (int i = 0; i < vertices.size(); i++) {
				if (verticeAtual.equals(vertices.get(i))) {
					for (int j = 0; j < vertices.size(); j++) {
						if (matAdj[i][j] != 0) {
							caminho += vertices.get(j) + " ";
							qtdVerticesVizinhos++;
							if (!lista.contains(vertices.get(j)))
								lista.add(vertices.get(j));
						}
					}
				}
			}
			if (qtdVerticesVizinhos == 1) {
				caminho += "é vizinho de " + verticeAtual + ".\n";
			} else if (qtdVerticesVizinhos > 1) {
				caminho += "são vizinhos de " + verticeAtual + ".\n";
			}

			if (cont >= vertices.size())
				break;

			qtdVerticesVizinhos = 0;
			verticeAtual = lista.get(cont);
			cont++;
		}

		if (verticeAtual.equals(alvo)) {
			caminho += verticeAtual + " foi visitado.";
			caminho += "Destino " + verticeAtual + " foi encontrado.\n";
		} else {
			caminho += "Destino não encontrado.";
		}
		return caminho;

	}

	public String Dijkstra(String origem, String destino) {

		String verticeAtual = null;
		List<String> naoVisitados = new ArrayList<String>();
		List<String> verticesVizinhos = new ArrayList<String>();
		HashMap<String, Integer> distancias = new HashMap<String, Integer>();
		HashMap<String, String> anteriores = new HashMap<String, String>();
		int distancia = 0;
		String caminho = "Menor Caminho " + origem + " " + destino + ":\n";

		// Percorre o vertice, coloca o na tabela de distancias e adiciona o
		// vertice na lista de não visitados
		for (String vertice : vertices) {
			distancias.put(vertice, 2147483647);
			naoVisitados.add(vertice);
			anteriores.put(vertice, null);
		}

		verticeAtual = origem;
		distancias.replace(verticeAtual, 0);

		// Faz um loop até que a lista de não visitados esteja vazia
		while (!naoVisitados.isEmpty()) {

			naoVisitados.remove(verticeAtual);

			for (int i = 0; i < vertices.size(); i++) {
				if (verticeAtual.equals(vertices.get(i))) {
					for (int j = 0; j < vertices.size(); j++) {
						if (matAdj[i][j] != 0) {
							if (naoVisitados.contains(vertices.get(j))){
								verticesVizinhos.add(vertices.get(j));
								distancia = distancias.get(verticeAtual)
										+ matAdj[i][j];
							}

							if (distancia < distancias.get(vertices.get(j))) {
								distancias.replace(vertices.get(j), distancia);
								anteriores.replace(vertices.get(j),
										verticeAtual);
							}
						}
					}
				}
			}

			caminho += verticeAtual + " ";
			if (verticesVizinhos.size() == 0) {
				break;
			} else if (verticesVizinhos.size() == 1) {
				verticeAtual = verticesVizinhos.get(0);
			} else {
				verticeAtual = verticesVizinhos.get(0);
				for (int i = 0; i <= verticesVizinhos.size() - 2; i++) {
					if (distancias.get(verticeAtual) > distancias
							.get(verticesVizinhos.get(i + 1)))
						verticeAtual = verticesVizinhos.get(i + 1);
				}
			}
			verticesVizinhos.removeAll(verticesVizinhos);
		}

		if (anteriores.get(destino) != null) {
			caminho += "\n" + distancias.get(destino);
		} else
			caminho += "\nCaminho não encontrado!";

		return caminho;
	}
	
	public String prim(String origem){
		Set<String> visitados = new HashSet<String>(); 
		String verticeAtual = null, selecionado = "";
		String caminho="Prim " + origem + ":\n";
		verticeAtual = origem;
		int menorCusto = 999999, custo = 0;
		
		visitados.add(verticeAtual);
		
		while(visitados.size() != vertices.size()){
			
			for(int i=0; i< vertices.size(); i++){
				if(verticeAtual.equals(vertices.get(i))){
					for(int j=0; j < vertices.size(); j++){
						if(matAdj[i][j] != 0 ){
							if(!visitados.contains(vertices.get(j))){
								if(menorCusto > matAdj[i][j]){
									verticeAtual = vertices.get(j);
									menorCusto = matAdj[i][j];
									selecionado = vertices.get(i) + " " +vertices.get(j)+ " " + menorCusto;
								}
							}
							
						}
					}
				}
			}
			custo += menorCusto;
			caminho+=selecionado + ",\n";
			menorCusto = 999999;
			visitados.add(verticeAtual);
		}
		caminho +=custo;
		
		return caminho;
		
	}
	
}
