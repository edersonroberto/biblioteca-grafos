package utilitario;

public class TrataLinha {
	
	
	public static void main(String[] args) {
		String caracteres[];
		TrataLinha trataLinha = new TrataLinha();
		
		caracteres = trataLinha.trataLinha("3, 1, 2,,,,, 4");
		
		for(int i=0; i<caracteres.length; i++)
			System.out.println(caracteres[i]);
		
	}
	
	public String[] trataLinha(String linha) {
		String[] caracteres;
		
		//retira os caracteres do arquivo deixando somente os números 
		if (linha.contains(";"))
			linha = linha.replaceAll(";", "");

		
		linha = linha.replaceAll(",", "");
		caracteres = linha.split(" ");
	
		
		return caracteres;

	}
	
}
