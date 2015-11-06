package biblioteca;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArquivoDeEntrada {

	private Grafo grafo;
	private List<String> vertices;
	private int arrayAdj[][] = {};
	private FileInputStream arquivo;
	private InputStreamReader isr;
	private BufferedReader br;
	private boolean temPeso;
	private boolean ehDirecionado;
	//private String origem;
	//private String destino;
	String linha = "";
	String caracteres[] = {};

	public static void main(String[] args) throws IOException {
		ArquivoDeEntrada arquivoEntrada = new ArquivoDeEntrada();
		arquivoEntrada.trataArquivoDeEntrada();
	}

	public void trataArquivoDeEntrada() throws IOException {

		try {
			arquivo = new FileInputStream("arquivo.txt");
			isr = new InputStreamReader(arquivo);
			br = new BufferedReader(isr);

			leArquivo(arquivo);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			br.close();
		}

	}

	private void leArquivo(FileInputStream arquivo) throws IOException {
		linha = br.readLine();

		montaGrafo();
		linha = br.readLine();
		
		executaComandos();

	}

	private void executaComandos() throws IOException {
		
		String resultado = "";
		while(!(linha.equals(""))){
			trataLinha(linha);
			
			if (caracteres[0].toLowerCase().contains("distancia")){
				//executa metodo para descobrir a distancia
			}
			if (caracteres[0].toLowerCase().equals("profundidade")){
				resultado = grafo.buscaPorProfundidade(vertices.get(0), vertices.get(vertices.size()-1));
				System.out.println(resultado);
			}
			if (caracteres[0].toLowerCase().equals("largura")){
				resultado = grafo.buscaPorLargura(vertices.get(0), vertices.get(vertices.size()-1));
				System.out.println(resultado);
			}
			if (caracteres[0].toLowerCase().equals("menor")){
				resultado = grafo.Dijkstra(vertices.get(0), vertices.get(vertices.size()-1));
				System.out.println(resultado);
			}
			
			linha = br.readLine();
			
			if (linha == null)
				break;
		}
		
	}

	private void montaGrafo() throws IOException {
		montaVertice();
		linha = br.readLine();
		// Verifica se o vertice é direcionado e se ele tem peso
		if (linha.contains("true"))
			ehDirecionado = true;
		linha = br.readLine();
		if (linha.contains("true"))
			temPeso = true;

		arrayAdj = montaArrayAdjacencia();
		
		grafo = new Grafo (vertices, arrayAdj);

	}

	private int[][] montaArrayAdjacencia() throws IOException {
		int tamArray = vertices.size();
		arrayAdj = new int[tamArray][tamArray];

		while (!linha.toLowerCase().equals("arestas")) {
			linha = br.readLine();
		}
	
		while (!linha.equals("")) {
			
			trataLinha(linha);
			
			for (int i = 0; i < vertices.size(); i++) {
 				if (vertices.get(i).equals(caracteres[0])) {
					for (int j = 0; j < vertices.size(); j++) {
						if (caracteres[1].equals(Integer.toString(j))) {
							if(temPeso == false)
								arrayAdj[i][j] = 1;
							else
								arrayAdj[i][j] = Integer.parseInt(caracteres[2]);
						}
					}
					break;
				}
			}
			linha = br.readLine();
		}
		return arrayAdj;

	}

	private void montaVertice() throws IOException {
	
		vertices = new ArrayList<String>();
		
		String linha = br.readLine();
		trataLinha(linha);

		for (String caracter : caracteres) {
			vertices.add(caracter);
		}
		
		
	}
	
	private void trataLinha(String linha2) {

		if(linha2.contains(";"))
			linha2 = linha2.replaceAll(";", "");
		
		linha2 = linha2.replaceAll(",", "");
		caracteres = linha2.split(" ");
		
	}
	
	
}
