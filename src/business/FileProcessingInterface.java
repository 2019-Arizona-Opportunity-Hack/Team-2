package business;

import java.util.List;

import javax.ejb.Local;
import javax.servlet.http.Part;

import model.DataField;


@Local
public interface FileProcessingInterface {
	public List<DataField> getList();

	public void generateArray(Part jsonData);

}