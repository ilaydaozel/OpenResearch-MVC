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


public class JSONFileIO implements IFileWriter, IFileReader{
	
	public void updateFile(String path, Object readingListObject) {
		
	        if (!(readingListObject instanceof ReadingList)) {
	            throw new IllegalArgumentException("Invalid object type. Expected ReadingList.");
	        }
	        
	        ReadingList readingList = (ReadingList) readingListObject;
	        
	        JSONArray jsonArray = null;
	        JSONArray updatedArray = new JSONArray();
	        
	        try (FileReader fileReader = new FileReader(path)) {
	            JSONTokener tokener = new JSONTokener(fileReader);
	            jsonArray = new JSONArray(tokener);
	            
	            boolean found = false;
	            
	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                String readingListName = jsonObject.getString("readinglist_name");
	                
	                if (readingListName.equals(readingList.getReadingListName())) {
	                    // Object with the same readinglist_name already exists, update it
	                    jsonObject.put("readinglist_id", readingList.getReadingListId());
	                    jsonObject.put("creator_researcher_name", readingList.getCreatorResearcher().getUsername());
	                    jsonObject.put("number_of_papers", readingList.getNumOfPapers());
	                    
	                    JSONArray jsonPapers = new JSONArray();
	                    if(readingList.getNameOfPapers()!=null) {
	                    	 for (String paperName : readingList.getNameOfPapers()) {
	 	                        jsonPapers.put(paperName);
	 	                    }
	                    }
	                   
	                    jsonObject.put("name_of_papers", jsonPapers);
	                    
	                    found = true;
	                }
	                
	                updatedArray.put(jsonObject);
	            }
	            
	            // Object with the readinglist_name does not exist, add it
	            if (!found) {
	                JSONObject jsonObject = new JSONObject();
	                jsonObject.put("readinglist_id", readingList.getReadingListId());
	                jsonObject.put("creator_researcher_name", readingList.getCreatorResearcher().getUsername());
	                jsonObject.put("readinglist_name", readingList.getReadingListName());
	                jsonObject.put("number_of_papers", readingList.getNumOfPapers());
	                
	                JSONArray jsonPapers = new JSONArray();
	                if(readingList.getNameOfPapers()!=null) {
	                	for (String paperName : readingList.getNameOfPapers()) {
		                    jsonPapers.put(paperName);
		                }
	                }
	                
	                jsonObject.put("name_of_papers", jsonPapers);
	                
	                updatedArray.put(jsonObject);
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading the JSON file: " + e.getMessage());
	        }
	        
	        try (FileWriter fileWriter = new FileWriter(path)) {
	            fileWriter.write(updatedArray.toString(4)); // Generate formatted JSON with indentation
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
	            JSONArray jsonArray = new JSONArray(tokener);

	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);

	                Map<String, String> element = new HashMap<>();
	                element.put("readinglist_id", String.valueOf(jsonObject.getInt("readinglist_id")));
	                element.put("creator_researcher_name", jsonObject.getString("creator_researcher_name"));
	                element.put("readinglist_name", jsonObject.getString("readinglist_name"));
	                element.put("number_of_papers", String.valueOf(jsonObject.getInt("number_of_papers")));

	                JSONArray jsonPapers = jsonObject.getJSONArray("name_of_papers");
	                List<String> papers = new ArrayList<>();
	                for (int j = 0; j < jsonPapers.length(); j++) {
	                    papers.add(jsonPapers.getString(j));
	                }
	                element.put("name_of_papers", papers.toString());

	                elements.add(element);
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading the JSON file: " + e.getMessage());
	        }

	        return elements;
	    }
   
}
