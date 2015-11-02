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
	private List<Vertice> vertices;
	private List<Aresta> arestas;
	private FileInputStream arquivo;
	private InputStreamReader isr;
	private BufferedReader br;
	private boolean temPeso;
	private boolean ehDirecionado;
	private Vertice origem;
	private Vertice destino;

	public static void main(String[] args) {
		ArquivoDeEntrada arquivoEntrada = new ArquivoDeEntrada();
		arquivoEntrada.trataArquivoDeEntrada();
	}

	public void trataArquivoDeEntrada() {

		try {
			arquivo = new FileInputStream("arquivo.txt");
			isr = new InputStreamReader(arquivo);
			br = new BufferedReader(isr);

			montaGrafo(arquivo);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void montaGrafo(FileInputStream arquivo) throws IOException {
		String linha;
		vertices = new ArrayList<Vertice>();
		arestas = new ArrayList<Aresta>();
		linha = br.readLine();
		
		do {
			System.out.println(linha);
			if (linha.toLowerCase().equals("grafo")) {
				linha = br.readLine();
				montaVertice(linha);
				linha = br.readLine();
				if (linha.equals(true))
					ehDirecionado = true;
				
				linha = br.readLine();
				if (linha.equals(true))
					temPeso = true;

			}
			if (linha.toLowerCase().equals("arestas")) {
				linha = br.readLine();
				while (!linha.equals("")) {
					montaArestas(linha);
					linha = br.readLine();
				}
			}
			if(linha.toLowerCase().equals("comandos")){
				grafo = new Grafo(vertices, arestas);
				linha = br.readLine();
				montaComandos();
			}
			linha = br.readLine();
		} while (linha != null);

	}

	private void montaComandos() throws IOException {
		String linha = br.readLine();
		String caracteres[] = linha.split(" ");
		
		if (caracteres[0].toLowerCase().equals("distancia")){
			
		}
		if (caracteres[0].toLowerCase().equals("profundidade")) {
			origem.setNome(caracteres[1]);
			destino.setNome(caracteres[2]);
			executaBuscaPorProfundiade(origem, destino);
		}
		if	(caracteres[0].toLowerCase().equals("largura")){
	
		}
		if(caracteres[0].toLowerCase().equals("Menor Caminho")) {	
		
		}
		
	}

	private void executaBuscaPorProfundiade(Vertice origem2, Vertice destino2) {

		grafo.buscaPorProfundidade(origem2, destino);
		
	}

	private void montaArestas(String linha) {
		int cont = 1;
		Aresta aresta = new Aresta();
		Vertice vertice1 = new Vertice();
		Vertice vertice2 = new Vertice();
		String caracteres[] = {};
		caracteres = linha.split(" ");

		aresta.setNome(caracteres[0] + caracteres[1]);
		vertice1.setNome(caracteres[0]);
		vertice2.setNome(caracteres[1]);
		aresta.setVertice1(vertice1);
		aresta.setVertice2(vertice2);
		arestas.add(aresta);

	}

	private void montaVertice(String linha) {
		Vertice vertice = new Vertice();
		String caracteres[] = {};
		caracteres = linha.split(" ");

		for (String caracter : caracteres) {
			if (caracter.contains(";")) {
				String subCaracteres[] = caracter.split(";");
				vertice.setNome(subCaracteres[0]);
				vertices.add(vertice);
			} else {
				vertice.setNome(caracter);
				vertices.add(vertice);
			}
		}

	}

}
