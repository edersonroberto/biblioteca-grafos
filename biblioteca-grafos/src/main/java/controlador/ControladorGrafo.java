package controlador;

import java.util.ArrayList;
import java.util.List;

import utilitario.TrataLinha;
import biblioteca.Aresta;
import biblioteca.Grafo;

public class ControladorGrafo {

	private String linha;
	private boolean ehDirecionado;
	private boolean temPeso;
	private Grafo grafo;
	private List<String> vertices;
	private List<Aresta> arestas;
	private Aresta aresta;
	private int[][] arrayAdj;
	private String[] caracteres;
	

	public Grafo montaGrafo(List<String> linhas) {
		
		vertices = new ArrayList<String>();
		arestas = new ArrayList<Aresta>();
		boolean ehConexo;
		
		linhas.remove("Grafo");
		montaVertices(linhas);
		
		linha = linhas.get(0);
		// Verifica se o vertice é direcionado e se ele tem peso
		if (linha.contains("true"))
			ehDirecionado = true;
		linhas.remove(0);
		
		linha = linhas.get(0);
		if (linha.contains("true"))
			temPeso = true;
		
		while(!linhas.get(0).equals("Arestas"))
			linhas.remove(0);
		
		arrayAdj = montaArrayAdjacencia(linhas);
		
		ehConexo = verificaConexidade();
		
		grafo = new Grafo(vertices, arrayAdj, arestas, ehConexo, temPeso, ehDirecionado);

		return grafo;
	}



	private void montaVertices(List<String> linhas){
		TrataLinha trataLinha = new TrataLinha();
		
		
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
			
			montaArestas();
			
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

	private void montaArestas() {
		
		aresta = new Aresta(caracteres[0], caracteres[1], Integer.parseInt(caracteres[2]));
		arestas.add(aresta);
		
		
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
	
	private boolean verificaConexidade() {

		for (Aresta aresta : arestas) {
			for (String v : vertices) {
				if(aresta.getOrigem().equals(v) || aresta.getDestino().equals(v))
					return true;
			}
			
		}
		
		return false;
	}
	
	
}
