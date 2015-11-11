package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utilitario.ArquivoDeEntrada;
import biblioteca.Grafo;

public class ControladorPrincipal {
	
	private Grafo grafo;
	List<String> linhas ;
	ArquivoDeEntrada arqEntrada;
	
	public boolean controlaFluxo(){
		
		ControladorGrafo controlarGrafo = new ControladorGrafo();
		ControladorDeComandos controladorDeComandos = new ControladorDeComandos();
		linhas = leArquivoDeEntrada();
		
		if(linhas != null){
			
			grafo = controlarGrafo.montaGrafo(linhas);
			controladorDeComandos.executaComandos(grafo, linhas);
			return true;
		}
		
		return false;
	}

	private List<String> leArquivoDeEntrada() {
		
		arqEntrada = new ArquivoDeEntrada();
		linhas = new ArrayList<String>();
		
		try {
			linhas = arqEntrada.trataArquivoDeEntrada("arquivo.txt");
		} catch (IOException e) {
			System.out.println("Falha ao ler arquivo " + e.getMessage());
		}
		
		return linhas;
	}
	
}
