package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
		
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	private int matAdj[][];

	public Grafo(List<Vertice> vertices2, List<Aresta> arestas2) {
		this.vertices = vertices2;
		this.arestas = arestas2;
		//montaMatAdj();
	}
	
	
	public String buscaPorProfundidade(Vertice origem, Vertice alvo){
		
		Aresta aresta = new Aresta();
		Vertice verticeAtual = null;
		List<Vertice> lista = new ArrayList<Vertice>();
		String caminho = "", vizinhos = "";
		Set<Vertice> verticesVisitados = new HashSet<Vertice>();
		int cont = 1;
		
		lista.add(origem);
		verticeAtual = origem;
		
		while(!verticeAtual.equals(alvo)){
			verticesVisitados.add(verticeAtual);
			caminho+= verticeAtual.getNome() + " foi visitado.\n";
			
			for (int i = 0; i < arestas.size(); i++){
				aresta = arestas.get(i);
				vizinhos += verificaVertices(aresta, verticeAtual, lista);
			}
			
			if (vizinhos.trim().length() == 1){
				caminho += vizinhos + "é vizinho de " + verticeAtual.getNome() + ".\n";
			}else if (vizinhos.trim().length() > 1){
				caminho += vizinhos +"são vizinhos de " + verticeAtual.getNome() + ".\n";
			}
			
			vizinhos = "";
			verticeAtual = lista.get(cont);
			cont ++;
		}
		
		caminho += verticeAtual.getNome() + " foi visitado.\n";
		if (verticeAtual.equals(alvo)){
			caminho += "Destino " + verticeAtual.getNome() + " foi encontrado.";
		}else{
			caminho += "Destino não encontrado.";
		}
		
		return caminho;

	}


	private String verificaVertices(Aresta aresta, Vertice verticeAtual, List<Vertice> lista) {
		
		String caminho = "";
		
		if(aresta.getVertice1() == verticeAtual){
			caminho += trataVertice(aresta.getVertice1(), aresta.getVertice2(), lista);
		}else if (aresta.getVertice2() == verticeAtual){
			caminho += trataVertice(aresta.getVertice2(), aresta.getVertice1(), lista);

		}		
		
		return caminho;
	}

	private String trataVertice(Vertice analisado, Vertice vizinho, List<Vertice> lista) {
		
		int posNaLista;
		posNaLista = lista.indexOf(analisado);
		posNaLista ++;
		
		String caminho = "";
		caminho += vizinho.getNome() + " ";
		if (!lista.contains(vizinho)) {
			lista.add(posNaLista, vizinho);
		}
		
		return caminho;
	}
	
	public String buscaPorLargura(Vertice origem, Vertice alvo){
		Aresta aresta = new Aresta();
		Vertice verticeAtual = null;
		List<Vertice> lista = new ArrayList<Vertice>();
		String caminho = "";
		List<Vertice> verticesVisitados = new ArrayList<Vertice>();
		int cont = 1;
		int qtdVizinhos = 0;
		
		lista.add(origem);
		verticeAtual = origem;

		while (!verticeAtual.equals(alvo)) {
					
			verticesVisitados.add(verticeAtual);
			caminho += verticeAtual.getNome() + " foi visitado.\n";

			for (int i = 0; i < arestas.size(); i++) {
				aresta = arestas.get(i);

				if (aresta.getVertice1() == verticeAtual) {
					caminho += aresta.getVertice2().getNome() + " ";
					qtdVizinhos ++;
					if (!lista.contains(aresta.getVertice2())) {
						lista.add(aresta.getVertice2());
						
					}
				}else if (aresta.getVertice2() == verticeAtual){
					caminho += aresta.getVertice1().getNome() + " ";
					qtdVizinhos ++;
					if (!lista.contains(aresta.getVertice1())) {
						lista.add(aresta.getVertice1());
						qtdVizinhos ++;
					}
				}
				
			}
			if (qtdVizinhos == 1){
				caminho += "é vizinho de " + verticeAtual.getNome() + ".\n";
			}else if (qtdVizinhos > 1){
				caminho += "são vizinhos de " + verticeAtual.getNome() + ".\n";
			}
			qtdVizinhos = 0;
			verticeAtual = lista.get(cont);
			
			cont++;
			if (cont >= vertices.size())
				break;
			
		}
		caminho += verticeAtual.getNome() + " foi visitado.\n";
		if (verticeAtual.equals(alvo)){
			caminho += "Destino " + verticeAtual.getNome() + " foi encontrado.";
		}else{
			caminho += "Destino não encontrado.";
		}
		
		return caminho;
	}

	public String Dijkstra(Vertice origem, Vertice destino){
		Aresta aresta = new Aresta();
		Vertice verticeAtual = new Vertice();
		Vertice maisProxVerticeAtual = new Vertice();
		List<Vertice> naoVisitados = new ArrayList<Vertice>();
		HashMap<Vertice, Integer> distancias = new HashMap<Vertice, Integer>();
		HashMap<Vertice, Vertice> anteriores = new HashMap<Vertice, Vertice>();
		int distancia = 0 ;
		String retorno = "";
		
		//Percorre o vertice, coloca o na tabela de distancias e adiciona o vertice na lista de não visitados
		for (Vertice vertice : vertices) {
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
			
			for (int i=0; i < arestas.size(); i++){
				aresta = arestas.get(i);
				
				if(aresta.getVertice1() == verticeAtual ){
					distancia= 0;
					distancia = distancias.get(verticeAtual) + aresta.getPeso();
						
					//atualiza a tabela de distancia e vertices anteriores
					if (distancias.get(aresta.getVertice2()) > distancia){
						distancias.replace(aresta.getVertice2(), distancia);
						anteriores.replace(aresta.getVertice2(), verticeAtual);
					}
					//verifica qual o vertice mais proximo do atual
					if(verticeAtual.equals(maisProxVerticeAtual)){
						maisProxVerticeAtual = aresta.getVertice2();
					}
					if (distancias.get(aresta.getVertice2()) < distancias.get(maisProxVerticeAtual)){
						maisProxVerticeAtual = aresta.getVertice2();
					}
				}
			}
			verticeAtual = maisProxVerticeAtual;
			
		}
		if(anteriores.containsKey(destino)){
			Vertice v = new Vertice();
			retorno = destino.getNome();
			v = destino;
			while (anteriores.get(v)!= null){
				retorno =  anteriores.get(v).getNome() + " -> " + retorno;
				v = anteriores.get(v);
			}			
		}
		
		return retorno;
	}

	public void addVertices(Vertice vertice) {

		vertices.add(vertice);
		
	}

}
