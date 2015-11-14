package biblioteca;

import java.util.ArrayList;
import java.util.List;

	public class Prim {
		
		public List<String> vertices;
		int matAdj[][];
		private List<Aresta> arestas;
	
		
	public String arvoreGeradoraMinima(Grafo grafo, String origem) {
		
		if(grafo.ehConexo() == false)
			return "Não é possivel realizar operação!\nGrafo não é conexo.\n";
		
		
		String caminho = "Prim " +origem + ":\n";
		vertices = grafo.getVertices();
		arestas = grafo.getArestas();
		
		List<String> visitados = new ArrayList<String>();
		Aresta arestaAtual = new Aresta();
		String verticeAtual = origem;
		int custoTotal = 0;
		
		
		while (visitados.size() < vertices.size()){
			
			visitados.add(verticeAtual);
			arestaAtual= percorreArestas(visitados, verticeAtual);
			
			if(arestaAtual.getDestino() == null)
				break;
			
			caminho += arestaAtual.getOrigem() + " " + arestaAtual.getDestino() +" "+ arestaAtual.getPeso() + ",\n";
			
			custoTotal += arestaAtual.getPeso();
			
			verticeAtual = arestaAtual.getDestino();
		}
		
		caminho += custoTotal;
		
		return caminho + "\n";
	}


	private Aresta percorreArestas(List<String> visitados, String verticeAtual) {
		
		Aresta arestaSelecionada = new Aresta();
		int menorCusto = Integer.MAX_VALUE;
		
		for (String visitado : visitados) {
			for (Aresta aresta : arestas) {
				if(aresta.getOrigem().equals(visitado)){
					if(!visitados.contains(aresta.getDestino())){
						if(menorCusto > aresta.getPeso()){
							menorCusto = aresta.getPeso();
							arestaSelecionada = aresta;
						}
					}
						
				}
					
			}
		}
		
		return arestaSelecionada;
	}
		

}
