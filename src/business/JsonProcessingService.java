package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.Part;

import model.DataField;

import java.lang.String;

@Stateless
@Local(FileProcessingInterface.class)
@LocalBean
public class JsonProcessingService implements FileProcessingInterface {
	private List<DataField> list;


	public JsonProcessingService() {
		list = new ArrayList<DataField>();
	}
	@Override
	public void generateArray(Part jsonData) {
		
		String[] words;
		try {
			
			
			Scanner scan = new Scanner(jsonData.getInputStream());
			String fileContent = null;
			while(scan.hasNext()) {
				fileContent += scan.nextLine();
			}
			scan.close();
			 fileContent = fileContent.replaceAll("[{|}|\\[|\\]]", "");
			 fileContent = fileContent.replaceAll("null", "");
			 fileContent = fileContent.replaceAll(",\n", ":\n");
			 fileContent = fileContent.replaceAll("\"", "");
			 words = fileContent.split(":");
			 
			 for(int i=0; i<words.length; i+=2) {
				 list.add(new DataField(words[i], words[i+1]));

			 }
		}catch(Exception e) {
			e.printStackTrace();
		}	
	
		
	}


	@Override
	public List<DataField> getList() {
		// TODO Auto-generated method stub
		return list;
	}
	
}