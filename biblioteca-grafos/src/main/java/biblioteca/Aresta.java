package biblioteca;


public class Aresta implements Comparable<Aresta> {
	private String origem;
	private String destino;
	private int peso;

	public Aresta() {

	}

	public Aresta(String origem, String destino, int peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

	@Override
	public int compareTo(Aresta outraAresta) {

		if (this.peso < outraAresta.peso)
			return -1;
		if (this.peso > outraAresta.peso)
			return 1;

		return 0;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}
}
