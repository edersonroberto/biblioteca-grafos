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
	private ArquivoDeSaida arquivoSaida;

	
	public void executaComandos(Grafo grafo, List<String> linhas, ControladorSaida controleSaida) {
		
	
		arquivoSaida = new ArquivoDeSaida("C:/saida/");
		String caracteres[];
		this.grafo = grafo;
		TrataLinha trataLinha = new TrataLinha();
		linhas.remove("Comandos");
		

		for (String linha : linhas) {
			caracteres = trataLinha.trataLinha(linha);
			executaComandos(caracteres, controleSaida);
		}
		

	}

	private void executaComandos(String[] caracteres, ControladorSaida controleSaida) {
		String resultado = "";

		String comando = caracteres[0].toLowerCase();

		switch (comando) {
			case "distancia":
				Distancia distancia = new Distancia();
				resultado = distancia.calculaDistancia(grafo, caracteres);
				controleSaida.setDistancia(resultado);
				break;
			case "profundidade":
				Busca buscaProfundidade = new Busca();
				resultado = buscaProfundidade.buscaPorProfundidade(grafo, caracteres[1], caracteres[2]);
				controleSaida.setBuscaPorProfundidade(resultado);
				break;
			case "largura":
				Busca buscaLargura = new Busca();
				resultado = buscaLargura.buscaPorLargura(grafo, caracteres[1], caracteres[2]);
				controleSaida.setBuscaPorLargura(resultado);
				break;
			case "menor":
				Dijkstra dijkstra = new Dijkstra();
				resultado = dijkstra.menorCaminho(grafo, caracteres[2], caracteres[3]);
				controleSaida.setMenorCaminho(resultado);
				break;
			case "prim":
				Prim prim = new Prim();
				resultado = prim.arvoreGeradoraMinima(grafo, caracteres[1]);
				controleSaida.setPrim(resultado);
				break;
			case "kruskal":
				Kruskal kruskal = new Kruskal();
				resultado = kruskal.arvoreGeradoraMinima(grafo);
				controleSaida.setKruskal(resultado);
				break;
			default:
				return;
			
		}
		
		arquivoSaida.gravaArquivoDeSaida(resultado);
		
	}

}
