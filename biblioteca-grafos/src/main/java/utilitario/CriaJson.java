package utilitario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import biblioteca.Aresta;
import biblioteca.Grafo;

public class CriaJson {
	
	private List<String> vertices;
	private List<Aresta> arestas;
	private int matAdj[][];
	
	public void CriarJon(Grafo grafo) {
		vertices = grafo.getVertices();
		arestas = grafo.getArestas();
		matAdj = grafo.getMatAdj();
		
		JSONObject vertice = new JSONObject();
		JSONObject atributosVert = new JSONObject();
		JSONObject grafoJs = new JSONObject();
		JSONObject arestaJs = new JSONObject();
		JSONObject atributoAres = new JSONObject();
	
		
		atributosVert.put("color", "blue");
		atributosVert.put("length", 50);
		atributosVert.put("borders", 80);
		
		for (String v : vertices) {
			vertice.put(v, atributosVert);
		}
		

		boolean temConexao = false;
		for(int i=0; i< vertices.size(); i++){
			for(int j=0; j< vertices.size(); j++){
				if(matAdj[i][j] != 0) {
				
					atributoAres.put(vertices.get(j), matAdj[i][j]);
					temConexao = true;
				}
			}
			if(temConexao){
				arestaJs.put(vertices.get(i), atributoAres);
				temConexao = false;
				atributoAres = new JSONObject();
			}
				
		}
		
		grafoJs.put("nodes", vertice);
		grafoJs.put("edges", arestaJs);
		
		salvaJSon("principal", grafoJs);
		
	}

	private void salvaJSon(String caminho, JSONObject grafoJs) {
		
		try {
			File diretorio = new File("");
			FileWriter fw = new FileWriter(diretorio.getAbsolutePath() + "\\src\\main\\webapp\\maps\\principal.json");
			System.out.println(diretorio.getAbsolutePath() + "\\src\\main\\webapp\\resources\\js\\principal.json");
			fw.write(grafoJs.toString());
			fw.close();
			System.out.println("Arquivo salvo com sucesso!");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "Erro ao salvar arquivo.");
		}
		
	}
	

}
