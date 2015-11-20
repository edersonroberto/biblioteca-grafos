package utilitario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import biblioteca.Grafo;

public class CriaGrafoSaida {

	private static List<String> vertices;
	private static int matAdj[][];

	public static void CriarSaidaGrafo(Grafo grafo, String nome) {
		vertices = grafo.getVertices();
		matAdj = grafo.getMatAdj();
		String viewport = "\"#viewport\"";
		String corAresta = "'blue'";

		String arquivo = "var sys = arbor.ParticleSystem(1000, 400,1);\n"
				+ "sys.parameters({gravity:true});\n"
				+ "sys.renderer = Renderer(" + viewport + ");\n";
		
		//Cria os vertices do grafo
		for (int i = 0; i < vertices.size(); i++) {
			String atributosVertice = "'" + vertices.get(i) + "', {"
					+ "'color':'red','shape':'dot','label':'" + vertices.get(i)
					+ "'" + "});";
			arquivo += "var " + vertices.get(i) + "= sys.addNode("
					+ atributosVertice + "\n";
		}
		
		//Cria as arestas do grafo
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (matAdj[i][j] != 0) {
					if(!nome.equals("principal")){
						if(arestaDeveTrocarCor(nome, vertices));
							corAresta = "red";
					}
					
					arquivo += "sys.addEdge('" + vertices.get(i) + "', '"
							+ vertices.get(j) + "',{'color':"+corAresta +", 'weight':"
							+ matAdj[i][j]+ "});\n";
				}
			}
		}

		System.out.println(arquivo);
		salvaJSon(nome, arquivo);
	}

	private static boolean arestaDeveTrocarCor(String funcao,
			List<String> vertices2) {
		
		if(funcao.equals("distancia")){
			return true;
		}
			
		
		return false;
	}

	private static void salvaJSon(String nome, String arquivo) {

		try {
			File diretorio = new File("");
			FileWriter fw = new FileWriter(diretorio.getAbsolutePath()
					+ "\\src\\main\\webapp\\resources\\js\\" + nome + ".js");
			System.out.println(diretorio.getAbsolutePath()
					+ "\\src\\main\\weapp\\resources\\js\\" + nome + ".js");
			fw.write(arquivo);
			fw.close();
			System.out.println("Arquivo salvo com sucesso!");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "Erro ao salvar arquivo.");
		}

	}

}
