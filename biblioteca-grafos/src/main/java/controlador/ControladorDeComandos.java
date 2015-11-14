package controlador;

import java.util.List;

import utilitario.ArquivoDeSaida;
import utilitario.TrataLinha;
import biblioteca.Busca;
import biblioteca.Dijkstra;
import biblioteca.Distancia;
import biblioteca.Grafo;
import biblioteca.Kruskal;
import biblioteca.Prim;

public class ControladorDeComandos {

	private Grafo grafo;
	ArquivoDeSaida arquivoSaida;

	public void executaComandos(Grafo grafo, List<String> linhas) {
		arquivoSaida = new ArquivoDeSaida("saida/saida");
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
				Distancia distancia = new Distancia();
				resultado = distancia.calculaDistancia(grafo, caracteres);
				break;
			case "profundidade":
				Busca buscaProfundidade = new Busca();
				resultado = buscaProfundidade.buscaPorProfundidade(grafo, caracteres[1], caracteres[2]);
				break;
			case "largura":
				Busca buscaLargura = new Busca();
				resultado = buscaLargura.buscaPorLargura(grafo, caracteres[1], caracteres[2]);
				break;
			case "menor":
				Dijkstra dijkstra = new Dijkstra();
				resultado = dijkstra.menorCaminho(grafo, caracteres[2], caracteres[3]);
				break;
			case "prim":
				Prim prim = new Prim();
				resultado = prim.arvoreGeradoraMinima(grafo, caracteres[1]);
				break;
			case "kruskal":
				Kruskal kruskal = new Kruskal();
				resultado = kruskal.arvoreGeradoraMinima(grafo);
				break;
			default:
				return;
			
		}
		
		arquivoSaida.gravaArquivoDeSaida(resultado);
		
	}

}
