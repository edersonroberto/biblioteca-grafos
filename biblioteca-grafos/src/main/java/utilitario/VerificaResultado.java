package utilitario;


public class VerificaResultado {
	
	public static String verificaNoResultadoDaDistancia(String resultado, String saidaGrafo) {
		String saidaComando = saidaGrafo;
		
		String resultados[] = resultado.split("\n");
		resultados = TrataLinha.trataLinha(resultados[0]);
	

		for (int i = 1; i < resultados.length; i++) {
			
			saidaComando = trocaCorVertice(resultados[i], saidaComando);
		}
		for(int i=1; i < resultados.length -1; i++){
			saidaComando = trocaCorAresta(resultados[i], resultados[i + 1],
					saidaComando);
			
		}
		
		return saidaComando;
	}
	
	private static String trocaCorAresta(String vertice1, String vertice2,
			String saidaResultado) {

		String saidasGrafo[] = saidaResultado.split("\n");
		String saida = "";

		for (int i = 0; i < saidasGrafo.length; i++) {

			if (saidasGrafo[i].contains("addEdge")) {
				if (saidasGrafo[i].contains("a"+vertice1)
						&& saidasGrafo[i].contains("a"+vertice2))
					saidasGrafo[i] = saidasGrafo[i].replace("green", "red");
			}
			saida += saidasGrafo[i] + "\n";
		}

		return saida;

	}

	private static String trocaCorVertice(String vertice, String saidaGrafo) {
		String saidasGrafo[] = saidaGrafo.split("\n");
		String saida = "";

		for (int i = 0; i < saidasGrafo.length; i++) {

			if (saidasGrafo[i].contains("addNode")) {
				if (saidasGrafo[i].contains("a"+vertice))
					saidasGrafo[i] = saidasGrafo[i].replace("green", "red");
			}
			saida += saidasGrafo[i] + "\n";
		}

		return saida;

	}
	
	public static String verificaNoResultadoDijkstra(String resultado, String saidaGrafo) {

		String resultados[] = resultado.split("\n");
		String subResultados[] =resultados[1].split(" ");
		
		for (int i=0; i < subResultados.length-1; i++){
			saidaGrafo = atualizaCorArestaDijkstra(subResultados[i], subResultados[i+1], saidaGrafo);
		}
		

		return saidaGrafo;
	}
	
	private static String atualizaCorArestaDijkstra(String vertice1,
			String vertice2, String saida) {
		
		String resultados[] = saida.split("\n");
		String resultado = "";
		
		for(int i=0; i < resultados.length; i++){
			if(resultados[i].contains("a"+vertice1) && resultados[i].contains("a"+vertice2))
				resultados[i] = resultados[i].replace("green", "red");
			
			resultado += resultados[i] +"\n";
		}
		
		return resultado;
	}

	public static String verificaNoResultadoPrimKruskal(String resultado, String saidaGrafo) {
		String resultados[] = resultado.split("\n");
		String resultadoPrimKruskal = saidaGrafo;
		
		for (int i = 1; i < resultados.length-1; i++) {
			
			resultadoPrimKruskal = atualizaCorArestaPrimKruskal(resultados[i], resultadoPrimKruskal);
			
		}

		return resultadoPrimKruskal;
	}
	
	private static String atualizaCorArestaPrimKruskal(String resultado,
			String resultadoPrimKruskal) {
		String subResultados[] = resultado.split(" ");
		String vertice1 = subResultados[0];
		String vertice2 = subResultados[1];
		String saida = "";
		
		String resultadosPK[] = resultadoPrimKruskal.split("\n");
		
		for(int i=0; i < resultadosPK.length; i++){
			if(resultadosPK[i].contains("a"+vertice1) && resultadosPK[i].contains("a"+vertice2))
				resultadosPK[i] = resultadosPK[i].replace("green", "red");
			
			saida += resultadosPK[i] + "\n";
		}
		
		return saida;
	}

	public static String verificaNoResultadoBusca(String resultado,
			String saidaGrafo) {
		String resultados[] = resultado.split("\n");
		String resultadoBusca = saidaGrafo;
		for(int i=1; i < resultados.length; i++){
			if(resultados[i].contains("foi visitado")){
				String subResultados[] = resultados[i].split(" ");
				String vertice1 = subResultados[0];
				for(int j=i+1; j < resultados.length; j++){
					if(resultados[j].contains("foi visitado")){
						String subResultados2[] = resultados[j].split(" ");
						String vertice2 = subResultados2[0];
						resultadoBusca = atualizaCorArestaBusca(vertice1, vertice2, resultadoBusca);
						break;
					}
				}
			}
		}
		

		return resultadoBusca;
		
	}
	
	private static String atualizaCorArestaBusca(String vertice1, String vertice2, String saida) {
		
		String saidas[]= saida.split("\n");
		String resultado ="";
		
		for(int i=0; i< saidas.length; i++){
			if(saidas[i].contains("addEdge"))
				if(saidas[i].contains("a"+vertice1) && saidas[i].contains("a"+vertice2)){
					saidas[i] = saidas[i].replace("green", "red");
				}
			resultado+=saidas[i] + "\n";
		}
		
		return resultado;
		
	}
	
	

}
