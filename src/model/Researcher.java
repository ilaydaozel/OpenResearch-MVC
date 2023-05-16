package model;

import java.util.*;

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
	public boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
		System.out.println("setloggedin /researcher");
		setChanged();	
		notifyObservers();
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
    	ResearcherCollection researcherList = new ResearcherCollection();
    	System.out.println(" researcherList:" + researcherList.getResearchersList());
    	for (Researcher researcher : researcherList.getResearchersList()) {
    		 if (researcher.getUsername().equals(this.username) && researcher.getPassword().equals(this.password)) {
           	  loggedIn = true;
             }
    	}
        System.out.println("is valid /researcher");
        System.out.println("loggedIn: "+ loggedIn);
		setChanged();	
		notifyObservers();
    }
	
	public void follow(Researcher researcher) {
		//implement later
	}
	
	
	public void unfollow(Researcher researcher) {
		//implement later
	}
	
	public void addNewReadingList(String name) {
		readingLists.add(new ReadingList(name, this));
	}
	
	public void removeReadingList(ReadingList readingList) {
		readingLists.remove(readingList);
	}
	public String toString() {
		return username;
	}
}
