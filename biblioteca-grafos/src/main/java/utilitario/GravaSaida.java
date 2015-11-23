package utilitario;

import java.io.FileWriter;
import java.io.IOException;

public class GravaSaida {

	public static boolean gravarSaida(String diretorio, String arquivo) {

		try {
			FileWriter fw = new FileWriter(diretorio);
			System.out.println(diretorio);
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
