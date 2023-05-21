package model;

import java.util.*;

import fileIO.XmlFileIO;
import interfaces.IFileWriter;

@SuppressWarnings("deprecation")
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
	
}
