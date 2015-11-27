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
	
	public void executaComandos(Grafo grafo, List<String> linhas, String diretorio, String saidaGrafo) {
		
		contDistancia = 1;
		arquivoSaida = new ArquivoDeSaida("C:/saida/saida-");
		String caracteres[];
		this.grafo = grafo;
		linhas.remove("Comandos");

		for (String linha : linhas) {
			caracteres = TrataLinha.trataLinha(linha);
			executaComandos(caracteres, diretorio, saidaGrafo);
		}
		

	}

	private void executaComandos(String[] caracteres, String diretorio, String saidaGrafo) {
		String resultado = "";

		String comando = caracteres[0].toLowerCase();

		switch (comando) {
			case "distancia":
				System.out.println("Executando calculo da distancia...");
				Distancia distancia = new Distancia();
				resultado = distancia.calculaDistancia(grafo, caracteres);
				System.out.println("Salvando grafo com o da distancia...");
				CriaGrafoSaida.CriarGrafoResultado(diretorio,"distancia"+contDistancia, resultado, saidaGrafo);
				CriaGrafoSaida.geraHtml(resultado, diretorio, "distancia"+contDistancia);
				contDistancia++;
				
				break;
			case "profundidade":
				System.out.println("Executando busca em profundidade");
				Busca buscaProfundidade = new Busca();
				resultado = buscaProfundidade.buscaPorProfundidade(grafo, caracteres[1], caracteres[2]);
				CriaGrafoSaida.CriarGrafoResultado(diretorio, "buscaPorProfundidade", resultado, saidaGrafo);
				CriaGrafoSaida.geraHtml(resultado, diretorio, "buscaPorProfundidade");
				
				break;
			case "largura":
				System.out.println("Executando busca em largura");
				Busca buscaLargura = new Busca();
				resultado = buscaLargura.buscaPorLargura(grafo, caracteres[1], caracteres[2]);
				CriaGrafoSaida.CriarGrafoResultado(diretorio, "buscaPorLargura", resultado, saidaGrafo);
				CriaGrafoSaida.geraHtml(resultado,diretorio, "buscaPorLargura");
				
				break;
			case "menor":
				System.out.println("Executando calculo do menor caminho");
				Dijkstra dijkstra = new Dijkstra();
				resultado = dijkstra.menorCaminho(grafo, caracteres[2], caracteres[3]);
				CriaGrafoSaida.CriarGrafoResultado(diretorio, "dijkstra", resultado, saidaGrafo);
				CriaGrafoSaida.geraHtml(resultado,diretorio,  "dijkstra");
				break;
			case "prim":
				System.out.println("Executando algoritmo de prim");
				Prim prim = new Prim();
				resultado = prim.arvoreGeradoraMinima(grafo, caracteres[1]);
				CriaGrafoSaida.CriarGrafoResultado(diretorio, "prim", resultado, saidaGrafo);
				CriaGrafoSaida.geraHtml(resultado,diretorio, "prim");
				break;
			case "kruskal":
				System.out.println("Executando algoritmo de kruskal");
				Kruskal kruskal = new Kruskal();
				resultado = kruskal.arvoreGeradoraMinima(grafo);
				CriaGrafoSaida.CriarGrafoResultado(diretorio, "kruskal", resultado, saidaGrafo);
				CriaGrafoSaida.geraHtml(resultado,diretorio, "kruskal");
				
				break;
			default:
				return;
			
		}
		
		arquivoSaida.gravaArquivoDeSaida(resultado);
		
	}

}
