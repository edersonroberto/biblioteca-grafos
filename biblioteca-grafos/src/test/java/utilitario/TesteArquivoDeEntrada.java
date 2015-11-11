package utilitario;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utilitario.ArquivoDeEntrada;

public class TesteArquivoDeEntrada {
	
	@Test
	public void TestaArquivoDeEntrada(){
		
		String camArquivo = "arquivo.txt"; 
		List<String> arquivoRetornado = new ArrayList<String>();
		
		ArquivoDeEntrada arqEntrada = new ArquivoDeEntrada();
		try {
			arquivoRetornado = arqEntrada.trataArquivoDeEntrada(camArquivo);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
 		assertEquals(21, arquivoRetornado.size());
		
	}
	
}
