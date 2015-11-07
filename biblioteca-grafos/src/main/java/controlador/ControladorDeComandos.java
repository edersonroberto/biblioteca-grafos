package controlador;

import java.util.List;

import biblioteca.Grafo;

public class ControladorDeComandos {
	
	private Grafo grafo;

	public void executaComandos(Grafo grafo, List<String> linhas) {
		String caracteres[];
		this.grafo = grafo;
		
		for (String linha : linhas) {
			if (linha.equals("Comandos")) {
				break;
			} else {
				linhas.remove(linha);
			}
		}
		linhas.remove("Comandos");

		for (String linha : linhas) {
			caracteres = trataLinha(linha);
			executaComandos(caracteres);
		}

	}

	private void executaComandos(String[] caracteres) {
		String resultado = "";

		if (caracteres[0].toLowerCase().contains("distancia")) {
			// executa metodo para descobrir a distancia
		}
		if (caracteres[0].toLowerCase().equals("profundidade")) {
			resultado = grafo.buscaPorProfundidade(caracteres[1], caracteres[2]);
			System.out.println(resultado);
		}
		if (caracteres[0].toLowerCase().equals("largura")) {
			resultado = grafo.buscaPorLargura(caracteres[1], caracteres[2]);
			System.out.println(resultado);
		}
		if (caracteres[0].toLowerCase().equals("menor")) {
			resultado = grafo.Dijkstra(caracteres[1], caracteres[2]);
			System.out.println(resultado);
		}
		if (caracteres[0].toLowerCase().equals("prim")) {
			resultado = grafo.prim(caracteres[1]);
			System.out.println(resultado);
		}

	}

	private String[] trataLinha(String linha2) {
		// retira os caracteres do arquivo deixando somente os números
		if (linha2.contains(";"))
			linha2 = linha2.replaceAll(";", "");

		linha2 = linha2.replaceAll(",", "");

		return linha2.split(" ");

	}

}
