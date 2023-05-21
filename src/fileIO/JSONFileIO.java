package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import interfaces.IFileReader;
import interfaces.IFileWriter;
import model.ReadingList;
import model.Researcher;
import model.ReadingListCollection;

public class JSONFileIO implements IFileWriter, IFileReader{
	
	@Override
    public void updateFile(String path, Object readingListObject) {
		
		if (!(readingListObject instanceof ReadingList)) {
            throw new IllegalArgumentException("Invalid object type. Expected ReadingList.");
        }
        
        ReadingList readingList = (ReadingList) readingListObject;
        
        JSONObject jsonReadingList = new JSONObject();
        jsonReadingList.put("readinglist_id", readingList.getReadingListId());
        jsonReadingList.put("creator_researcher_name", readingList.getCreatorResearcher().getUsername());
        jsonReadingList.put("readinglist_name", readingList.getReadingListName());
        jsonReadingList.put("number_of_papers", readingList.getNumOfPapers());
        
        JSONArray jsonPapers = new JSONArray();
        for (String paperName : readingList.getNameOfPapers()) {
            jsonPapers.put(paperName);
        }
        jsonReadingList.put("name_of_papers", jsonPapers);
        
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(jsonReadingList.toString(4)); // Generate formatted JSON with indentation
            System.out.println("JSON file has been written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the JSON file: " + e.getMessage());
        }
    }
    
	@Override
	public void writeAllPapers(List<Object> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> readFile(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> readAllElements(String path) {
		
		 List<Map<String, String>> elements = new ArrayList<>();

	        try (FileReader fileReader = new FileReader(path)) {
	            JSONTokener tokener = new JSONTokener(fileReader);
	            JSONObject jsonObject = new JSONObject(tokener);

	            Map<String, String> element = new HashMap<>();
	            element.put("readinglist_id", String.valueOf(jsonObject.getInt("readinglist_id")));
	            element.put("creator_researcher_name", jsonObject.getString("creator_researcher_name"));
	            element.put("readinglist_name", jsonObject.getString("readinglist_name"));
	            element.put("number_of_papers", String.valueOf(jsonObject.getInt("number_of_papers")));

	            JSONArray jsonPapers = jsonObject.getJSONArray("name_of_papers");
	            List<String> papers = new ArrayList<>();
	            for (int i = 0; i < jsonPapers.length(); i++) {
	                papers.add(jsonPapers.getString(i));
	            }
	            element.put("name_of_papers", papers.toString());

	            elements.add(element);
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading the JSON file: " + e.getMessage());
	        }

	        return elements;}
    public static void main(String[] args) {
    	
        // Create a sample ReadingList object
        /*Researcher newResearcher = new Researcher();
        newResearcher.setUsername("Berke Tınas");
        newResearcher.setPassword("123");
        newResearcher.setFollowingResearchers(Arrays.asList(""));
        newResearcher.setFollowerResearchers(Arrays.asList("Göktay İncekara","抑菌"));
        
        ReadingList readingList = new ReadingList("test",newResearcher);
        readingList.setReadingListId(1);
        readingList.setReadingListName("My Reading List");
        readingList.setNumOfPapers(3);
        readingList.setNameOfPapers(new String[]{"test 1", "Paper 2", "Paper 3"});
        
        
        // Specify the file path to write the JSON file
        String filePath = "readingList.json";
        
        JSONFileIO jsonFileIO = new JSONFileIO();
		// Write the ReadingList object to a JSON file
        jsonFileIO.updateFile(filePath,readingList);
    	// Specify the file path to read the JSON file
    	// Specify the file path to read the JSON file
        
        
        // Create an instance of JSONFileIO
    	String filePath = "readingList.json";
    	JSONFileIO jsonFileIO = new JSONFileIO();
        // Test the readAllElements method
        List<Map<String, String>> elements = jsonFileIO.readAllElements(filePath);
        
        // Display the results
        for (Map<String, String> element : elements) {
            System.out.println("Reading List ID: " + element.get("readinglist_id"));
            System.out.println("Creator Researcher Name: " + element.get("creator_researcher_name"));
            System.out.println("Reading List Name: " + element.get("readinglist_name"));
            System.out.println("Number of Papers: " + element.get("number_of_papers"));
            
            // Access the name_of_papers array
            String[] papers = element.get("name_of_papers").split(",");
            System.out.println("Name of Papers:");
            for (String paper : papers) {
                System.out.println("- " + paper);
            }
            
            System.out.println();
        }*/
    	ReadingListCollection rc= new ReadingListCollection();
    	rc.createCollection();
    }
}
