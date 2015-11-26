package utilitario;

import java.util.List;

import biblioteca.Grafo;

public class CriaGrafoSaida {

	private static List<String> vertices;
	private static int matAdj[][];
	private static VerificaResultado verificaResultado;

	// Essa classe é utilizada para criar o arquivo que será chamado na página
	// html com os dados do grafo.
	public static boolean CriarSaidaGrafo(Grafo grafo, String diretorio,
			String nome, String resultado) {
		verificaResultado = new VerificaResultado();
		vertices = grafo.getVertices();
		matAdj = grafo.getMatAdj();
		String arquivo;
		System.out.println("Gerando Plotagem do Grafo...");

		arquivo = montaInicioDoGrafo();

		arquivo += criaOsVerticesDoGrafo();

		arquivo += criaAsArestasDoGrafo(nome, resultado);

		diretorio += "js/" + nome + ".js";

		boolean gravadoComSucesso = GravaSaida.gravarSaida(arquivo, diretorio);

		return gravadoComSucesso;

	}

	private static String montaInicioDoGrafo() {

		String viewport = "\"#viewport\"";

		String arquivo = "var sys = arbor.ParticleSystem(1000, 400,1);\n"
				+ "sys.parameters({gravity:true});\n"
				+ "sys.renderer = Renderer(" + viewport + ");\n";
		return arquivo;
	}

	// Cria os vertices do grafo
	private static String criaOsVerticesDoGrafo() {
		String arquivo = "";
		for (int i = 0; i < vertices.size(); i++) {
			String atributosVertice = "'a" + vertices.get(i) + "', {"
					+ "'color':'black','label':'" + vertices.get(i) + "'"
					+ "});";
			arquivo += "var a" + vertices.get(i) + "= sys.addNode("
					+ atributosVertice + "\n";
		}
		return arquivo;

	}

	// Cria as arestas do grafo
	private static String criaAsArestasDoGrafo(String nome, String resultado) {

		String corAresta = "'green'";
		String arquivo = "";
		// Usado para fazer com que as arestas não fiquem muito grande no grafo
		int divisor = defineDivisorDasArestas();

		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (matAdj[i][j] != 0) {
					if (resultado != null) {
						if (arestaDeveTrocarCor(nome, i, j, resultado))
							corAresta = "'red'";
						else
							corAresta = "'green'";
					}

					arquivo += "sys.addEdge('a" + vertices.get(i) + "', 'a"
							+ vertices.get(j) + "',{'color':" + corAresta
							+ ", 'weight':" + matAdj[i][j] / divisor + "});\n";

				}
			}
		}

		return arquivo;

	}

	private static int defineDivisorDasArestas() {
		int media = 0;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				media += matAdj[i][j];
			}
		}
		media = media / vertices.size();

		if (media > 20)
			return 10;
		else if (media > 10)
			return 5;

		return 1;
	}

	private static boolean arestaDeveTrocarCor(String funcao, int i, int j,
			String resultado) {

		switch (funcao) {
		case "distancia1":
			return verificaResultado.verificaNoResultadoDaDistancia(resultado,
					i, j, vertices);
		case "distancia2":
			return verificaResultado.verificaNoResultadoDaDistancia(resultado,
					i, j, vertices);
		case "dijkstra":
			return verificaResultado.verificaNoResultadoDijkstra(vertices,
					resultado, i, j);
		case "prim":
			return verificaResultado.verificaNoResultadoPrimOuKruskal(
					resultado, vertices, i, j);
		case "kruskal":
			return verificaResultado.verificaNoResultadoPrimOuKruskal(
					resultado, vertices, i, j);
		case "buscaPorLargura":
			return verificaResultado.verificaNoResultadoBusca(resultado,
					vertices, i, j);
		case "buscaPorProfundidade":
			return verificaResultado.verificaNoResultadoBusca(resultado,
					vertices, i, j);
		default:
			return false;
		}

	}

	public static void geraHtml(String resultado, String diretorio,
			String nomeArquivo) {
		String saidaHtml = "<body bgcolor ='A2F0E7'  text ='red' >";
		String resultados[] = resultado.split("\n");

		saidaHtml += "<ol><b><u><li > " + resultados[0] + "</li></u></b> </ol>";
		saidaHtml += "<ul><i>\n";
		for (int i = 1; i < resultados.length; i++) {
			saidaHtml += "<p>" + resultados[i] + "</p>\n";
		}
		saidaHtml += "</i><ul>\n";
		saidaHtml += "</body>";

		diretorio += "html/" + nomeArquivo + ".html";

		GravaSaida.gravarSaida(saidaHtml, diretorio);

	}

}
