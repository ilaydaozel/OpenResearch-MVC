package interfaces;

import java.util.List;
import java.util.Map;

import model.Paper;

public interface IFileWriter {
	public void updateFile(String path, Object object);
	public void writeAllPapers(List<Object> list); 
}
