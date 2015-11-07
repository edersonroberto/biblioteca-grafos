package controlador;

import java.util.ArrayList;
import java.util.List;

import utilitario.TrataLinha;
import biblioteca.Grafo;

public class ControladorGrafo {

	private String linha;
	private boolean ehDirecionado;
	private boolean temPeso;
	private Grafo grafo;
	private List<String> vertices;
	private int[][] arrayAdj;
	private String[] caracteres;

	public Grafo montaGrafo(List<String> linhas) {
		
		linhas.remove("Grafo");
		montaVertices(linhas);
		
		
		// Verifica se o vertice é direcionado e se ele tem peso
		if (linha.contains("true"))
			ehDirecionado = true;
		linhas.remove(0);
		
		if (linha.contains("true"))
			temPeso = true;
		
		while(!linhas.get(0).equals("Arestas"))
			linhas.remove(0);
		
		arrayAdj = montaArrayAdjacencia(linhas);

		grafo = new Grafo(vertices, arrayAdj);

		return grafo;
	}

	private void montaVertices(List<String> linhas){
		TrataLinha trataLinha = new TrataLinha();
		vertices = new ArrayList<String>();
		
		linha = linhas.get(0);
	
		caracteres = trataLinha.trataLinha(linha);

		for (String caracter : caracteres) {
			vertices.add(caracter);
		}
		linhas.remove(0);

	}
	
	private int[][] montaArrayAdjacencia(List<String> linhas) {
		TrataLinha trataLinha = new TrataLinha();
		int tamArray = vertices.size();
		arrayAdj = new int[tamArray][tamArray];
	
		linhas.remove(0);
			
		while(!linhas.get(0).equals("")){	
			linha = linhas.get(0);
			caracteres = trataLinha.trataLinha(linha);
			
			for (int i = 0; i < vertices.size(); i++) {
				if (vertices.get(i).equals(caracteres[0])) {
					for (int j = 0; j < vertices.size(); j++) {
						if (caracteres[1].equals(Integer.toString(j))) {
							setValorMat(i, j);
						}
					}
					break;
				}
			}
			linhas.remove(0);
		}
		
		return arrayAdj;
	}

	private void setValorMat(int i, int j) {
		int valorMat = 0;
		//Verifica se o grafo tem peso
		if (temPeso == false)
			valorMat = 1;
		else
			 valorMat = Integer.parseInt(caracteres[2]);
		
		arrayAdj[i][j] = valorMat;
		//verifica se o grafo é direcionado, caso não seja
		//será necessario adicionar a conexão para ambos os vertices.
		if (ehDirecionado == false)
			arrayAdj[j][i] = valorMat;

	}
	
	
}
