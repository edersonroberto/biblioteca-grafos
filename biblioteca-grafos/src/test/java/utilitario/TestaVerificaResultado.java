package utilitario;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestaVerificaResultado {

	private String saidaGrafo;

	@Before
	public void criaTeste() {
		String viewport = "\"#viewport\"";

		saidaGrafo = "var sys = arbor.ParticleSystem(1000, 400,1);\n"
				+ "sys.parameters({gravity:true});\n"
				+ "sys.renderer = Renderer(" + viewport + ");\n"
				+ "var a0= sys.addNode('a0', {'color':'green','label':'0'});\n"
				+ "var a1= sys.addNode('a1', {'color':'green','label':'1'});\n"
				+ "var a2= sys.addNode('a2', {'color':'green','label':'2'});\n"
				+ "var a3= sys.addNode('a3', {'color':'green','label':'3'});\n"
				+ "var a4= sys.addNode('a4', {'color':'green','label':'4'});\n"
				+ "sys.addEdge('a0', 'a1',{'color':'green', 'weight':1});\n"
				+ "sys.addEdge('a0', 'a2',{'color':'green', 'weight':2});\n"
				+ "sys.addEdge('a1', 'a2',{'color':'green', 'weight':1});\n"
				+ "sys.addEdge('a1', 'a3',{'color':'green', 'weight':1});\n"
				+ "sys.addEdge('a2', 'a0',{'color':'green', 'weight':2});\n"
				+ "sys.addEdge('a2', 'a3',{'color':'green', 'weight':1});\n"
				+ "sys.addEdge('a2', 'a4',{'color':'green', 'weight':2});\n"
				+ "sys.addEdge('a3', 'a0',{'color':'green', 'weight':1});\n"
				+ "sys.addEdge('a3', 'a4',{'color':'green', 'weight':1});\n";
	}

	@Ignore
	@Test
	public void testeVerificaResultadoDistancia() {

		String resultado = "Distancia 0 1 2:\n21";

		String resultadoDist = VerificaResultado
				.verificaNoResultadoDaDistancia(resultado, saidaGrafo);

		System.out.println(resultadoDist);
	}

	@Ignore
	@Test
	public void testeVerificaResultadoBusca() {

		String resultado = "Largura 0 3:\n" + "0 foi visitado.\n"
				+ "1 2 são vizinhos de 0.\n" + "1 foi visitado.\n"
				+ "2 3 são vizinhos de 1.\n" + "2 foi visitado.\n"
				+ "0 3 são vizinhos de 2.\n" + "3 foi visitado.\n"
				+ "Destino 3 foi encontrado.";
		String resultadoBusca = VerificaResultado.verificaNoResultadoBusca(
				resultado, saidaGrafo);
		System.out.println(resultadoBusca);

	}

	@Ignore
	@Test
	public void testeVerificaResultadoPrimKruskal() {
		String resultado = "Prim 2:\n" + "2 3 12,\n" + "3 0 14,\n"
				+ "0 1 10,\n" + "36";
		String resultadoPrimKruskal = VerificaResultado
				.verificaNoResultadoPrimKruskal(resultado, saidaGrafo);
		System.out.println(resultadoPrimKruskal);
	}

	@Test
	public void testeVerificaResultadoDijkstra() {
		String resultado = "Menor Caminho 0 3:\n" + "0 1 3\n" + "23\n";
		String resultadoDijkstra = VerificaResultado.verificaNoResultadoDijkstra(
				resultado, saidaGrafo);
		System.out.println(resultadoDijkstra);
	}
}
