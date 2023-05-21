package fileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.BufferedWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import interfaces.IFileReader;
import interfaces.IFileWriter;
import model.ReadingList;
import model.Researcher;
import model.ResearcherCollection;

public class XmlFileIO implements IFileReader,IFileWriter {

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
	@Override
	public void updateFile(String path, Object newResearcherObject) {
	    try {
		    if (!(newResearcherObject instanceof Researcher)) {
		        throw new IllegalArgumentException("Invalid object type. Expected ReadingList.");
		    }
		    
		    Researcher newResearcher = (Researcher) newResearcherObject;
	    	
	        File inputFile = new File(path);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        
	        removeExistingResearcher(doc, (newResearcher).getUsername());
	        
	        
	        Element researcherElement = createResearcherElement(doc, newResearcher);
	        Element followingResearchersElement = createFollowingResearchersElement(doc, newResearcher);
	        Element followerResearchersElement = createFollowerResearchersElement(doc, newResearcher);

	        researcherElement.appendChild(followingResearchersElement);
	        researcherElement.appendChild(followerResearchersElement);
	        
	        Element researchersElement = doc.getDocumentElement();
	        researchersElement.appendChild(researcherElement);

	        saveDocumentToFile(doc, inputFile);

	        System.out.println("XML file updated successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private Element createResearcherElement(Document doc, Researcher newResearcher) {
	    Element researcherElement = doc.createElement("researcher");

	    Element usernameElement = doc.createElement("researcher_name");
	    usernameElement.appendChild(doc.createTextNode(newResearcher.getUsername()));
	    researcherElement.appendChild(usernameElement);

	    Element passwordElement = doc.createElement("password");
	    passwordElement.appendChild(doc.createTextNode(newResearcher.getPassword()));
	    researcherElement.appendChild(passwordElement);

	    return researcherElement;
	}

	private Element createFollowingResearchersElement(Document doc, Researcher newResearcher) {
	    Element followingResearchersElement = doc.createElement("following_researcher_names");
	    for (Object followingResearcher : newResearcher.getFollowingResearchers()) {
	        Element followingResearcherNameElement = doc.createElement("following_researcher_name");
	        followingResearcherNameElement.appendChild(doc.createTextNode(followingResearcher.toString()));
	        followingResearchersElement.appendChild(followingResearcherNameElement);
	    }
	    return followingResearchersElement;
	}

	private Element createFollowerResearchersElement(Document doc, Researcher newResearcher) {
	    Element followerResearchersElement = doc.createElement("follower_researcher_names");
	    for (Object followerResearcher : newResearcher.getFollowerResearchers()) {
	        Element followerResearcherNameElement = doc.createElement("follower_researcher_name");
	        followerResearcherNameElement.appendChild(doc.createTextNode(followerResearcher.toString()));
	        followerResearchersElement.appendChild(followerResearcherNameElement);
	    }
	    return followerResearchersElement;
	}

	private void saveDocumentToFile(Document doc, File inputFile) throws Exception {
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Set indent property to "yes"
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); // Set indent amount to 2 or your desired value
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); // Omit XML declaration
	    transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "0"); // Disable indentation for existing content

	    // Serialize the document to a string
	    StringWriter writer = new StringWriter();
	    StreamResult result = new StreamResult(writer);
	    transformer.transform(new DOMSource(doc), result);
	    String xmlString = writer.toString();

	    // Remove indentation for existing content
	    xmlString = xmlString.replaceAll("\n\\s+", "\n");

	    // Write the modified XML string to the file
	    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inputFile))) {
	        bufferedWriter.write(xmlString);
	    }
	}


	
	private void removeExistingResearcher(Document doc, String username) {
        NodeList researcherNodes = doc.getElementsByTagName("researcher");

        for (int i = 0; i < researcherNodes.getLength(); i++) {
            Node researcherNode = researcherNodes.item(i);
            if (researcherNode.getNodeType() == Node.ELEMENT_NODE) {
                Element researcherElement = (Element) researcherNode;
                String existingUsername = researcherElement.getElementsByTagName("researcher_name").item(0).getTextContent();
                System.out.println("exist "+ existingUsername +" given: "+ username);
                if (existingUsername.equals(username)) {
                	System.out.println("girdim");
                    researcherNode.getParentNode().removeChild(researcherNode);
                    break;
                }
            }
        }
    }
	 public static void main(String[] args) {
	        // Path to the XML file
	        String xmlFilePath = "OpenResearch-MVC/src/users.xml";

	        // Create a new researcher
	        Researcher newResearcher = new Researcher();
	        newResearcher.setUsername("Berke Tınas");
	        newResearcher.setPassword("123");
	        newResearcher.setFollowingResearchers(Arrays.asList(""));
	        newResearcher.setFollowerResearchers(Arrays.asList("Göktay İncekara","抑菌"));

	        // Update the XML file with the new researcher
	        XmlFileIO xmlFileIO = new XmlFileIO();
	        xmlFileIO.updateFile(xmlFilePath, newResearcher);
	        ResearcherCollection rc = new ResearcherCollection();
	        rc.createCollection();
	    }

	@Override
	public void writeAllPapers(List<Object> list) {
		// TODO Auto-generated method stub
		
	}
	 
	
	}