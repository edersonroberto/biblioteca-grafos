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
	private int arrayAdjacencia[][] = {};
	private FileInputStream arquivo;
	private InputStreamReader isr;
	private BufferedReader br;
	private boolean temPeso;
	private boolean ehDirecionado;
	private String origem;
	private String destino;
	String linha = "";
	String caracteres[] = {};

	public static void main(String[] args) {
		ArquivoDeEntrada arquivoEntrada = new ArquivoDeEntrada();
		arquivoEntrada.trataArquivoDeEntrada();
	}

	public void trataArquivoDeEntrada() {

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
		}

	}

	private void leArquivo(FileInputStream arquivo) throws IOException {
		linha = br.readLine();

		montaGrafo();
		linha = br.readLine();
		
		executaComandos();

	}

	private void executaComandos() throws IOException {
		
		while(!(linha.equals("")) || (linha != null)){
			linha = br.readLine();
			caracteres = linha.split(" ");
			if (caracteres[0].toLowerCase().contains("distancia")){
				//executa metodo para descobrir a distancia
			}
			if (caracteres[0].toLowerCase().contains("profundidade")){
				//executa busca por profundidade
			}
			if (caracteres[0].toLowerCase().contains("largura")){
				//executa busca por largura
			}
			if (caracteres[0].toLowerCase().contains("menor caminho")){
				//executa algoritmo de dijska
			}
			
		}
		
	}

	private void montaGrafo() throws IOException {
		montaVertice();

		// Verifica se o vertice é direcionado e se ele tem peso
		if (br.readLine().equals("true"))
			ehDirecionado = true;
		if (br.readLine().equals("true"))
			temPeso = true;

		montaArrayAdjacencia();
		
		grafo = new Grafo (vertices, arrayAdjacencia);

	}

	private void montaArrayAdjacencia() throws IOException {
		int tamArray = vertices.size() - 1;
		arrayAdjacencia = new int[tamArray][tamArray];

		while (!linha.toLowerCase().equals("arestas")) {
			linha = br.readLine();
		}
	
		while (!linha.equals("")) {
			linha = br.readLine();
			linha = linha.replaceAll(",", "");
			caracteres = linha.split(" ");
			for (int i = 0; i < vertices.size() - 1; i++) {
				if (vertices.get(i).equals(caracteres[0])) {
					for (int j = 0; j < vertices.size() - 1; j++) {
						if (caracteres[1].equals(Integer.toString(j))) {
							arrayAdjacencia[i][j] = 1;
						}
					}
					break;
				}
			}
		}

	}

	private void montaVertice() throws IOException {
		
		vertices = new ArrayList<String>();
		
		String linha = br.readLine();
		String caracteres[] = linha.split(" ");

		for (String caracter : caracteres) {
			if (caracter.contains(";")) {
				String subCaracteres[] = caracter.split(";");
				vertices.add(subCaracteres[0]);
				continue;
			}
			vertices.add(caracter);
		}
	}
}
