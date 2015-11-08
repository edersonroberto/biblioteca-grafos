package controlador;

import java.util.List;

import utilitario.TrataLinha;
import biblioteca.Grafo;

public class ControladorDeComandos {

	private Grafo grafo;

	public void executaComandos(Grafo grafo, List<String> linhas) {
		String caracteres[];
		this.grafo = grafo;
		TrataLinha trataLinha = new TrataLinha();
		linhas.remove("Comandos");

		for (String linha : linhas) {
			caracteres = trataLinha.trataLinha(linha);
			executaComandos(caracteres);
		}

	}

	private void executaComandos(String[] caracteres) {
		String resultado = "";

		String comando = caracteres[0].toLowerCase();

		switch (comando) {
			case "distancia":
				
				break;
			case "profundidade":
				resultado = grafo.buscaPorProfundidade(caracteres[1], caracteres[2]);
				break;
			case "largura":
				resultado = grafo.buscaPorLargura(caracteres[1], caracteres[2]);
				break;
			case "menor":
				resultado = grafo.Dijkstra(caracteres[2], caracteres[3]);
				break;
			case "prim":
				resultado = grafo.prim(caracteres[1]);
				break;
			case "kruskal":
				resultado = grafo.kruskal();
				break;
			default:
				return;
			
		}
		
		System.out.println(resultado);
		
	}

}
