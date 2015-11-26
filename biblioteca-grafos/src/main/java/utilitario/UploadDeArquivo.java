package utilitario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import controlador.ControladorPrincipal;

@ManagedBean(name="UploadDeArquivo")
@SessionScoped
public class UploadDeArquivo {
	
	private String diretorioDoArquivoCarregado;
	private String diretorioDoGrafoASerCriado;

	private UploadedFile arquivo;


	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

	public void fazerUpload(FileUploadEvent event) {
		
		diretorioDoArquivoCarregado = "C:/saida/arquivo.txt";
		diretorioDoGrafoASerCriado ="C:/git/biblioteca-grafos/biblioteca-grafos/src/main/webapp/resources/";
		arquivo = event.getFile();
		if (arquivo != null) {
			try {
				salvarArquivo(arquivo.getInputstream());
				FacesMessage message = new FacesMessage("Arquivo ",
						event.getFile().getFileName() + " salvo com sucesso.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				System.out.println("Arquivo criado com sucesso!");
				ControladorPrincipal controlador = new ControladorPrincipal();
				controlador.controlaFluxo(diretorioDoArquivoCarregado, diretorioDoGrafoASerCriado);
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("saidaGrafoPrincipal.html");
				
			} catch (IOException e) {
				System.out.println(e.getMessage() + "Falha ao subir arquivo");
			}
		}
	}

	public void salvarArquivo(InputStream in) throws IOException {

		OutputStream out = new FileOutputStream(
				new File(diretorioDoArquivoCarregado));

		int read = 0;
		byte[] bytes = new byte[1024];

		while ((read = in.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}

		in.close();
		out.flush();
		out.close();

	}
}