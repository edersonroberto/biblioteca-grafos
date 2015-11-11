package utilitario;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArquivoDeSaida {
	
	String destino;
	
	public ArquivoDeSaida(String destino){
		this.destino = destino;
		String dataAtual = pegaDataAtual();
		this.destino +=" " +dataAtual + ".txt";
	}
	
	public boolean gravaArquivoDeSaida(String resultado){
		
		
		FileOutputStream os;
		OutputStreamWriter sw;
		BufferedWriter bw;
		
		try{
			os = new FileOutputStream(destino, true);
			sw = new OutputStreamWriter(os);
			bw = new BufferedWriter(sw);
			
			bw.append(resultado);
			//bw.write(resultado);
			//bw.flush();
			//bw.newLine();
			bw.close();
			
		}catch(IOException e){
			System.out.println(e.getMessage());
			return false;
		}	
		
		
		return true;
	}

	private String pegaDataAtual() {
		Date d = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		return formato.format(d);
	}
}
