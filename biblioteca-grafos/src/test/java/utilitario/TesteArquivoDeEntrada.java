package utilitario;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TesteArquivoDeEntrada {

	@Test
	public void TestaArquivoDeEntrada() {

		String camArquivo = "arquivo.txt";
		List<String> arquivoRetornado = new ArrayList<String>();

		ArquivoDeEntrada arqEntrada = new ArquivoDeEntrada();
		try {
			arquivoRetornado = arqEntrada.trataArquivoDeEntrada(camArquivo);
		} catch (IOException e) {

			e.printStackTrace();
		}
		assertEquals(22, arquivoRetornado.size());

	}

	@Test(expected = IOException.class)
	public void TestaArquivoDeEntradaInexistente() throws IOException {

		ArquivoDeEntrada arqEntrada = new ArquivoDeEntrada();

		arqEntrada.trataArquivoDeEntrada("nao existe.txt");

	}
	
	@Test
	public void TestaArquivoDeEntradaVazio() throws IOException {
		ArquivoDeEntrada arqEntrada = new ArquivoDeEntrada();
		List<String> arquivoRetornado = new ArrayList<String>();
		
		arquivoRetornado = arqEntrada.trataArquivoDeEntrada("arquivoVazio.txt");
		assertEquals(null, arquivoRetornado);
	}

}
