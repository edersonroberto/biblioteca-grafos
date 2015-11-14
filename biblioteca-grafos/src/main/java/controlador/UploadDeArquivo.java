package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class UploadDeArquivo {

	UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void fileUploadListener(FileUploadEvent e) {
		// Get uploaded file from the FileUploadEvent
		this.file = e.getFile();
		// Print out the information of the file
		System.out.println("Uploaded File Name Is :: " + file.getFileName()
				+ " :: Uploaded File Size :: " + file.getSize());
	}

}
