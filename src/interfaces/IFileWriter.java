package interfaces;

import java.util.List;
import java.util.Map;

import model.Paper;

public interface IFileWriter {
	public void write();
	public void writeAllPapers(List<Map<String, String>> allPapers); 
}
