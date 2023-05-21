package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fileIO.JSONFileIO;


public class ReadingListCollection extends Collection{
	
	public ReadingListCollection() {
		setReader(new JSONFileIO());
		setWriter(new JSONFileIO());
		createCollection();
	}
	@Override
	public void createCollection() {
		List<Map<String, String>> allReadingLists;
		allReadingLists = getReader().readAllElements("readingList.json");

    	for (Map<String, String> data : allReadingLists) {
    		addToCollection(createCollectionElement(data));
        }  
		
	}

	@Override
	public Object createCollectionElement(Map<String, String> data) {
		
		ResearcherCollection researcherCollection = new ResearcherCollection();
		Researcher researcher =researcherCollection.getResearcherByResearcherName(data.get("creator_researcher_name"));
		
		ReadingList readingList = new ReadingList(
											Integer.parseInt(data.get("readinglist_id")),
											Integer.parseInt(data.get("number_of_papers")),
											data.get("name_of_papers").split(","),
											data.get("creator_researcher_name"),
											researcher);
				
		System.out.println("readinglist_id: "+ data.get("readinglist_id"));
		System.out.println("number_of_papers: "+ data.get("number_of_papers"));
		System.out.println("name_of_papers: "+ data.get("name_of_papers"));
		System.out.println("test follwing "+ readingList.getCreatorResearcher().getUsername());
		return readingList;		
		
	}

}
