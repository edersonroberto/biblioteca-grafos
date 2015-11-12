package utilitario;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArquivoDeEntrada {

	private FileInputStream arquivo;
	private InputStreamReader isr;
	private BufferedReader br;
	private List<String> linhasArquivo;
	private String linha = "";

	public List<String> trataArquivoDeEntrada(String camArquivo)
			throws IOException {

		boolean foiLido;
		
		arquivo = new FileInputStream(camArquivo);
		isr = new InputStreamReader(arquivo);
		br = new BufferedReader(isr);
		foiLido = leArquivo(arquivo);
		br.close();

		if(foiLido)
			return linhasArquivo;
		
		return null;

	}

	private boolean leArquivo(FileInputStream arquivo) throws IOException {
		linha = br.readLine();

		linhasArquivo = new ArrayList<String>();
		
		if(linha != null){
			while (linha != null) {
				linhasArquivo.add(linha);
				linha = br.readLine();
			}
			return true;
		}

		return false;

	}

}
