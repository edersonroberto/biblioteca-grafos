package utilitario;

import java.util.List;

public class VerificaResultado {
	
	public static String verificaNoResultadoDaDistancia(String resultado, String saidaGrafo) {
		String saidaComando = saidaGrafo;
		
		VerificaResultado.verificaNoResultadoDaDistancia(resultado, saidaGrafo );
		String resultDis2[] = resultado.split(" ");

		for (int i = 0; i < resultDis2.length - 1; i++) {
			saidaComando = trocaCorVertice(resultDis2[i + 1], saidaComando);
			saidaComando = trocaCorAresta(resultDis2[i], resultDis2[i + 1],
					saidaComando);
		}
		
		return saidaComando;
	}
	
	private static String trocaCorAresta(String vertice1, String vertice2,
			String saidaResultado) {

		String saidasGrafo[] = saidaResultado.split("\n");
		String saida = "";

		for (int i = 0; i < saidasGrafo.length; i++) {

			if (saidasGrafo[i].contains("addEdge")) {
				if (saidasGrafo[i].contains(vertice1)
						&& saidasGrafo[i].contains(vertice2))
					saidasGrafo[i] = saidasGrafo[i].replace("green", "red");
			}
			saida += saidasGrafo[i] + "\n";
		}

		return saida;

	}

	private static String trocaCorVertice(String vertice, String saidaGrafo) {
		String saidasGrafo[] = saidaGrafo.split("\n");
		String saida = "";

		for (int i = 0; i < saidasGrafo.length; i++) {

			if (saidasGrafo[i].contains("addNode")) {
				if (saidasGrafo[i].contains(vertice))
					saidasGrafo[i] = saidasGrafo[i].replace("green", "red");
			}
			saida += saidasGrafo[i] + "\n";
		}

		return saida;

	}
	
	public static String verificaNoResultadoDijkstra(List<String> vertices, String resultado, int i, int j) {

		String resultados[] = resultado.split(" ");
		for (int ii = 0; ii < resultados.length - 2; ii++) {
			if (vertices.get(ii + 1).equals(resultados[ii])
					&& (vertices.get(j).equals(resultados[ii + 1]))) {
				return null;
			}

		}

		return null;
	}
	
	public boolean verificaNoResultadoPrimOuKruskal(String resultado,
			List<String> vertices, int i, int j) {
		String resultados[] = resultado.split("\n");
		for (int k = 1; k < resultados.length; k++) {
			String result[] = resultados[k].split(" ");

			if (result[0].equals(vertices.get(i))
					&& result[1].equals(vertices.get(j)))
				return true;
		}

		return false;
	}
	
	public static String verificaNoResultadoBusca(String resultado,
			String saidaGrafo) {
		String resultados[] = resultado.split("\n");

		

		return null;
	}

}
