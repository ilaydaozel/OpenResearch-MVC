package model;

import java.util.*;

import fileIO.XmlFileIO;

public class ResearcherCollection extends Collection  {	
	
	public ResearcherCollection() {
		setReader(new XmlFileIO());
		setWriter(new XmlFileIO());
		createCollection();
	}
	
	@Override
	public void createCollection() {
		List<Map<String, String>> allResearchers;

		allResearchers = getReader().readAllElements("src/users.xml");

    	for (Map<String, String> data : allResearchers) {
    		addToCollection(createCollectionElement(data));
        }  
		
	}

	@Override
	public Researcher createCollectionElement(Map<String, String> data) {
		Researcher researcher = new Researcher(data.get("username"),
											data.get("password"),
											new ArrayList<>(Arrays.asList(data.get("following_researchers").split(", "))),
											new ArrayList<>(Arrays.asList(data.get("follower_researchers").split(", "))));

		return researcher;		
	}
	public Researcher getResearcherByResearcherName(String name) {
		
		for (Object researcher : this.getCollection()) {
			Researcher res = (Researcher) researcher;
			if(res.getUsername().equals(name)) {
	
				return res;
			}
		}
		return null;
	}

}
