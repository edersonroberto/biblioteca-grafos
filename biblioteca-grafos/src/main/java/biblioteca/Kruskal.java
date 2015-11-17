package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
	
	private List<Aresta> arestas;
	private List<String> vertices;

	public String arvoreGeradoraMinima(Grafo grafo) {

		Aresta aresta = new Aresta();
		String caminho = "Kruskal:\n";
		arestas = grafo.getArestas();
		vertices = grafo.getVertices();
	
		Collections.sort(this.arestas);
		
		List<Aresta> floresta = new ArrayList<Aresta>();
		/*
		 * List<String> florestas[] ;
		 * 
		 * florestas = new ArrayList[vertices.size()];
		 * 
		 * for(int i=0; i< vertices.size(); i++){ florestas[i] = new
		 * ArrayList<String>(); florestas[i].add(vertices.get(i)); }
		 */
		
		int totalVertices = 0;
		int custo = 0;
		while (!arestas.isEmpty() && (totalVertices < vertices.size() - 1)) {
			aresta = arestas.get(0);
			arestas.remove(0);

			if (!estaNaFloresta(aresta, floresta)) {
				floresta.add(aresta);
				totalVertices++;
			}
		}

		for (Aresta f : floresta) {
			custo += f.getPeso();
			caminho += f.getOrigem() + " " + f.getDestino() + " " + f.getPeso()
					+ ",\n";
		}
		caminho += custo + "\n";

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
