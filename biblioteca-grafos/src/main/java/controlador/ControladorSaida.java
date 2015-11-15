package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sun.faces.context.flash.ELFlash;

@ManagedBean(name="ControladorSaida")
@SessionScoped
public class ControladorSaida {
	
	private String distancia;
	private String buscaPorProfundidade;
	private String buscaPorLargura;
	private String menorCaminho;
	private String prim;
	private String kruskal;
	

	
	public String getBuscaPorProfundidade() {
		return buscaPorProfundidade;
	}
	public void setBuscaPorProfundidade(String buscaPorProfundidade) {
		this.buscaPorProfundidade = buscaPorProfundidade;
	}

	public String getDistancia() {
		return distancia;
	}

	public String getBuscaPorLargura() {
		return buscaPorLargura;
	}
	public String getMenorCaminho() {
		return menorCaminho;
	}
	public String getPrim() {
		return prim;
	}
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	public void setBuscaPorLargura(String buscaPorLargura) {
		this.buscaPorLargura = buscaPorLargura;
	}
	public void setMenorCaminho(String menorCaminho) {
		this.menorCaminho = menorCaminho;
	}
	public void setPrim(String prim) {
		this.prim = prim;
	}
	public void setKruskal(String kruskal) {
		this.kruskal = kruskal;
	}
	public String getKruskal() {
		return kruskal;
	}
	public void colocaNaSessao() {
		ELFlash.getFlash().put("saida", this);
	}
	
}
