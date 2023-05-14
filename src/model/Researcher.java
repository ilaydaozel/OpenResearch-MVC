package model;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Researcher extends java.util.Observable {
	private String name;
	private String password;
	private String[] followingResearcherNames;
	private String[] followerResearcherNames;
	private boolean loggedIn;
	//private List<Observer> observers = new ArrayList<>();
	
	public Researcher() {
		this.followerResearcherNames = new String[5];
		this.followingResearcherNames = new String[5];
	}
	public String getName() {
		System.out.println("get name / researcher");
		return name;
	}
	public void setName(String name) {
		System.out.println("set name / researcher");
		this.name = name;
		setChanged();	
		notifyObservers();
	}

	public String getPassword() {
		System.out.println("set password / researcher");
		return password;
	}
	public void setPassword(String password) {
		System.out.println("set password / researcher");
		this.password = password;
		setChanged();	
		notifyObservers();
	}
	public String[] getFollowingResearcherNames() {
		return followingResearcherNames;
	}
	public void setFollowingResearcherNames(String[] followingResearcherNames) {
		this.followingResearcherNames = followingResearcherNames;
	}
	public String[] getFollowerResearcherNames() {
		return followerResearcherNames;
	}
	public void setFollowerResearcherNames(String[] followerResearcherNames) {
		this.followerResearcherNames = followerResearcherNames;
	}

    public void isValidUser() {
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
                  if (username.equals(this.name) && password.equals(this.password)) {
                	  loggedIn = true;
                  }
               }
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
        System.out.println("is valid /researcher");
        System.out.println("loggedIn: "+ loggedIn);
		setChanged();	
		notifyObservers();
    }
	public boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
		System.out.println("setloggedin /researcher");
		setChanged();	
		notifyObservers();
	}
}
