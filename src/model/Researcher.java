package model;

import java.util.*;

import fileIO.XmlFileIO;
import interfaces.IFileWriter;

public class Researcher extends java.util.Observable{
	private String username;
	private String password;
	private List<Object> followingResearchers;
	private List<Object> followerResearchers;
	private List<Object> readingLists;
	
	public Researcher() {
		this.username = "";
		this.password = "";
		this.followingResearchers = new ArrayList<>();
		this.followerResearchers = new ArrayList<>();
		this.readingLists = new ArrayList<>();
	};
	
	public Researcher(String username, String password,
					List<Object> followingResearchers,List<Object> followerResearchers) {
		this.username = username;
		this.password = password;
		this.followingResearchers = followingResearchers;
		this.followerResearchers = followerResearchers;
		this.readingLists = new ArrayList<>();
		
	};

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String name) {
		this.username = name;
		setChanged();	
		notifyObservers();
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		setChanged();	
		notifyObservers();
	}
    public void updateXmlFile() {
    	
    	String xmlFilePath = "src/users.xml";
        IFileWriter xmlFileIO = new XmlFileIO();
        xmlFileIO.updateFile(xmlFilePath, this);
		setChanged();	
		notifyObservers();
    }

	public void follow(Researcher researcher) {
		this.followingResearchers.add(researcher.getUsername());
		researcher.getFollowerResearchers().add(username);
		updateXmlFile();
		setChanged();	
		notifyObservers();
	}
		
	public void unfollow(Researcher researcher) {
		this.followingResearchers.remove(researcher.getUsername());
		researcher.getFollowerResearchers().remove(username);
		updateXmlFile();
		setChanged();	
		notifyObservers();
	}
	
	public void addNewReadingList(ReadingList newReadingList) {
		readingLists.add(newReadingList);
		System.out.println("added new reading list /researcher: " + newReadingList.getReadingListName());
		setChanged();	
		notifyObservers();
	}
	
	public void removeReadingList(ReadingList readingList) {
		readingLists.remove(readingList);
		setChanged();	
		notifyObservers();
	}
	public String toString() {
		return username;
	}
	public List<Object> getFollowingResearchers() {
		return followingResearchers;
	}
	public void setFollowingResearchers(List<Object> followingResearchers) {
		this.followingResearchers = followingResearchers;
		setChanged();	
		notifyObservers();
	}
	public List<Object> getFollowerResearchers() {
		return followerResearchers;
	}
	public void setFollowerResearchers(List<Object> followerResearchers) {
		this.followerResearchers = followerResearchers;
		setChanged();	
		notifyObservers();
	}
	public List<Object> getReadingLists() {
		return readingLists;
	}
	public void setReadingLists(List<Object> readingLists) {
		this.readingLists = readingLists;
		setChanged();	
		notifyObservers();
	}
	public boolean addToReadingList(String readingListName, String paperName) {
	    // Find the ReadingList object with the given readingListName
	    for (Object obj : readingLists) {
	        if (obj instanceof ReadingList) {
	            ReadingList readingList = (ReadingList) obj;
	            if (readingList.getReadingListName().equals(readingListName)) {
	                // Check if the paperName already exists in the nameOfPapers list
	                if (readingList.getNameOfPapers().contains(paperName)) {
	                    return false; // Return 0 if the paper name already exists
	                }
	                // Add the paperName to the nameOfPapers list
	                readingList.getNameOfPapers().add(paperName);
	                return true; // Return 1 to indicate success
	            }
	        }
	    }
	    // If the reading list is not found, you can handle the case accordingly
	    System.out.println("Reading list '" + readingListName + "' not found.");
	    return false; // Return -1 to indicate failure
	}
	public boolean removeFromReadingList(String readingListName, String paperName) {
	    // Find the ReadingList object with the given readingListName
	    for (Object obj : readingLists) {
	        if (obj instanceof ReadingList) {
	            ReadingList readingList = (ReadingList) obj;
	            if (readingList.getReadingListName().equals(readingListName)) {
	                // Check if the paperName exists in the nameOfPapers list
	                if (readingList.getNameOfPapers().contains(paperName)) {
	                    // Remove the paperName from the nameOfPapers list
	                    readingList.getNameOfPapers().remove(paperName);
	                    return true; // Return 1 to indicate success
	                } else {
	                    return false; // Return 0 if the paper name doesn't exist
	                }
	            }
	        }
	    }
	    // If the reading list is not found, you can handle the case accordingly
	    System.out.println("Reading list '" + readingListName + "' not found.");
	    return false; // Return -1 to indicate failure
	}

	
}
