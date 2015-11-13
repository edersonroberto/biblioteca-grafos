package utilitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteArquivoDeSaida {
	
	ArquivoDeSaida arqSaida;
	
	@Before
	public void criaArquivoDeSaida(){
		arqSaida = new ArquivoDeSaida("teste");
	}
	
	@Test
	public void testaArquivoDeSaida(){
		String teste = "Teste de gravação de arquivos.";
		assertEquals(true, arqSaida.gravaArquivoDeSaida(teste));
	}
	
	@Test
	public void testaArquivoDeSaidaCaminhoNaoExiste(){
		String teste = "teste";
		arqSaida = new ArquivoDeSaida("G:TESTE/TESTE");
		
		arqSaida.gravaArquivoDeSaida(teste);
		
	}
}
