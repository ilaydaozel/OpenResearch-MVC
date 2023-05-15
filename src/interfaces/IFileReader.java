package interfaces;

import java.util.List;
import java.util.Map;

public interface IFileReader {

	public Map<String, String> readFile(String filePath) ;
	public List<Map<String, String>> readAllFilesInSameDirectory(String directoryPath);

}
