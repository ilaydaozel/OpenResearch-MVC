package model;

import java.util.*;

@SuppressWarnings("deprecation")
public class Researcher extends java.util.Observable{
	private String username;
	private String password;
	private ArrayList<String> followingResearchers;
	private ArrayList<String> followerResearchers;
	private ArrayList<ReadingList> readingLists;
	
	
	public Researcher(String username, String password) {
		this.username = username;
		this.password = password;
		this.followingResearchers = new ArrayList<String>();
		this.followerResearchers = new ArrayList<String>();
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

	public ArrayList<String> getFollowingResearchers() {
		return followingResearchers;
	}
	public void setFollowingResearchers(ArrayList<String> followingResearchers) {
		this.followingResearchers = followingResearchers;
	}
	public ArrayList<String> getFollowerResearchers() {
		return followerResearchers;
	}
	public void setFollowerResearchers(ArrayList<String> followerResearchers) {
		this.followerResearchers = followerResearchers;
	}
	public ArrayList<ReadingList> getReadingLists() {
		return readingLists;
	}
	public void setReadingLists(ArrayList<ReadingList> readingLists) {
		this.readingLists = readingLists;
	}
	
	public void follow(Researcher researcher) {
		this.followingResearchers.add(researcher.getUsername());
		researcher.getFollowerResearchers().add(username);
		System.out.println(this.username + " Followed " + researcher.getUsername());
		System.out.println(this.username + " Following list " + this.followingResearchers.toString());
	}
		
	public void unfollow(Researcher researcher) {
		this.followingResearchers.remove(researcher.getUsername());
		researcher.getFollowerResearchers().remove(username);
		System.out.println(this.username + " Unfollowed " + researcher.getUsername());
		System.out.println(this.username + " Follower list " + this.followingResearchers.toString());
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
