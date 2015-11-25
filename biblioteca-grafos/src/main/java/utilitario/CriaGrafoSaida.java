package utilitario;

import java.util.List;

import biblioteca.Grafo;

public class CriaGrafoSaida {

	private static List<String> vertices;
	private static int matAdj[][];


	// Essa classe é utilizada para criar o arquivo que será chamado na página
	// html com os dados do grafo.
	public static boolean CriarSaidaGrafo(Grafo grafo, String diretorio, String nome, String resultado) {
		vertices = grafo.getVertices();
		matAdj = grafo.getMatAdj();
		String arquivo;
		System.out.println("Gerando Plotagem do Grafo...");
		
		arquivo = montaInicioDoGrafo();
				
		criaOsVerticesDoGrafo();
	
		criaAsArestasDoGrafo(nome, resultado);
		
		diretorio += "js/" +nome + ".js"; 
		
		boolean gravadoComSucesso = GravaSaida.gravarSaida(diretorio, arquivo);
		
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
	private static void criaOsVerticesDoGrafo() {
		String arquivo = "";		
		for (int i = 0; i < vertices.size(); i++) {
			String atributosVertice = "'a" + vertices.get(i) + "', {"
					+ "'color':'black','label':'" + vertices.get(i)
					+ "'" + "});";
			arquivo += "var a" + vertices.get(i) + "= sys.addNode("
					+ atributosVertice + "\n";
		}

	}
	
	// Cria as arestas do grafo
	private static String criaAsArestasDoGrafo(String nome, String resultado) {
		
		String corAresta = "'green'";
		String arquivo = "";
		
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (matAdj[i][j] != 0) {
					if (resultado != null) {
						if (arestaDeveTrocarCor(nome, vertices, i, j, resultado))
							corAresta = "'red'";
					}

					arquivo += "sys.addEdge('a" + vertices.get(i) + "', 'a"
							+ vertices.get(j) + "',{'color':" + corAresta
							+ ", 'weight':" + matAdj[i][j] + "});\n";
					
					corAresta = "'green'";
				}
			}
		}
		
		return arquivo;
		
	}
	

	private static boolean arestaDeveTrocarCor(String funcao,
			List<String> vertices2, int i, int j, String resultado) {

		switch(funcao){
			case "distancia1":
				return verificaNoResultadoDaDistancia(resultado, vertices, i, j);
			case "distancia2":
				return verificaNoResultadoDaDistancia(resultado, vertices, i, j);
			case "dijkstra":
				return verificaNoResultadoDijkstra(resultado, vertices, i, j);
			case "prim":
				return verificaNoResultadoPrimOuKruskal(resultado, vertices, i, j);
			case "kruskal":
				return verificaNoResultadoPrimOuKruskal(resultado, vertices, i, j);
			case "buscaPorLargura":
				return verificaNoResultadoBusca(resultado, vertices, i, j);
			case "buscaPorProfundidade":
				return verificaNoResultadoBusca(resultado, vertices, i, j);
			default:
				return false;
		}
		
	}

	private static boolean verificaNoResultadoPrimOuKruskal(String resultado,
			List<String> vertices2, int i, int j) {
		String resultados[] = resultado.split("\n");
		for (int k = 1; k < resultados.length; k++) {
			String result[] = resultados[k].split(" ");
			
			if(result[0].equals(vertices.get(i)) && result[1].equals(vertices.get(j)))
				return true;
		}
		
		
		return false;
	}


	private static boolean verificaNoResultadoBusca(String resultado,
			List<String> vertices2, int i, int j) {
		String resultados[] =resultado.split("\n");
		
		for(int ii = 1; ii < resultados.length-2; ii++ ){
			if(resultados[ii].contains("foi visitado")){
				if(resultados[ii].contains(vertices.get(i))){
					if(resultados[ii+2].contains(vertices.get(j)))
						return true;
				}
				
			}
		}
	
		
		return false;
	}

	private static boolean verificaNoResultadoDijkstra(String resultado,
			List<String> vertices2, int i, int j) {

		String resultados[] = resultado.split(" ");
		for(int ii =0; ii < resultados.length-2; ii++){
			if(vertices.get(ii+1).equals(resultados[ii]) && (vertices.get(j).equals(resultados[ii+1]))){
				return true;
			}
			
		}
		
		return false;
	}

	private static boolean verificaNoResultadoDaDistancia(String resultado,
			List<String> vertices2, int i, int j) {
		resultado = resultado.replace(":", "");
		String resultados []= resultado.split(" ");
		
		for(int ii=1; ii< resultados.length-1; ii++){
			if(vertices.get(i).equals(resultados[ii]) && (vertices.get(j).equals(resultados[ii+1]))){
				return true;
			}
		}
		
		return false;
		
	}

	public static void geraHtml(String resultado,String diretorio, String nomeArquivo) {
		
		
		resultado = resultado.replace("\n", "</p>\n<p>");
		String saidaHtml = "<p>"+ resultado + "</p>";
		diretorio += "html/" + nomeArquivo + ".html";
		
		GravaSaida.gravarSaida(diretorio, saidaHtml);
		
	}

}
