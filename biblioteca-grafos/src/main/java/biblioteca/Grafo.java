package biblioteca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {

	private List<String> vertices;
	private List<Aresta> arestas;
	private int matAdj[][];
	private boolean ehConexo;
	private boolean temPeso;

	public Grafo(List<String> vertices, int matAdj[][], List<Aresta> arestas, boolean ehConexo, boolean temPeso) {
		this.vertices = vertices;
		this.matAdj = matAdj;
		this.arestas = arestas;
		this.ehConexo = ehConexo;
		this.temPeso = temPeso;
	}
	

	public boolean temPeso() {
		return temPeso;
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


	private String validaOperacao(String origem, String destino) {
		
		if(!vertices.contains(origem)){
			return "Origem não existe no grafo.\n";
		}else if (!vertices.contains(destino)){
			return "Destino não existe no grafo.\n";
		}
		
		return null;
	}

	public List<String> getVertices() {
		return vertices;
	}
	
	public void setVertices(List<String> vertices) {
		this.vertices = vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public int[][] getMatAdj() {
		return matAdj;
	}

	public boolean ehConexo() {
		return ehConexo;
	}

}
