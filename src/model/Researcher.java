package model;

import interfaces.Observer;
import interfaces.Observable;
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

public class Researcher implements Observable {
	private String name;
	private String password;
	private String[] followingResearcherNames;
	private String[] followerResearcherNames;
	private List<Observer> observers = new ArrayList<>();
	
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
		//setChanged();
		notifyObservers();
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
    public void addObserver(Observer observer) {
	   System.out.println("add observers / researcher");
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
    	System.out.println("notify observers / researcher");
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
    
    public boolean isValidUser() {
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
                	  return true;
                  }
               }
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
        return false;
        /*        String filePath = "users.txt";
        try {
            File inputFile = new File("users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("researcher");
            System.out.println("----------------------------");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               System.out.println("\nCurrent Element :" + nNode.getNodeName());
               
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;

                  System.out.println("researcher_name : " 
                     + eElement
                     .getElementsByTagName("researcher_name")
                     .item(0)
                     .getTextContent());
                  System.out.println("password : " 
                     + eElement
                     .getElementsByTagName("password")
                     .item(0)
                     .getTextContent());
                  System.out.println("following_researcher_names : " 
                     + eElement
                     .getElementsByTagName("following_researcher_names")
                     .item(0)
                     .getTextContent());
                  System.out.println("follower_researcher_names : " 
                     + eElement
                     .getElementsByTagName("follower_researcher_names")
                     .item(0)
                     .getTextContent());
               }
            }
         } catch (Exception e) {
            e.printStackTrace();
         }*/
    }
}
