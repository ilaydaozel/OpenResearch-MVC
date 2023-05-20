package fileIO;

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

public class XmlFileIO implements IFileReader {

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

                    String username = eElement.getElementsByTagName("researcher_name").item(0).getTextContent();
                    String password = eElement.getElementsByTagName("password").item(0).getTextContent();

                    List<String> followingResearchers = parseFollowingResearchers(eElement);
                    List<String> followerResearchers = parseFollowerResearchers(eElement);

                    researcherData.put("username", username);
                    researcherData.put("password", password);
                    researcherData.put("following_researchers", String.join(", ", followingResearchers));
                    researcherData.put("follower_researchers", String.join(", ", followerResearchers));
                }
                dataList.add(researcherData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    private List<String> parseFollowingResearchers(Element element) {
        List<String> followingResearchers = new ArrayList<>();
        NodeList followingList = element.getElementsByTagName("following_researcher_names");
        if (followingList.getLength() > 0) {
            Element followingElement = (Element) followingList.item(0);
            NodeList followingNameList = followingElement.getElementsByTagName("following_researcher_name");
            for (int i = 0; i < followingNameList.getLength(); i++) {
                Node followingNode = followingNameList.item(i);
                if (followingNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element followingNameElement = (Element) followingNode;
                    followingResearchers.add(followingNameElement.getTextContent());
                }
            }
        }
        return followingResearchers;
    }

    private List<String> parseFollowerResearchers(Element element) {
        List<String> followerResearchers = new ArrayList<>();
        NodeList followerList = element.getElementsByTagName("follower_researcher_names");
        if (followerList.getLength() > 0) {
            Element followerElement = (Element) followerList.item(0);
            NodeList followerNameList = followerElement.getElementsByTagName("follower_researcher_name");
            for (int i = 0; i < followerNameList.getLength(); i++) {
                Node followerNode = followerNameList.item(i);
                if (followerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element followerNameElement = (Element) followerNode;
                    followerResearchers.add(followerNameElement.getTextContent());
                }
            }
        }
        return followerResearchers;
    }


	@Override
	public Map<String, String> readFile(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}
	}