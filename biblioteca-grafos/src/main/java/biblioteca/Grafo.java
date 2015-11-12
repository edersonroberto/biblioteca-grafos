package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {

	private List<String> vertices;
	private List<Aresta> arestas;
	private int matAdj[][];

	public Grafo(List<String> vertices, int matAdj[][], List<Aresta> arestas) {
		this.vertices = vertices;
		this.matAdj = matAdj;
		this.arestas = arestas;
	}
	

	public String distancia(String[] caminho) {

		int distancia = 0;
		String rota = "Distancia";
		int cont = 0;

		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).equals(caminho[cont])) {
				for (int j = 0; j < vertices.size(); j++) {
					if (vertices.get(j).equals(caminho[cont + 1])) {
						distancia += matAdj[i][j];
						rota += " " + vertices.get(i);

					}
				}
				cont++;
			}
			if (cont >= caminho.length - 1)
				break;

		}
		rota += " " + caminho[cont];
		rota += ":\n" + distancia;
		return rota;
	}

	public String buscaPorProfundidade(String origem, String destino) {

		String verticeAtual = null;
		List<String> lista = new ArrayList<String>();
		String caminho = "Profundidade " + origem + " " + destino + ":\n";
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
			caminho += verticeAtual + " foi visitado.\n";
			caminho += "Destino " + verticeAtual + " foi encontrado.\n";
		} else {
			caminho += "Destino não encontrado.\n";
		}
		return caminho;

	}

	public String buscaPorLargura(String origem, String destino) {
		
		String caminho = "Largura " + origem + " " + destino + ":\n";
		String retornoOperacao = validaOperacao(origem, destino);
		
		if(retornoOperacao == null){
			String verticeAtual = "";
			List<String> lista = new ArrayList<String>();
			
			Set<String> verticesVisitados = new HashSet<String>();
			int cont = 1, qtdVerticesVizinhos = 0;

			lista.add(origem);
			verticeAtual = origem;

			while (!verticeAtual.equals(destino) && !(verticesVisitados.size() == vertices.size())) {
				verticesVisitados.add(verticeAtual);
				caminho += verticeAtual + " foi visitado.\n";

				for (int i = 0; i < vertices.size(); i++) {
					if (verticeAtual.equals(vertices.get(i))) {
						for (int j = 0; j < vertices.size(); j++) {
							if (matAdj[i][j] != 0) {
								caminho += vertices.get(j) + " ";
								qtdVerticesVizinhos++;
								if(!lista.contains(vertices.get(j)))
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

			if (verticeAtual.equals(destino)) {
				caminho += verticeAtual + " foi visitado.\n";
				caminho += "Destino " + verticeAtual + " foi encontrado.\n";
			} else {
				caminho += "Destino não encontrado.";
			}
		}else{
			caminho += "Não foi possivél executar operação.\n";
			caminho += retornoOperacao;
		}
		
		return caminho;

	}

	public String Dijkstra(String origem, String destino) {
		
		String caminho = "Menor Caminho " + origem + " " + destino + ":\n";
		String retornoOperacao = validaOperacao(origem, destino);
		
		if(retornoOperacao == null){
		
			String verticeAtual = null;
			List<String> naoVisitados = new ArrayList<String>();
			List<String> verticesVizinhos = new ArrayList<String>();
			HashMap<String, Integer> distancias = new HashMap<String, Integer>();
			HashMap<String, String> anteriores = new HashMap<String, String>();
			int distancia = 0;
			
	
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
			while (!verticeAtual.equals(destino) && !naoVisitados.isEmpty()) {
	
				naoVisitados.remove(verticeAtual);
				//TO DO variavel distancia não é necessaria aki
				distancia += calculaDistancia(verticeAtual, naoVisitados, verticesVizinhos,
						distancias, anteriores, distancia);
	
				verticeAtual = defineVerticeAtual(verticesVizinhos, distancias); 
				verticesVizinhos.removeAll(verticesVizinhos);
			}
			
			caminho += defineMenorCaminho(anteriores, distancias, destino, origem);
	}else{
		caminho += "Não foi possivél realizar operação.\n";
		caminho += retornoOperacao;
	}
		return caminho;
	}

	private String validaOperacao(String origem, String destino) {
		
		if(!vertices.contains(origem)){
			return "Origem não existe no grafo.\n";
		}else if (!vertices.contains(destino)){
			return "Destino não existe no grafo.\n";
		}
		
		return null;
	}

	private String defineMenorCaminho(HashMap<String,String> anteriores, 
			HashMap<String,Integer> distancias, String destino, String origem) {
		
		String vertice = "", rota = "";
		int distancia = 0;
		if (anteriores.get(destino) != null) {
			rota = destino;
			vertice = anteriores.get(destino);
			if(vertice.equals(origem)){
				rota = vertice + " " + rota;
				distancia = distancias.get(destino); 
			}else{
				while(!vertice.equals(origem)){
					rota = vertice + " " + rota;
					
					vertice = anteriores.get(vertice);
				}
			}
		} else{
			rota += "\nCaminho não encontrado!";
		}
		rota = origem + " " + rota;
		rota += "\n" + distancias.get(destino);
		
		return rota;
	}

	private String defineVerticeAtual(List<String> verticesVizinhos, HashMap<String, Integer> distancias) {
		String vertice = "";
		
		if (verticesVizinhos.size() == 1) {
			vertice = verticesVizinhos.get(0);
		} else if(verticesVizinhos.size() > 1 ){
			vertice = verticesVizinhos.get(0);
			for (int i = 0; i <= verticesVizinhos.size() - 2; i++) {
				if (distancias.get(vertice) > distancias
						.get(verticesVizinhos.get(i + 1)))
					vertice = verticesVizinhos.get(i + 1);
			}
		}
		return vertice;
	}

	private int calculaDistancia(String verticeAtual, List<String> naoVisitados,
			List<String> verticesVizinhos, HashMap<String, Integer> distancias,
			HashMap<String, String> anteriores, int distancia) {
		
		for (int i = 0; i < vertices.size(); i++) {
			if (verticeAtual.equals(vertices.get(i))) {
				for (int j = 0; j < vertices.size(); j++) {
					if (matAdj[i][j] != 0) {
						if (naoVisitados.contains(vertices.get(j))) {
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
		return distancia;
	}
	
	public String prim(String origem) {
		Set<String> visitados = new HashSet<String>();
		String verticeAtual = null, selecionado = "";
		String caminho = "Prim " + origem + ":\n";
		verticeAtual = origem;
		int menorCusto = 999999, custo = 0;

		visitados.add(verticeAtual);

		while (visitados.size() != vertices.size()) {

			for (int i = 0; i < vertices.size(); i++) {
				if (verticeAtual.equals(vertices.get(i))) {
					for (int j = 0; j < vertices.size(); j++) {
						if (matAdj[i][j] != 0) {
							if (!visitados.contains(vertices.get(j))) {
								if (menorCusto > matAdj[i][j]) {
									verticeAtual = vertices.get(j);
									menorCusto = matAdj[i][j];
									selecionado = vertices.get(i) + " "
											+ vertices.get(j) + " "
											+ menorCusto;
								}
							}

						}
					}
				}
			}
			custo += menorCusto;
			caminho += selecionado + ",\n";
			menorCusto = 999999;
			visitados.add(verticeAtual);
		}
		caminho += custo + "\n";

		return caminho;

	}

	public String kruskal() {
		Aresta aresta = new Aresta();
		String caminho = "Kruskal:\n";
		
		List<Aresta> floresta = new ArrayList<Aresta>();
		/*
		List<String> florestas[] ;
		
		florestas = new ArrayList[vertices.size()];
		
		for(int i=0; i< vertices.size(); i++){
			florestas[i] = new ArrayList<String>();
			florestas[i].add(vertices.get(i));
		}
		*/
		Collections.sort(this.arestas);
		int totalVertices = 0;
		int custo = 0;
		while(!arestas.isEmpty() && (totalVertices < vertices.size() -1)){
			aresta = arestas.get(0);
			arestas.remove(0);
			
			if(!estaNaFloresta(aresta, floresta) ){
				floresta.add(aresta);
				totalVertices ++;
			}
		}
		
		for (Aresta f : floresta) {
			custo += f.getPeso();
			caminho+= f.getOrigem() + " " + f.getDestino() + " " + f.getPeso() + ",\n" ;
		}
		caminho+= custo + "\n";
		
		return caminho;
	}

	private boolean estaNaFloresta(Aresta aresta, List<Aresta> floresta) {
		
		if(floresta.isEmpty())
			return false;
		
		String origem = aresta.getOrigem();
		String destino = aresta.getDestino();
		
		for (Aresta f : floresta) {
			if( origem.equals(f.getOrigem()) && destino.equals(f.getDestino())
					|| destino.equals(f.getOrigem()) && origem.equals(f.getDestino())){
				return true;
			}
			
			if(destino.equals(f.getDestino()))
				return true;
		}
		
		return false;
	}

}
