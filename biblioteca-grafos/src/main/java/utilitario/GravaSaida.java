package utilitario;

import java.io.FileWriter;
import java.io.IOException;

public class GravaSaida {

	public static boolean gravarSaida(String arquivo, String diretorio) {

		try {
			FileWriter fw = new FileWriter(diretorio);
			
			if(arquivo.length() <= 0)
				throw new RuntimeException("Não foi possível realizar gravação - Verifique se o arquivo contém dados");
			fw.write(arquivo);
			fw.close();
			System.out.println("Arquivo salvo com sucesso!");
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
}
