package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import interfaces.IFileWriter;
import model.ReadingList;
import model.Researcher;

public class JSONFileIO implements IFileWriter{
	
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
            fileWriter.write(jsonReadingList.toString());
            System.out.println("JSON file has been written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the JSON file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Create a sample ReadingList object
        Researcher newResearcher = new Researcher();
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
    }


	@Override
	public void writeAllPapers(List<Object> list) {
		// TODO Auto-generated method stub
		
	}
}
