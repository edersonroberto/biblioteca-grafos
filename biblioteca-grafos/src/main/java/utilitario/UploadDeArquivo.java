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

import controlador.ControladorSaida;

@ManagedBean(name = "UploadDeArquivo")
@SessionScoped
public class UploadDeArquivo {

	private UploadedFile arquivo;
	private ControladorSaida controleSaida;

	public ControladorSaida getControleSaida() {
		return controleSaida;
	}

	public void setControleSaida(ControladorSaida controleSaida) {
		this.controleSaida = controleSaida;
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

	public void fazerUpload() {
		boolean foiCopiado = false;
		controleSaida = new ControladorSaida();
		System.out.println("Arquivo recebido :: " + arquivo.getFileName()
				+ " :: " + "Tamanho do arquivo :: " + arquivo.getSize());

		try {
			foiCopiado = copiarArquivo(arquivo.getInputstream());
		} catch (IOException e) {

			e.printStackTrace();
		}
			
		if (foiCopiado){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("teste.html");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public boolean copiarArquivo(InputStream in) {
		try {

			OutputStream out = new FileOutputStream(new File("c:\\saida\\arquivo.txt"));

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
