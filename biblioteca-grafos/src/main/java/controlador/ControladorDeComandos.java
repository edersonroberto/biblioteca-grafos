package controlador;

import java.util.List;

import utilitario.ArquivoDeSaida;
import utilitario.CriaGrafoSaida;
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
	private int contDistancia ;
	
	public void executaComandos(Grafo grafo, List<String> linhas, ControladorSaida controleSaida) {
		
		contDistancia = 1;
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
				System.out.println("Executando calculo da distancia...");
				Distancia distancia = new Distancia();
				resultado = distancia.calculaDistancia(grafo, caracteres);
				controleSaida.setDistancia(resultado);
				System.out.println("Salvando grafo com o da distancia...");
				CriaGrafoSaida.CriarSaidaGrafo(grafo, "distancia"+contDistancia, resultado);
				CriaGrafoSaida.geraHtml(resultado, "distancia"+contDistancia);
				contDistancia++;
				
				
				break;
			case "profundidade":
				System.out.println("Executando busca em profundidade");
				Busca buscaProfundidade = new Busca();
				resultado = buscaProfundidade.buscaPorProfundidade(grafo, caracteres[1], caracteres[2]);
				controleSaida.setBuscaPorProfundidade(resultado);
				CriaGrafoSaida.CriarSaidaGrafo(grafo, "buscaPorProfundidade", resultado);
				CriaGrafoSaida.geraHtml(resultado, "buscaPorProfundidade");
				
				break;
			case "largura":
				System.out.println("Executando busca em largura");
				Busca buscaLargura = new Busca();
				resultado = buscaLargura.buscaPorLargura(grafo, caracteres[1], caracteres[2]);
				controleSaida.setBuscaPorLargura(resultado);
				CriaGrafoSaida.CriarSaidaGrafo(grafo, "buscaPorLargura", resultado);
				CriaGrafoSaida.geraHtml(resultado, "buscaPorLargura");
				
				break;
			case "menor":
				System.out.println("Executando calculo do menor caminho");
				Dijkstra dijkstra = new Dijkstra();
				resultado = dijkstra.menorCaminho(grafo, caracteres[2], caracteres[3]);
				controleSaida.setMenorCaminho(resultado);
				CriaGrafoSaida.CriarSaidaGrafo(grafo, "dijkstra", resultado);
				CriaGrafoSaida.geraHtml(resultado, "dijkstra");
				break;
			case "prim":
				System.out.println("Executando algoritmo de prim");
				Prim prim = new Prim();
				resultado = prim.arvoreGeradoraMinima(grafo, caracteres[1]);
				controleSaida.setPrim(resultado);
				CriaGrafoSaida.CriarSaidaGrafo(grafo, "prim", resultado);
				CriaGrafoSaida.geraHtml(resultado, "prim");
				break;
			case "kruskal":
				System.out.println("Executando algoritmo de kruskal");
				Kruskal kruskal = new Kruskal();
				resultado = kruskal.arvoreGeradoraMinima(grafo);
				controleSaida.setKruskal(resultado);
				CriaGrafoSaida.CriarSaidaGrafo(grafo, "kruskal", resultado);
				CriaGrafoSaida.geraHtml(resultado, "kruskal");
				
				break;
			default:
				return;
			
		}
		
		arquivoSaida.gravaArquivoDeSaida(resultado);
		
	}

}
