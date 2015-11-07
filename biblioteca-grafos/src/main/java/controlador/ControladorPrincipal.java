package controlador;

import java.util.List;

import biblioteca.Grafo;

public class ControladorPrincipal {
	
	private Grafo grafo;
	
	public boolean controlaFluxo(){
	
		List<String> linhas ; 
		
		ArquivoDeEntrada arqEntrada = new ArquivoDeEntrada();
		linhas = arqEntrada.trataArquivoDeEntrada("arquivo.txt");
		
		
		ControladorGrafo controlarGrafo = new ControladorGrafo();
		grafo = controlarGrafo.montaGrafo(linhas);
		
		ControladorDeComandos controladorDeComandos = new ControladorDeComandos();
		controladorDeComandos.executaComandos(grafo, linhas);
		
		return true;
	}
	
}
