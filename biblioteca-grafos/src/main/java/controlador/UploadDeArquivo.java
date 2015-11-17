package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

@ManagedBean(name = "UploadDeArquivo")
@SessionScoped
public class UploadDeArquivo {

	private UploadedFile arquivo;
	private String arquivoCarregado;
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
		
		controleSaida = new ControladorSaida();
		System.out.println("Arquivo recebido :: " + arquivo.getFileName()
				+ " :: " + "Tamanho do arquivo :: " + arquivo.getSize());

		String nomeArquivo = arquivo.getFileName();

		if (nomeArquivo.contains("\\"))
			arquivoCarregado = "C:\\saida"+ nomeArquivo.substring(nomeArquivo.lastIndexOf('\\'));
		else
			arquivoCarregado = "C:\\saida\\" + nomeArquivo;

		try {
			copiaArquivo(nomeArquivo, arquivo.getInputstream());
		} catch (IOException e) {

			e.printStackTrace();
		}
		ControladorPrincipal controlador = new ControladorPrincipal();

		boolean subiu = controlador.controlaFluxo(arquivoCarregado, controleSaida);
		
		controleSaida.colocaNaSessao();
		
		if (subiu){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("grafo.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void copiaArquivo(String fileName, InputStream in) {
		try {

			OutputStream out = new FileOutputStream(new File(arquivoCarregado));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
