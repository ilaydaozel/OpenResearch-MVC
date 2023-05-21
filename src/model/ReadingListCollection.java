package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fileIO.JSONFileIO;


public class ReadingListCollection extends Collection{
	public ResearcherCollection researcherCollection;
	
	public ReadingListCollection(ResearcherCollection researcherCollection) {
		this.researcherCollection = researcherCollection;
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
		
		
		Researcher researcher = this.researcherCollection.getResearcherByResearcherName(data.get("creator_researcher_name"));
		

        
		ReadingList readingList = new ReadingList(
											Integer.parseInt(data.get("readinglist_id")),
											Integer.parseInt(data.get("number_of_papers")),
											new ArrayList<>(Arrays.asList(data.get("name_of_papers").split(", "))),
											data.get("readinglist_name"),
											researcher);

        researcher.addNewReadingList(readingList);

		return readingList;		
		
	}

}
