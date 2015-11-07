package controlador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArquivoDeEntrada {

	private FileInputStream arquivo;
	private InputStreamReader isr;
	private BufferedReader br;
	private List<String> linhasArquivo ;
	private String linha = "";


	public List<String> trataArquivoDeEntrada(String camArquivo) {
		boolean foiLido;
		
		try {
			arquivo = new FileInputStream(camArquivo);
			isr = new InputStreamReader(arquivo);
			br = new BufferedReader(isr);
			foiLido = leArquivo(arquivo);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado" + e.getMessage());
			foiLido =  false;
		} catch (IOException e) {
			System.out.println("Falha ao ler arquivo" + e.getMessage());
			foiLido =  false;
		}
		if(foiLido)
			return linhasArquivo;
		else
			return null;
	

	}

	private boolean leArquivo(FileInputStream arquivo) throws IOException {
		linha = br.readLine();
		
		linhasArquivo = new ArrayList<String>();
		while(linha != null){
			linhasArquivo.add(linha);
			linha = br.readLine();
		}
		
		return true;

	}	

}
