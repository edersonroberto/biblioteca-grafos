package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import utilitario.ArquivoDeEntrada;
import utilitario.CriaGrafoSaida;
import biblioteca.Grafo;

@ManagedBean(name="ControladorPrincipal")
@SessionScoped
public class ControladorPrincipal {
	
	private Grafo grafo;
	private List<String> linhas ;
	private ArquivoDeEntrada arqEntrada;
	private String saidaGrafo;
	
	public boolean controlaFluxo(String diretorioLido, String diretorioAserSalvo){
		
		ControladorGrafo controlarGrafo = new ControladorGrafo();
		ControladorDeComandos controladorDeComandos = new ControladorDeComandos();
	 
		
		linhas = leArquivoDeEntrada(diretorioLido);
		
		if(linhas != null){
			
			grafo = controlarGrafo.montaGrafo(linhas);
			saidaGrafo = CriaGrafoSaida.CriarSaidaGrafo(grafo,diretorioAserSalvo, "principal", null);
			controladorDeComandos.executaComandos(grafo, linhas,diretorioAserSalvo, saidaGrafo);
			return true;
		}
		
		return false;
	}

	private List<String> leArquivoDeEntrada(String arquivo) {
		
		arqEntrada = new ArquivoDeEntrada();
		linhas = new ArrayList<String>();
		
		try {
			linhas = arqEntrada.trataArquivoDeEntrada(arquivo);
		} catch (IOException e) {
			System.out.println("Falha ao ler arquivo " + e.getMessage());
		}
		
		return linhas;
	}
	
	
}
