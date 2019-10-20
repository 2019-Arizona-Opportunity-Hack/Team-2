package controller;

import business.JsonProcessingService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;


@ManagedBean
@ViewScoped
public class FileController {
	
	@EJB
	JsonProcessingService service;
	private Part file;

	
	public Part getFile() {
		return file;
	}


	public void setFile(Part file) {
		this.file = file;
	}


	public String onSubmit(){
		
		if(this.file != null) {
		service.generateArray(this.file);
		}else {
			System.out.println("there was no file to use.");
		}
		
		return "DisplayInformation.xhtml";
	}
	
	
	public JsonProcessingService getDataList() {
		return service;
	}
}
