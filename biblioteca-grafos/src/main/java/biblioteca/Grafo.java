package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
		
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	private String matAdj[][];

	public Grafo(ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
		this.vertices = vertices;
		this.arestas = arestas;
		//montaMatAdj();
	}
	
	private void montaMatAdj() {
		
		Vertice vertice = new Vertice();
		Aresta aresta = new Aresta();
		
		matAdj = new String[vertices.size()][vertices.size()];
		
		for (int i=0; i< vertices.size(); i++){
			vertice = vertices.get(i);
			
			for (int j=0; j<arestas.size(); i++ ){
				aresta = arestas.get(j);
				
				if (aresta.getVertice1() == vertice){
					
					matAdj[i][j] = "1";
				}
			}
			
		}
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
		
		List<Vertice> naoVisitados = new ArrayList<Vertice>();
		List<TabelaDistancia> distancias = new ArrayList<TabelaDistancia>();
		TabelaDistancia distancia = new TabelaDistancia();
		
		for (Vertice vertice : vertices) {
			distancia.setV(vertice);
			distancia.setDistancia(2147483647);
			distancias.add(distancia);
		}
		
		return "";
	}

}
