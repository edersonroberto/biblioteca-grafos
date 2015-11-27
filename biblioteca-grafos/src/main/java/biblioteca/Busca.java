package biblioteca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Busca {

	private List<String> vertices;
	private int matAdj[][];

	public String buscaPorLargura(Grafo grafo, String origem, String destino) {

		vertices = grafo.getVertices();
		matAdj = grafo.getMatAdj();

		String caminho = "Largura " + origem + " " + destino + ":\n";
		String retornoOperacao = validaOperacao(origem, destino);

		if (retornoOperacao == null) {
			String verticeAtual = "";
			List<String> lista = new ArrayList<String>();

			Set<String> verticesVisitados = new HashSet<String>();
			int cont = 1, qtdVerticesVizinhos = 0;

			lista.add(origem);
			verticeAtual = origem;

			// Faz um loop até que o vertice destino seja encontrado ou até que
			// todos os vertices sejam visitados
			while (!verticeAtual.equals(destino)
					&& !(verticesVisitados.size() == vertices.size())) {
				verticesVisitados.add(verticeAtual);
				caminho += verticeAtual + " foi visitado.\n";

				// Percorre a matriz de adjacencia comparando a linha da matriz
				// com o vertice atual,
				// Quando encontra o vertice percorre a coluna e encontra os
				// vizinhos do vertice atual.
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

			caminho += verticeAtual + " foi visitado.\n";
			caminho += "Destino " + verticeAtual + " foi encontrado.\n";

		} else {
			caminho += "Não foi possivél executar operação.\n";
			caminho += retornoOperacao;
		}

		return caminho;

	}

	public String buscaPorProfundidade(Grafo grafo, String origem,
			String destino) {

		vertices = grafo.getVertices();
		matAdj = grafo.getMatAdj();

		String verticeAtual = null;
		List<String> lista = new ArrayList<String>();
		String caminho = "Profundidade " + origem + " " + destino + ":\n";
		Set<String> verticesVisitados = new HashSet<String>();
		int cont = 1, qtdVerticesVizinhos = 0, qtdVerticesVizinhosAddLista = 0;

		lista.add(origem);
		verticeAtual = origem;

		// Faz um loop até que o vertice destino seja encontrado ou até que
		// todos os vertices sejam visitados
		while (!verticeAtual.equals(destino)) {
			verticesVisitados.add(verticeAtual);
			caminho += verticeAtual + " foi visitado.\n";

			// Percorre a matriz de adjacencia comparando a linha da matriz com
			// o vertice atual,
			// Quando encontra o vertice percorre a coluna e encontra os
			// vizinhos do vertice atua.
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

	private String validaOperacao(String origem, String destino) {

		if (!vertices.contains(origem)) {
			return "Origem não existe no grafo.\n";
		} else if (!vertices.contains(destino)) {
			return "Destino não existe no grafo.\n";
		}

		return null;
	}

}
