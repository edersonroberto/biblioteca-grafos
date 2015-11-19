package utilitario;

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
		atributosVert.put("border", 80);
		
		for (String v : vertices) {
			vertice.put(v, atributosVert);
		}
		
		for(int i=0; i< vertices.size(); i++){
			for(int j=0; j< vertices.size(); j++){
				if(matAdj[i][j] != 0) {
					atributoAres.put(vertices.get(j), matAdj[i][j]);
					arestaJs.put(vertices.get(i), atributoAres);
				}
			}
			
		}
		
		grafoJs.put("nodes", vertice);
		grafoJs.put("edges", arestaJs);
		System.out.print(grafoJs);
		
		
		
	}
	

}
