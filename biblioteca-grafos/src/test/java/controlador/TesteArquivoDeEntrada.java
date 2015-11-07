package controlador;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteArquivoDeEntrada {
	
	@Test
	public void TestaArquivoDeEntrada(){
		
		String camArquivo = "arquivo.txt"; 
		List<String> arquivoRetornado;
		
		ArquivoDeEntrada arqEntrada = new ArquivoDeEntrada();
		arquivoRetornado = arqEntrada.trataArquivoDeEntrada(camArquivo);
 		assertEquals(21, arquivoRetornado.size());
		
	}
	
}
