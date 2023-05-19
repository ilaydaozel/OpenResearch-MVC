package model;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import interfaces.IFileReader;

public class XmlFileIO implements IFileReader{


	@Override
	public List<Map<String, String>> readAllElements(String path) {
		
		
        List<Map<String, String>> dataList = new ArrayList<>();
		try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("researcher");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               Map<String, String> researcherData = new LinkedHashMap<>(); // Use LinkedHashMap to maintain the order
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;

                  String username =  eElement.getElementsByTagName("researcher_name").item(0).getTextContent();
                  String password = eElement.getElementsByTagName("password").item(0).getTextContent();
                  //String following_researcher_names =  eElement.getElementsByTagName("following_researcher_names").item(0).getTextContent();
                  //String follower_researcher_names = eElement.getElementsByTagName("follower_researcher_names").item(0).getTextContent();
                  //liste olarak okumayı yap
                  //researcherList in constructorını güncelle
                  researcherData.put("username", username);
                  researcherData.put("password", password);
                  
               }
               dataList.add(researcherData);
            }
           
         } catch (Exception e) {
            e.printStackTrace();
         }
		return dataList;
	}
	

	
	@Override
	public Map<String, String> readFile(String filePath) {
		return null;
	}
	


}
