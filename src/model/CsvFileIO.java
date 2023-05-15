package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import interfaces.IFileReader;
import interfaces.IFileWriter;

public class CsvFileIO implements IFileReader,IFileWriter{

	@Override
	public void write() {
	
		
	}
	@Override
	public void writeAllPapers(List<Map<String, String>> allPapers) {
		try {
			FileWriter writer = new FileWriter("OpenResearch-MVC/src/data/papers.csv");
		for (Map<String, String> data : allPapers) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
               
                String value = entry.getValue();
                // Create a new FileWriter object to write to the CSV file
                
                writer.append(value)
                .append(";");
                System.out.println("Value: " + value);
            }
            writer.append("\n");
        }
        // Flush and close the FileWriter object
        writer.flush();
        writer.close();
        // Print a message indicating that the file was created successfully
        System.out.println("papers.csv file generated successfully.");
		}catch (IOException e) {
            e.printStackTrace();
        }	
	}

	@Override
	public Map<String, String> readFile(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> readAllFilesInSameDirectory(String directoryPath) {
		return null;
		// TODO Auto-generated method stub
		
	}


	
	
	

}
