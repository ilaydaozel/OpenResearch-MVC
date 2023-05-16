package model;

import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Researcher extends java.util.Observable {
	private String username;
	private String password;
	private ArrayList<Researcher> followingResearchers;
	private ArrayList<Researcher> followerResearchers;
	private ArrayList<ReadingList> readingLists;
	private boolean loggedIn = false;
	
	public Researcher(String username, String password) {
		this.username = username;
		this.password = password;
		this.followingResearchers = new ArrayList<Researcher>();
		this.followerResearchers = new ArrayList<Researcher>();
		this.readingLists = new ArrayList<ReadingList>();
		
	};
	public String getUsername() {
		System.out.println("get name / researcher");
		return username;
	}
	public void setUsername(String name) {
		System.out.println("set name / researcher");
		this.username = name;
		setChanged();	
		notifyObservers();
	}

	public String getPassword() {
		System.out.println("get password / researcher");
		return password;
	}
	public void setPassword(String password) {
		System.out.println("set password / researcher");
		this.password = password;
		setChanged();	
		notifyObservers();
	}

	public ArrayList<Researcher> getFollowingResearchers() {
		return followingResearchers;
	}
	public void setFollowingResearchers(ArrayList<Researcher> followingResearchers) {
		this.followingResearchers = followingResearchers;
	}
	public ArrayList<Researcher> getFollowerResearchers() {
		return followerResearchers;
	}
	public void setFollowerResearchers(ArrayList<Researcher> followerResearchers) {
		this.followerResearchers = followerResearchers;
	}
	public ArrayList<ReadingList> getReadingLists() {
		return readingLists;
	}
	public void setReadingLists(ArrayList<ReadingList> readingLists) {
		this.readingLists = readingLists;
	}

	public void reset() {
		System.out.println("reset");
		this.username="";
		this.password ="";
		//following follower ekle
		setChanged();	
		notifyObservers();
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
                  if (username.equals(this.username) && password.equals(this.password)) {
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
