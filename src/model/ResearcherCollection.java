package model;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ResearcherCollection  {
	private ArrayList<Researcher> researchersList;
	
	public ResearcherCollection() {
		researchersList = new ArrayList<Researcher>();
		readAndAddAllResearchersFromXML();
	}
	
	public ArrayList<Researcher> getResearchersList() {
		return researchersList;
	}

	public void setResearchersList(ArrayList<Researcher> researchersList) {
		this.researchersList = researchersList;
	}

	public void readAndAddAllResearchersFromXML() {
		try {
            File inputFile = new File("users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("researcher");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
            
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;

                  String username =  eElement.getElementsByTagName("researcher_name").item(0).getTextContent();
                  String password = eElement.getElementsByTagName("password").item(0).getTextContent();
                  String following_researcher_names =  eElement.getElementsByTagName("following_researcher_names").item(0).getTextContent();
                  String follower_researcher_names = eElement.getElementsByTagName("follower_researcher_names").item(0).getTextContent();
                  //liste olarak okumayı yap
                  //researcherList in constructorını güncelle
                  researchersList.add(new Researcher(username, password));
               }
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
	}
	
}
