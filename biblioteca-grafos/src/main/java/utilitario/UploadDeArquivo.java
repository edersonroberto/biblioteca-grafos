package utilitario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import controlador.ControladorPrincipal;

@ManagedBean(name = "UploadDeArquivo")
@SessionScoped
public class UploadDeArquivo {

	private UploadedFile arquivo;
	private String diretorioSalvo;
	private String diretorioAserSalvo;
	
	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

	public void fazerUpload() {
		boolean foiCopiado = false;
		diretorioSalvo = "C:/saida/arquivo.txt";
		diretorioAserSalvo ="C:/git/biblioteca-grafos/biblioteca-grafos/src/main/webapp/resources/";
		
		System.out.println("Arquivo recebido :: " + arquivo.getFileName()
				+ " :: " + "Tamanho do arquivo :: " + arquivo.getSize());

		try {
			foiCopiado = copiarArquivo(arquivo.getInputstream());
			ControladorPrincipal controlador = new ControladorPrincipal();
			controlador.controlaFluxo(diretorioSalvo, diretorioAserSalvo);
		} catch (IOException e) {

			e.printStackTrace();
		}
			
		if (foiCopiado){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("saidaGrafoPrincipal.html");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public boolean copiarArquivo(InputStream in) {
		try {

			OutputStream out = new FileOutputStream(new File(diretorioSalvo));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("Novo arquivo criado com sucesso!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
