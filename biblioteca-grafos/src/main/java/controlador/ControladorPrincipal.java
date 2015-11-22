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
	private ControladorSaida controladorSaida;

	
	public boolean controlaFluxo(String arquivo){
		
		ControladorGrafo controlarGrafo = new ControladorGrafo();
		ControladorDeComandos controladorDeComandos = new ControladorDeComandos();
		controladorSaida = new ControladorSaida();

		linhas = leArquivoDeEntrada(arquivo);
		
		if(linhas != null){
			
			grafo = controlarGrafo.montaGrafo(linhas);
			CriaGrafoSaida.CriarSaidaGrafo(grafo, "principal", null);
			controladorDeComandos.executaComandos(grafo, linhas, controladorSaida);
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
	
	
	public ControladorSaida getControladorSaida() {
		return controladorSaida;
	}

	public void setControladorSaida(ControladorSaida controladorSaida) {
		this.controladorSaida = controladorSaida;
	}
	
}
