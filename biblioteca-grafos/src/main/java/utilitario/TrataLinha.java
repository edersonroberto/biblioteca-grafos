package utilitario;

public class TrataLinha {
	
	
	public static String[] trataLinha(String linha) {
		String[] caracteres;
		
		//retira os caracteres do arquivo deixando somente os números 
		if (linha.contains(";"))
			linha = linha.replaceAll(";", "");

		if (linha.contains(":"))
			linha = linha.replaceAll(":", "");
		
		linha = linha.replaceAll(",", "");
		caracteres = linha.split(" ");
	
		
		return caracteres;

	}
	
}
