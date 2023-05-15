package interfaces;

import java.util.Map;

public interface IFileReader {

	public Map<String, String> readFile(String filePath) ;
	public void readAllFilesInSameDirectory(String directoryPath);

}
