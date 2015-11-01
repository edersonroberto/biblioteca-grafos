package biblioteca;

public class Vertice {
	
	private String nome;

	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		Vertice v = (Vertice) obj;
		if (nome != v.nome) 
			return false;
		
		return true;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
