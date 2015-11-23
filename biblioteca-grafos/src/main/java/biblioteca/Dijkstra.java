package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {

	private List<String> vertices;
	private List<Aresta> arestas;
	//private int matAdj[][];
	private HashMap<String, Integer> distancias;
	private HashMap<String, String> anteriores;
	private List<String> naoVisitados;

	public String menorCaminho(Grafo grafo, String origem, String destino) {
		
		vertices = grafo.getVertices();
		arestas = grafo.getArestas();
		
		String retornoOperacao , caminho = "";
		retornoOperacao = validaOperacao(origem, destino);
		
		caminho = "Menor Caminho " + origem + " " + destino + ":\n";
		
		if(retornoOperacao == null){
			
			inicializaTabelas();
			
			String verticeAtual = origem;
			distancias.replace(verticeAtual, 0);
			
			while(!naoVisitados.isEmpty() && !verticeAtual.equals(destino)){
				naoVisitados.remove(verticeAtual);
				verticeAtual = operacaoPrincipal(verticeAtual);
				
				if(verticeAtual == null)
					verticeAtual = defineNovoVertice();
			}
			
			caminho += defineRotaMenorCaminho(origem, destino);
	
		}else{
			caminho += "Não foi possivél realizar operação.\n";
			caminho += retornoOperacao;
		}
		
		return caminho + "\n";
	}
	
	private String defineNovoVertice() {
		
		return naoVisitados.get(0);
	}

	private String defineRotaMenorCaminho(String origem, String destino) {
		
		String vertice = "", rota = "";

		if (anteriores.get(destino) != null) {
			rota = destino;
			vertice = anteriores.get(destino);
			if (vertice.equals(origem)) {
				rota = vertice + " " + rota;
			} else {
				while (!vertice.equals(origem)) {
					rota = vertice + " " + rota;
					vertice = anteriores.get(vertice);
				}
			}
		} else {
			rota += "\nCaminho não encontrado!";
		}
		rota = origem + " " + rota;
		rota += "\n" + distancias.get(destino);

		return rota;
		
	}

	private String operacaoPrincipal(String verticeAtual) {
		
		int custo = 0, menorCusto = Integer.MAX_VALUE;
		String novoVerticeAtual = null;
		
		for (Aresta aresta : arestas) {
			if(verticeAtual.equals(aresta.getOrigem())){
				if(naoVisitados.contains(aresta.getDestino())){
					custo = calculaDistancia(verticeAtual, aresta);
					
					if(menorCusto > custo){
						menorCusto = custo;
						novoVerticeAtual = aresta.getDestino();
					}
				}
					
			}
		}
		
		return novoVerticeAtual;
	}

	private int calculaDistancia(String verticeAtual, Aresta aresta) {
		int distancia = aresta.getPeso() + distancias.get(verticeAtual);
		
		if(distancias.get(aresta.getDestino()) > distancia){
			distancias.replace(aresta.getDestino(), distancia);
			anteriores.replace(aresta.getDestino(), verticeAtual);
		}
		
		return distancia;
	}

	private void inicializaTabelas() {
		distancias = new HashMap<String, Integer>();
		anteriores = new HashMap<String, String>();
		naoVisitados = new ArrayList<String>();
		
		for (String vertice : vertices) {
			distancias.put(vertice, Integer.MAX_VALUE);
			anteriores.put(vertice, null);
			naoVisitados.add(vertice);
		}
		
		
	}

	private String validaOperacao(String origem, String destino) {

		if (!vertices.contains(origem)) {
			return "Origem não existe no grafo.";
		} else if (!vertices.contains(destino)) {
			return "Destino não existe no grafo.";
		}

		return null;
	}

}
