package biblioteca;

import java.util.List;

public class Distancia {
	
 	private List<Aresta> arestas;
	
	public String calculaDistancia(Grafo grafo, String caminho[]){
		
		arestas = grafo.getArestas();
		
		int distancia = 0;
		String rota = "Distancia";
		
		rota+= " " + caminho[1];
		
		for (int i = 1; i < caminho.length-1; i++) {
			String origem = caminho[i];
			String prox = caminho[i+1];
			
			for (Aresta aresta : arestas) {
				if(aresta.getOrigem().equals(origem) && aresta.getDestino().equals(prox)){
					distancia += aresta.getPeso();
					rota+=" " + prox;
					break;
				}
			}
		}
		
		/*
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
		*/
		
		//rota += " " + caminho[cont];
		rota += ":\n" + distancia + "\n";
		return rota;
	}
}
