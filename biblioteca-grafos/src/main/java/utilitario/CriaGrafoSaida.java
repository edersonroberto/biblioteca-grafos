package utilitario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import biblioteca.Grafo;

public class CriaGrafoSaida {

	private static List<String> vertices;
	private static int matAdj[][];
	private static String arquivo;

	// Essa classe é utilizada para criar o arquivo que será chamado na página
	// html com os dados do grafo.
	public static void CriarSaidaGrafo(Grafo grafo, String nome, String resultado) {
		vertices = grafo.getVertices();
		matAdj = grafo.getMatAdj();
		System.out.println("Gerando Plotagem do Grafo...");

		String viewport = "\"#viewport\"";
		String corAresta = "'black'";

		arquivo = "var sys = arbor.ParticleSystem(1000, 400,1);\n"
				+ "sys.parameters({gravity:true});\n"
				+ "sys.renderer = Renderer(" + viewport + ");\n";

		
		criaOsVerticesDoGrafo();
	
		criaAsArestasDoGrafo(corAresta, nome, resultado);
		
		
		File file = new File("");
		System.out.println("Absolute: " + file.getAbsolutePath());
		try {
			System.out.println("Canonical: " + file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String diretorio = "http:///localhost:8080/biblioteca-grafos/scr/main/webapp/resources/js/"+nome+ ".js"; 
		gravaSaida(diretorio, arquivo);
	}

	// Cria os vertices do grafo
	private static void criaOsVerticesDoGrafo() {
				
		for (int i = 0; i < vertices.size(); i++) {
			String atributosVertice = "'a" + vertices.get(i) + "', {"
					+ "'color':'blue','shape':'dot','label':'" + vertices.get(i)
					+ "'" + "});";
			arquivo += "var a" + vertices.get(i) + "= sys.addNode("
					+ atributosVertice + "\n";
		}

	}
	
	// Cria as arestas do grafo
	private static void criaAsArestasDoGrafo(String corAresta, String nome, String resultado) {

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
					
					corAresta = "'blue'";
				}
			}
		}

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
				return false;
			case "kruskal":
				return false;
			case "busca":
				return false;
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

	private static void gravaSaida(String diretorio, String arquivo) {

		try {
			
			FileWriter fw = new FileWriter(diretorio);
			System.out.println(diretorio);
			fw.write(arquivo);
			fw.close();
			System.out.println("Arquivo salvo com sucesso!");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "Erro ao salvar arquivo.");
		}

	}

	public static void geraHtml(String resultado, String nomeArquivo) {
		
		
		resultado = resultado.replace("\n", "</p>\n<p>");
		String saidaHtml = "<p>"+ resultado + "</p>";
		String diretorio = "c:\\saida\\html\\"+nomeArquivo+ ".html";//verificaDiretorio(nomeArquivo+".html");
		
		gravaSaida(diretorio, saidaHtml);
		
	}

}
