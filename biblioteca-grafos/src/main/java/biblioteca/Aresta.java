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

	@Override
	public boolean equals(Object obj) {
		
		Aresta outra = (Aresta) obj;
		
		if(this.origem.equals(outra.origem) && this.destino.equals(outra.destino)){
			return true;
		}else{
			return false;
		}

			
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
