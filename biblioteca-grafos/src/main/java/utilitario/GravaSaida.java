package utilitario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class GravaSaida {

	public static boolean gravarSaida(String arquivo, String diretorio) {

		try {
			deletaArquivoSeJaExiste(diretorio);
			FileWriter fw = new FileWriter(diretorio);
			fw.write(arquivo);
			fw.close();
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	private static void deletaArquivoSeJaExiste(String diretorio) {

		String subDiretorio = diretorio
				.substring(0, diretorio.lastIndexOf("/"));
		String nomeArquivo = diretorio
				.substring(diretorio.lastIndexOf("/") + 1);
		File f = new File(subDiretorio);
		if (f.isDirectory()) {
			File[] files = f.listFiles();

			for (File file : files) {
				if (file.getName().equals(nomeArquivo))
					file.delete();
			}
		}

	}

}
