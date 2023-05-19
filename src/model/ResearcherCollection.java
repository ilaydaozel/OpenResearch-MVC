package model;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fileIO.XmlFileIO;

public class ResearcherCollection extends Collection  {	
	
	public ResearcherCollection() {
		setReader(new XmlFileIO());
		createCollection();
	}
	
	@Override
	public void createCollection() {
		List<Map<String, String>> allResearchers;

		allResearchers = getReader().readAllElements("users.xml");

    	for (Map<String, String> data : allResearchers) {
    		System.out.println("inside "+ data);
    		addToCollection(createCollectionElement(data));
    		
    		
        }  
		
	}

	@Override
	public Researcher createCollectionElement(Map<String, String> data) {
		Researcher researcher = new Researcher(data.get("username"), data.get("password"));
		
		return researcher;		
	}

}
