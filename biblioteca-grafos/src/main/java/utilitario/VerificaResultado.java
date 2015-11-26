package utilitario;

import java.util.List;

public class VerificaResultado {
	
	public boolean verificaNoResultadoDaDistancia(String resultado, int i, int j, List<String> vertices) {
		resultado = resultado.replace(":", "");
		String resultados []= TrataLinha.trataLinha(resultado);
		
		
		for(int k=1; k< resultados.length; k++){
			if(vertices.get(i).equals(resultados[k]) && (vertices.get(j).equals(resultados[k+1]))){
				return true;
			}
			if(vertices.get(j).equals(resultados[k]) && (vertices.get(i).equals(resultados[k+1]))){
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean verificaNoResultadoDijkstra(List<String> vertices, String resultado, int i, int j) {

		String resultados[] = resultado.split(" ");
		for (int ii = 0; ii < resultados.length - 2; ii++) {
			if (vertices.get(ii + 1).equals(resultados[ii])
					&& (vertices.get(j).equals(resultados[ii + 1]))) {
				return true;
			}

		}

		return false;
	}
	
	public boolean verificaNoResultadoPrimOuKruskal(String resultado,
			List<String> vertices, int i, int j) {
		String resultados[] = resultado.split("\n");
		for (int k = 1; k < resultados.length; k++) {
			String result[] = resultados[k].split(" ");

			if (result[0].equals(vertices.get(i))
					&& result[1].equals(vertices.get(j)))
				return true;
		}

		return false;
	}
	
	public boolean verificaNoResultadoBusca(String resultado,
			List<String> vertices, int i, int j) {
		String resultados[] = resultado.split("\n");

		for (int ii = 1; ii < resultados.length - 2; ii++) {
			if (resultados[ii].contains("foi visitado")) {
				if (resultados[ii].contains(vertices.get(i))) {
					if (resultados[ii + 2].contains(vertices.get(j)))
						return true;
				}

			}
		}

		return false;
	}

}
